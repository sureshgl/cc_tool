package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.KeysetExpressionContext;

public class KeysetExpressionContextExt extends AbstractBaseExt{

	public KeysetExpressionContextExt(KeysetExpressionContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (KeysetExpressionContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).keysetExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof KeysetExpressionContext){
				addToContexts((KeysetExpressionContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+KeysetExpressionContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
