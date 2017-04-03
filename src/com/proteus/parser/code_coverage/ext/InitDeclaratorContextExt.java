package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.InitDeclaratorContext;

public class InitDeclaratorContextExt extends AbstractBaseExt{

	@Getter private InitDeclaratorContext ctx;

	public InitDeclaratorContextExt(InitDeclaratorContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).initDeclarator());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof InitDeclaratorContext){
				this.ctx = (InitDeclaratorContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+InitDeclaratorContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
