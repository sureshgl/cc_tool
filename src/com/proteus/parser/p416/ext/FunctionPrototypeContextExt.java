package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.FunctionPrototypeContext;

public class FunctionPrototypeContextExt extends AbstractBaseExt{

	public FunctionPrototypeContextExt(FunctionPrototypeContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (FunctionPrototypeContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).functionPrototype());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof FunctionPrototypeContext){
				addToContexts((FunctionPrototypeContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+FunctionPrototypeContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
