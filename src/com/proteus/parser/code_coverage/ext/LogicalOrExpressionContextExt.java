package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.LogicalOrExpressionContext;

public class LogicalOrExpressionContextExt extends AbstractBaseExt{

	@Getter private LogicalOrExpressionContext ctx;

	public LogicalOrExpressionContextExt(LogicalOrExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).logicalOrExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof LogicalOrExpressionContext){
				this.ctx = (LogicalOrExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+LogicalOrExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
