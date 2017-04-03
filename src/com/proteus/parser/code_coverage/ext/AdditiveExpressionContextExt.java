package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.AdditiveExpressionContext;

public class AdditiveExpressionContextExt extends AbstractBaseExt{

	@Getter private AdditiveExpressionContext ctx;

	public AdditiveExpressionContextExt(AdditiveExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).additiveExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof AdditiveExpressionContext){
				this.ctx = (AdditiveExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+AdditiveExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
