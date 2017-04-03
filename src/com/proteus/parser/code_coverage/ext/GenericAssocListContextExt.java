package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.GenericAssocListContext;

public class GenericAssocListContextExt extends AbstractBaseExt{

	@Getter private GenericAssocListContext ctx;

	public GenericAssocListContextExt(GenericAssocListContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).genericAssocList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof GenericAssocListContext){
				this.ctx = (GenericAssocListContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+GenericAssocListContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
