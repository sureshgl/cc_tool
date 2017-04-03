package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.FunctionSpecifierContext;

public class FunctionSpecifierContextExt extends AbstractBaseExt{

	@Getter private FunctionSpecifierContext ctx;

	public FunctionSpecifierContextExt(FunctionSpecifierContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).functionSpecifier());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof FunctionSpecifierContext){
				this.ctx = (FunctionSpecifierContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+FunctionSpecifierContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
