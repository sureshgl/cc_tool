package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.StatOrDeclListContext;

public class StatOrDeclListContextExt extends AbstractBaseExt{

	public StatOrDeclListContextExt(StatOrDeclListContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (StatOrDeclListContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).statOrDeclList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof StatOrDeclListContext){
				addToContexts((StatOrDeclListContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+StatOrDeclListContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	public String getNextStateFromIngress(){
		StatOrDeclListContext ctx = (StatOrDeclListContext) getContext();
		String t = ctx.statementOrDeclaration(0).getText();
		return t.split("\\.")[0];
	}
}
