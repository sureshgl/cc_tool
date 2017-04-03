package com.proteus.parser.p416.ext;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Data;
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
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.proteus.common.util.Utils.Pair;
import com.proteus.parser.p416.ExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Lexer;
import com.proteus.parser.p416.gen.p416Parser;
import com.proteus.parser.p416.interfaces.GetFormattedText;
import com.proteus.parser.p416.structures.Field;
import com.proteus.parser.p416.structures.Header;
import com.proteus.parser.p416.structures.SymbolTable;
import com.proteus.parser.p416.utils.StatesInfo;

@Data
public abstract class AbstractBaseExt implements GetFormattedText{
	protected static final Logger L = LoggerFactory.getLogger(AbstractBaseExt.class);
	//variables
	private ExtendedContextVisitor extendedContextVisitor;


	@Setter(AccessLevel.NONE)
	protected List<ParserRuleContext> contexts;

	//abstract methods
	abstract public ParserRuleContext getContext();
	abstract public ParserRuleContext getContext(String str);
	abstract public void setContext(ParserRuleContext ctx);

	//constructor
	public AbstractBaseExt(){
		extendedContextVisitor = new ExtendedContextVisitor();
		contexts = new ArrayList<ParserRuleContext>();
	}

	//This method is not exposed outside.
	protected p416Parser getPrimeParser(String str){
		p416Lexer lexer = new p416Lexer(new ANTLRInputStream(str));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		return new p416Parser(tokens);
	}

	protected void addToContexts(ParserRuleContext context)
	{
		contexts.add(context);
	}


	public AbstractBaseExt getExtendedContext(ParseTree context)
	{
		if(context != null){
			return extendedContextVisitor.visit(context);
		} else{
			L.warn("Returning Null for extendedContext");
			return null;
		}
	}

	//getFormattedText() app
	@Override
	public String getFormattedText(){
		StringBuilder sb = new StringBuilder();
		Params params = new Params(getContext(), sb);
		params.setBeginingOfAlignemtText(getContext().start.getStartIndex());
		getFormattedText(params);
		//L.debug("output =\n" + sb.toString());
		return sb.toString().trim();

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
		private int beginingOfAlignemtText;

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder();

			sb.append("Context = " + context.getClass().getSimpleName() +"\n"+ context.getText()); sb.append("\n");
			sb.append("Text = "+ stringBuilder.toString()); sb.append("\n");
			sb.append("start ="+beginingOfAlignemtText); sb.append("\n");
			return sb.toString();
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

	//	public String getAmazinText(){
	//		return getAmazingText("",new StringBuilder()).first().toString();
	//	}
	//	
	//	private Pair<StringBuilder, String> getAmazingText(String alignmentText,StringBuilder sb){
	//		ParserRuleContext ctx = getContext();
	//		Boolean shouldNewLineForSemi = !((ctx.getText().split(";").length-1) >1);
	//		if(ctx != null && ctx.children != null && ctx.children.size()>0){
	//			for(ParseTree childCtx : ctx.children){
	//				if(childCtx instanceof TerminalNode){
	//					switch(childCtx.getText()){
	//					case ";": 
	//						sb.append(childCtx.getText());
	//						if(shouldNewLineForSemi){
	//							sb.append("\n"+alignmentText);
	//						} else {
	//							sb.append(" ");
	//						}
	//						break;
	//					case "begin": 
	//					case "{": 
	//						sb.append(childCtx.getText());
	//						alignmentText = alignmentText + "\t";
	//						sb.append("\n"+alignmentText);
	//						break;
	//					case "end": 
	//					case "}": 
	//						alignmentText = alignmentText.substring(0,alignmentText.length()-1);
	//						sb.deleteCharAt(sb.length()-1);
	//						sb.append(childCtx.getText());
	//						sb.append("\n"+alignmentText);
	//						break;
	//					default: 
	//						sb.append(childCtx.getText());
	//						sb.append(" ");
	//						break;
	//					}
	//				}
	//				else {
	//					Pair<StringBuilder, String> p = getExtendedContext(childCtx).getAmazingText(alignmentText,sb);
	//					sb = p.first();
	//					alignmentText = p.second();
	//				}
	//			}
	//		}
	//		return new Pair<StringBuilder, String>(sb, alignmentText);
	//	}
	
	
	public void getHeadersForMethods(SymbolTable st,int offset){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					getExtendedContext(childCtx).getHeadersForMethods(st,offset);
				}
			}
		}
	}
	
	public void getStructsForMethods(SymbolTable st,int offset){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					getExtendedContext(childCtx).getStructsForMethods(st,offset);
				}
			}
		}
	}
	
	protected void getFields(Header h,List<Field> fields,SymbolTable st){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					getExtendedContext(childCtx).getFields(h,fields,st);
				}
			}
		}
	}
	
	protected void addFieldsToSt(Map<String,String> fieldMap,String name,SymbolTable st){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					getExtendedContext(childCtx).addFieldsToSt(fieldMap,name,st);
				}
			}
		}
	}
	
	public void processStates(List<ST> stmts,SymbolTable st, String accept){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					getExtendedContext(childCtx).processStates(stmts,st, accept);
				}
			}
		}
	}
	
	protected void getInputParameters(Map<String,String> parameters){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					getExtendedContext(childCtx).getInputParameters(parameters);
				}
			}
		}
	}
	
	protected boolean hasSelect(){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					boolean out = getExtendedContext(childCtx).hasSelect();
					if(out){
						return out;
					}
				}
			}
		}
		return false;
	}
	
	protected boolean shoudlAddBuildState(){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					boolean out = getExtendedContext(childCtx).shoudlAddBuildState();
					if(out){
						return out;
					}
				}
			}
		}
		return false;
	}
	
	protected void processCases(List<ST> stmts,SymbolTable st,String accept,int i,String width){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					getExtendedContext(childCtx).processCases(stmts, st,accept, i,width);
				}
			}
		}
	}
	
	protected void getCases(List<Pair<String, String>> cases) {
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					getExtendedContext(childCtx).getCases(cases);
				}
			}
		}
	}
	
	protected String getWidth(SymbolTable st){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					String out = getExtendedContext(childCtx).getWidth(st);
					if(out != null){
						return out;
					}
				}
			}
		}
		return null;
	}
	
	public String getNextStateFromIngress(){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					String out = getExtendedContext(childCtx).getNextStateFromIngress();
					if(out != null){
						return out;
					}
				}
			}
		}
		return null;
	}
	
	protected String getFieldInstance(SymbolTable st){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					String out = getExtendedContext(childCtx).getFieldInstance(st);
					if(out != null){
						return out;
					}
				}
			}
		}
		return null;
	}
	
	protected void getNames(List<String> names){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					getExtendedContext(childCtx).getNames(names);
				}
			}
		}
	}
	
	protected String getName(){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					String out = getExtendedContext(childCtx).getName();
					if(out != null){
						return out;
					}
				}
			}
		}
		return null;
	}
	
	protected String getSize(){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					String out = getExtendedContext(childCtx).getSize();
					if(out != null){
						return out;
					}
				}
			}
		}
		return null;
	}
	
	protected boolean shouldGetAHeader(){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					boolean out = getExtendedContext(childCtx).shouldGetAHeader();
					if(!out){
						return out;
					}
				}
			}
		}
		return true;
	}
	
	protected String getPrefixedType(){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					String out = getExtendedContext(childCtx).getPrefixedType();
					if(out != null){
						return out;
					}
				}
			}
		}
		return null;
	}
	
	
}
