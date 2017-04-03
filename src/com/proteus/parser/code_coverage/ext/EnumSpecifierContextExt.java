package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.EnumSpecifierContext;

public class EnumSpecifierContextExt extends AbstractBaseExt{

	@Getter private EnumSpecifierContext ctx;

	public EnumSpecifierContextExt(EnumSpecifierContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).enumSpecifier());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof EnumSpecifierContext){
				this.ctx = (EnumSpecifierContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+EnumSpecifierContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
