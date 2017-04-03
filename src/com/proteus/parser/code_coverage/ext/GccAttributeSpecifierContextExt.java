package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.GccAttributeSpecifierContext;

public class GccAttributeSpecifierContextExt extends AbstractBaseExt{

	@Getter private GccAttributeSpecifierContext ctx;

	public GccAttributeSpecifierContextExt(GccAttributeSpecifierContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).gccAttributeSpecifier());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof GccAttributeSpecifierContext){
				this.ctx = (GccAttributeSpecifierContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+GccAttributeSpecifierContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
