package com.proteus.parser.p416.ext;

import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.ParameterContext;

public class ParameterContextExt extends AbstractBaseExt{

	public ParameterContextExt(ParameterContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (ParameterContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).parameter());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ParameterContext){
				addToContexts((ParameterContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ParameterContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override
	protected void getInputParameters(Map<String,String> parameters){
		ParameterContext ctx = (ParameterContext) getContext();
		String name = ctx.name().getText();
		String type = ctx.typeRef().getText();
		if(type == null){
			L.warn("Input parameter in a parser block is not of PrefixedType.");
		}
		parameters.put(name, type);
	}
}
