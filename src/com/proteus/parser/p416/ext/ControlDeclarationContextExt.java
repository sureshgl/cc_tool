package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.ControlDeclarationContext;

public class ControlDeclarationContextExt extends AbstractBaseExt{

	public ControlDeclarationContextExt(ControlDeclarationContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (ControlDeclarationContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).controlDeclaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ControlDeclarationContext){
				addToContexts((ControlDeclarationContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ControlDeclarationContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	public String getNextStateFromIngress(){
		ControlDeclarationContext ctx = (ControlDeclarationContext) getContext();
		if(ctx.controlTypeDeclaration().name().getText().equals("ingress")){
			return ctx.controlBody().extendedContext.getNextStateFromIngress();
		}
		return null;
	}
}
