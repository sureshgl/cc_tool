package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.EnumerationConstantContext;

public class EnumerationConstantContextExt extends AbstractBaseExt{

	@Getter private EnumerationConstantContext ctx;

	public EnumerationConstantContextExt(EnumerationConstantContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).enumerationConstant());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof EnumerationConstantContext){
				this.ctx = (EnumerationConstantContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+EnumerationConstantContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
