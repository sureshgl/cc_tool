package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.SimpleKeysetExpressionContext;

public class SimpleKeysetExpressionContextExt extends AbstractBaseExt{

	public SimpleKeysetExpressionContextExt(SimpleKeysetExpressionContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (SimpleKeysetExpressionContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).simpleKeysetExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof SimpleKeysetExpressionContext){
				addToContexts((SimpleKeysetExpressionContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+SimpleKeysetExpressionContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
