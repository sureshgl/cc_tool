package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.ControlTypeDeclarationContext;

public class ControlTypeDeclarationContextExt extends AbstractBaseExt{

	public ControlTypeDeclarationContextExt(ControlTypeDeclarationContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (ControlTypeDeclarationContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).controlTypeDeclaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ControlTypeDeclarationContext){
				addToContexts((ControlTypeDeclarationContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ControlTypeDeclarationContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}