package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.OptAnnotationsContext;

public class OptAnnotationsContextExt extends AbstractBaseExt{

	public OptAnnotationsContextExt(OptAnnotationsContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (OptAnnotationsContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).optAnnotations());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof OptAnnotationsContext){
				addToContexts((OptAnnotationsContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+OptAnnotationsContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	protected boolean shouldGetAHeader(){
		OptAnnotationsContext ctx = (OptAnnotationsContext) getContext();
		if(!ctx.getText().equals("")){
			return false;
		} else {
			return true;
		}
	}
}
