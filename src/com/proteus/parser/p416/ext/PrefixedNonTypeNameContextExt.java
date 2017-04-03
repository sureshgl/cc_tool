package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.PrefixedNonTypeNameContext;

public class PrefixedNonTypeNameContextExt extends AbstractBaseExt{

	public PrefixedNonTypeNameContextExt(PrefixedNonTypeNameContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (PrefixedNonTypeNameContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).prefixedNonTypeName());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PrefixedNonTypeNameContext){
				addToContexts((PrefixedNonTypeNameContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PrefixedNonTypeNameContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
