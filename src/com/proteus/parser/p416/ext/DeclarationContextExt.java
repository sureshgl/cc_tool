package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.DeclarationContext;

public class DeclarationContextExt extends AbstractBaseExt{

	public DeclarationContextExt(DeclarationContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (DeclarationContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).declaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof DeclarationContext){
				addToContexts((DeclarationContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+DeclarationContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override
	public String getNextStateFromIngress(){
		DeclarationContext ctx = (DeclarationContext) getContext();
		if(ctx.controlDeclaration() != null){
			return ctx.controlDeclaration().extendedContext.getNextStateFromIngress();
		}
		return null;
	}
}
