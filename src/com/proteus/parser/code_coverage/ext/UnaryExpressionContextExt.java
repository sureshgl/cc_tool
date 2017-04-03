package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.UnaryExpressionContext;

public class UnaryExpressionContextExt extends AbstractBaseExt{

	@Getter private UnaryExpressionContext ctx;

	public UnaryExpressionContextExt(UnaryExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).unaryExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof UnaryExpressionContext){
				this.ctx = (UnaryExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+UnaryExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
