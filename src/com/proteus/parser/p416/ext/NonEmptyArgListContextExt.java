package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.NonEmptyArgListContext;

public class NonEmptyArgListContextExt extends AbstractBaseExt{

	public NonEmptyArgListContextExt(NonEmptyArgListContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (NonEmptyArgListContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).nonEmptyArgList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof NonEmptyArgListContext){
				addToContexts((NonEmptyArgListContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+NonEmptyArgListContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
