package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.PrimaryExpressionContext;

public class PrimaryExpressionContextExt extends AbstractBaseExt{

	@Getter private PrimaryExpressionContext ctx;

	public PrimaryExpressionContextExt(PrimaryExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).primaryExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PrimaryExpressionContext){
				this.ctx = (PrimaryExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PrimaryExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
