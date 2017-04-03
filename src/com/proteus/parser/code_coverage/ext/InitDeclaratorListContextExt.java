package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.InitDeclaratorListContext;

public class InitDeclaratorListContextExt extends AbstractBaseExt{

	@Getter private InitDeclaratorListContext ctx;

	public InitDeclaratorListContextExt(InitDeclaratorListContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).initDeclaratorList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof InitDeclaratorListContext){
				this.ctx = (InitDeclaratorListContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+InitDeclaratorListContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
