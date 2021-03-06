package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.HeaderUnionDeclarationContext;

public class HeaderUnionDeclarationContextExt extends AbstractBaseExt{

	public HeaderUnionDeclarationContextExt(HeaderUnionDeclarationContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (HeaderUnionDeclarationContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).headerUnionDeclaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof HeaderUnionDeclarationContext){
				addToContexts((HeaderUnionDeclarationContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+HeaderUnionDeclarationContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
