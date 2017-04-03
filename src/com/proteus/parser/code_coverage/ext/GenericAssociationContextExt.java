package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.GenericAssociationContext;

public class GenericAssociationContextExt extends AbstractBaseExt{

	@Getter private GenericAssociationContext ctx;

	public GenericAssociationContextExt(GenericAssociationContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).genericAssociation());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof GenericAssociationContext){
				this.ctx = (GenericAssociationContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+GenericAssociationContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
