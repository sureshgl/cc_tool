package com.proteus.parser.p416.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.stringtemplate.v4.ST;

import com.proteus.common.util.Utils.Pair;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.SelectCaseContext;
import com.proteus.parser.p416.gen.p416Parser.SelectExpressionContext;
import com.proteus.parser.p416.structures.Field;
import com.proteus.parser.p416.structures.Header;
import com.proteus.parser.p416.structures.SingletonStructures;
import com.proteus.parser.p416.structures.SymbolTable;
import com.proteus.parser.p416.utils.UtilsP416;

public class SelectExpressionContextExt extends AbstractBaseExt{

	public SelectExpressionContextExt(SelectExpressionContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (SelectExpressionContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).selectExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof SelectExpressionContext){
				addToContexts((SelectExpressionContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+SelectExpressionContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override
	protected boolean shoudlAddBuildState(){
		return true;
	}
	
	@Override
	protected boolean hasSelect(){
		return true;
	}
	
	@Override
	protected String getWidth(SymbolTable st){
		SelectExpressionContext ctx = (SelectExpressionContext) getContext();
		String[] expression = ctx.expressionList().getText().split(",");
		if(expression.length>1){
			L.error("more than 1 expression to match in transition. Not supported");
			return null;
		} else {
			String[] types = st.getType(expression[0]).split("\\.");
			Header h = SingletonStructures.getInstance().getHeader(types[0]);
			if(h == null){
				L.warn("somethign wrong. Trying to get : "+types[0]);
			}
			Field f = h.getField(types[1]);
			if(f == null){
				L.warn("somethign wrong. Trying to get : "+types[1]+" from "+types[0]);
			}
			return f.getByte_width_phv();
		}
	}
	
	@Override
	public void processStates(List<ST> stmts,SymbolTable st, String accept){
		SelectExpressionContext ctx = (SelectExpressionContext) getContext();
		int i=0;
		String width = getWidth(st);
		for(SelectCaseContext selectCaseContext : ctx.selectCaseList().selectCase()){
			selectCaseContext.extendedContext.processCases(stmts, st,accept, i++,width);
		}
	}
}
