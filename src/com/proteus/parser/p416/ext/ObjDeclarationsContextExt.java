package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.ObjDeclarationsContext;

public class ObjDeclarationsContextExt extends AbstractBaseExt{

	public ObjDeclarationsContextExt(ObjDeclarationsContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (ObjDeclarationsContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).objDeclarations());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ObjDeclarationsContext){
				addToContexts((ObjDeclarationsContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ObjDeclarationsContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
