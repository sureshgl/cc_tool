package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.TypeArgumentListContext;

public class TypeArgumentListContextExt extends AbstractBaseExt{

	public TypeArgumentListContextExt(TypeArgumentListContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (TypeArgumentListContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).typeArgumentList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof TypeArgumentListContext){
				addToContexts((TypeArgumentListContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+TypeArgumentListContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
