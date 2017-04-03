package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.OptConstructorParametersContext;

public class OptConstructorParametersContextExt extends AbstractBaseExt{

	public OptConstructorParametersContextExt(OptConstructorParametersContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (OptConstructorParametersContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).optConstructorParameters());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof OptConstructorParametersContext){
				addToContexts((OptConstructorParametersContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+OptConstructorParametersContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
