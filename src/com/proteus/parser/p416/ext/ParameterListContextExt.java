package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.ParameterListContext;

public class ParameterListContextExt extends AbstractBaseExt{

	public ParameterListContextExt(ParameterListContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (ParameterListContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).parameterList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ParameterListContext){
				addToContexts((ParameterListContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ParameterListContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
