package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.InclusiveOrExpressionContext;

public class InclusiveOrExpressionContextExt extends AbstractBaseExt{

	@Getter private InclusiveOrExpressionContext ctx;

	public InclusiveOrExpressionContextExt(InclusiveOrExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).inclusiveOrExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof InclusiveOrExpressionContext){
				this.ctx = (InclusiveOrExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+InclusiveOrExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
