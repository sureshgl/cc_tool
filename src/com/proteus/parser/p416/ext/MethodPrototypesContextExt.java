package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.MethodPrototypesContext;

public class MethodPrototypesContextExt extends AbstractBaseExt{

	public MethodPrototypesContextExt(MethodPrototypesContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (MethodPrototypesContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).methodPrototypes());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof MethodPrototypesContext){
				addToContexts((MethodPrototypesContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+MethodPrototypesContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
