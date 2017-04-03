package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.ConditionalExpressionContext;

public class ConditionalExpressionContextExt extends AbstractBaseExt{

	@Getter private ConditionalExpressionContext ctx;

	public ConditionalExpressionContextExt(ConditionalExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).conditionalExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ConditionalExpressionContext){
				this.ctx = (ConditionalExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ConditionalExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
