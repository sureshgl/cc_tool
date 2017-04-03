package com.proteus.parser.p416.ext;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.NonTypeNameContext;

public class NonTypeNameContextExt extends AbstractBaseExt{

	public NonTypeNameContextExt(NonTypeNameContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (NonTypeNameContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).nonTypeName());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof NonTypeNameContext){
				addToContexts((NonTypeNameContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+NonTypeNameContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override
    protected String getName(){
        return getContext().getText();
    }

    @Override
    protected void getNames(List<String> names){
        names.add(getContext().getText());
    }
}
