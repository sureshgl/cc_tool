package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.OptTypeParametersContext;

public class OptTypeParametersContextExt extends AbstractBaseExt{

	public OptTypeParametersContextExt(OptTypeParametersContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (OptTypeParametersContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).optTypeParameters());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof OptTypeParametersContext){
				addToContexts((OptTypeParametersContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+OptTypeParametersContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
