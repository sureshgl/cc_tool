package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.LogicalAndExpressionContext;

public class LogicalAndExpressionContextExt extends AbstractBaseExt{

	@Getter private LogicalAndExpressionContext ctx;

	public LogicalAndExpressionContextExt(LogicalAndExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).logicalAndExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof LogicalAndExpressionContext){
				this.ctx = (LogicalAndExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+LogicalAndExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
