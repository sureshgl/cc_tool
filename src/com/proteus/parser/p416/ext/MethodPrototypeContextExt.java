package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.MethodPrototypeContext;

public class MethodPrototypeContextExt extends AbstractBaseExt{

	public MethodPrototypeContextExt(MethodPrototypeContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (MethodPrototypeContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).methodPrototype());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof MethodPrototypeContext){
				addToContexts((MethodPrototypeContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+MethodPrototypeContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
