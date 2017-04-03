package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.ControlLocalDeclarationsContext;

public class ControlLocalDeclarationsContextExt extends AbstractBaseExt{

	public ControlLocalDeclarationsContextExt(ControlLocalDeclarationsContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (ControlLocalDeclarationsContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).controlLocalDeclarations());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ControlLocalDeclarationsContext){
				addToContexts((ControlLocalDeclarationsContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ControlLocalDeclarationsContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
