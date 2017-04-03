package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.ExpressionListContext;
import com.proteus.parser.p416.structures.SymbolTable;

public class ExpressionListContextExt extends AbstractBaseExt{

	public ExpressionListContextExt(ExpressionListContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (ExpressionListContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).expressionList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ExpressionListContext){
				addToContexts((ExpressionListContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ExpressionListContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	protected String getFieldInstance(SymbolTable st){
		ExpressionListContext ctx = (ExpressionListContext) getContext();
		if(ctx.expressionList() != null){
			L.error("Multiple expressions to compare");
			return null;
		} else {
			return st.getType(ctx.expression().getText());
		}
	}
}
