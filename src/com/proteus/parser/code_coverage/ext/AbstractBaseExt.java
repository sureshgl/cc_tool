package com.proteus.parser.code_coverage.ext;


import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proteus.parser.code_coverage.ExtendedContextVisitor;
import com.proteus.parser.code_coverage.GetFormattedText;
import com.proteus.parser.code_coverage.SetExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageLexer;
import com.proteus.parser.code_coverage.gen.CCoverageParser;
import com.proteus.parser.code_coverage.runner.CoverageRunnerSession;

@Data
public abstract class AbstractBaseExt implements GetFormattedText{
	protected static final Logger logger = LoggerFactory.getLogger(AbstractBaseExt.class);

	//variables
	private ExtendedContextVisitor extendedContextVisitor;
	private Transformation transformation = Transformation.DEFAULT;

	@Getter @Setter private AbstractBaseExt mostRecentExtendedContext;

	@Setter(AccessLevel.NONE)
	private List<ParserRuleContext> contexts;

	//abstract methods
	abstract public ParserRuleContext getContext();
	abstract public ParserRuleContext getContext(String str);
	abstract public void setContext(ParserRuleContext ctx);

	//constructor
	public AbstractBaseExt(){
		extendedContextVisitor = new ExtendedContextVisitor();
		contexts = new ArrayList<ParserRuleContext>();
	}

	public enum Transformation {
		DEFAULT;
	}

	public AbstractBaseExt getExtendedContext(ParseTree context){
		if(context != null){
			return extendedContextVisitor.visit(context);
		} else{
			return null;
		}
	}

	//This method is not exposed outside.
	protected CCoverageParser getPrimeParser(String str){
		CCoverageLexer lexer = new CCoverageLexer(new ANTLRInputStream(str));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		return new CCoverageParser(tokens);
	}

	protected void addToContexts(ParserRuleContext context)
	{
		if(context != null){
			new SetExtendedContextVisitor(this).visit(context);
			contexts.add(context);
		} else {
			contexts.add(null);
			setContext(null);
		}
	}

	@Data
	protected class Params{
		public Params( ParserRuleContext ctx, StringBuilder sb)
		{
			this.context = ctx;
			beginingOfAlignemtText = 0;
			input = ctx.start.getInputStream();
			this.stringBuilder = sb;
		}
		private ParserRuleContext context;
		private CharStream input;
		private StringBuilder stringBuilder;
		//private int endOfAlignmentText;
		private int beginingOfAlignemtText;

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder();

			sb.append("Context = " + context.getClass().getSimpleName() +"\n"+ context.getText()); sb.append("\n");
			sb.append("Text = "+ stringBuilder.toString()); sb.append("\n");
			sb.append("start ="+beginingOfAlignemtText); sb.append("\n");
			//sb.append("end = "+endOfAlignmentText);sb.append("\n");
			return sb.toString();
		}

	}

	//getFormattedText() app
	@Override
	public String getFormattedText(){
		StringBuilder sb = new StringBuilder();
		Params params = new Params(getContext(), sb);
		params.setBeginingOfAlignemtText(getContext().start.getStartIndex());
		getFormattedText(params);
		//logger.debug("output =\n" + sb.toString());
		return sb.toString();
	}

	protected void getFormattedText(Params params){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(childCtx instanceof TerminalNode){
					printTerminalNode((TerminalNode)childCtx,params);
				}
				else if(childCtx.getText().length() >0){
					params.setContext((ParserRuleContext)childCtx);
					Params thisCtxParams = getExtendedContext(childCtx).getUpdatedParams(params);
					getExtendedContext(childCtx).getFormattedText(thisCtxParams);
				}
			}
			getUpdatedParams(params);
		}
	}

	/*
	 * check if they are pointing to the same char stream, else it resets the 
	 * params with the new char stream params.
	 */

	private Params getUpdatedParams(Params params) {

		if ( getContext() == null)
		{
			//The item is removed during the transformation, hence skip its contents.
			String alignmentText = params.getInput().getText(new Interval(params.beginingOfAlignemtText, params.getContext().start.getStartIndex()-1));
			params.getStringBuilder().append(alignmentText);
			params.setBeginingOfAlignemtText(params.getContext().stop.getStopIndex() + 1); 
			return null;
		}
		if (getContext().start.getInputStream() != params.getContext().start.getInputStream())
		{
			/*
			 * advance the  begining of  alignment text, as we are going to consider 'mostRecentContext' in its place.
			 */
			if ( params.beginingOfAlignemtText  <  params.getContext().start.getStartIndex())
			{
				String alignmentText = params.getInput().getText(new Interval(params.beginingOfAlignemtText, params.getContext().start.getStartIndex()-1));
				params.getStringBuilder().append(alignmentText);
			}
			params.setBeginingOfAlignemtText(params.getContext().stop.getStopIndex() + 1); 
			return new Params(getContext(),params.getStringBuilder());
		}
		else
		{
			if (getContext().parent == null)
			{
				String alignmentText = params.getInput().getText(new Interval(params.beginingOfAlignemtText, params.getContext().start.getInputStream().size()));
				params.getStringBuilder().append(alignmentText);
			}
			params.setContext(getContext());
			return params;
		}
	}


	private void printTerminalNode(TerminalNode node,Params params){
		CharStream input = params.getContext().start.getInputStream();
		if(node.getText().equals("<EOF>")){
			String end = input.getText(new Interval(params.getBeginingOfAlignemtText(),input.size()));
			params.getStringBuilder().append(end);
		} else {
			if(params.getBeginingOfAlignemtText() < node.getSymbol().getStartIndex()){
				Interval alignmentTextInterval = new Interval(params.getBeginingOfAlignemtText(),node.getSymbol().getStartIndex()-1);
				String alignmentText = input.getText(alignmentTextInterval);
				params.getStringBuilder().append(alignmentText);
			}
			params.getStringBuilder().append(node.getText());
			params.setBeginingOfAlignemtText(node.getSymbol().getStopIndex()+1);
		}
	}

	public AbstractBaseExt getMostRecentExtendedContext(ParseTree context)
	{
		if(context != null){
			return extendedContextVisitor.visit(context).getMostRecentExtendedContext();
		} else{
			return null;
		}
	}
	
	public void getCP4LinesMap(CoverageRunnerSession coverageRunnerSession){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					getExtendedContext(childCtx).getCP4LinesMap(coverageRunnerSession);
				}
			}
		}
	}
	
	
	public void getLineNumbers(List<Integer> p4LineNumbers) {
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					getExtendedContext(childCtx).getLineNumbers(p4LineNumbers);
				}
			}
		}
	}
	
}

