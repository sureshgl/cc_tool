package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.ExclusiveOrExpressionContext;

public class ExclusiveOrExpressionContextExt extends AbstractBaseExt{

	@Getter private ExclusiveOrExpressionContext ctx;

	public ExclusiveOrExpressionContextExt(ExclusiveOrExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).exclusiveOrExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ExclusiveOrExpressionContext){
				this.ctx = (ExclusiveOrExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ExclusiveOrExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
