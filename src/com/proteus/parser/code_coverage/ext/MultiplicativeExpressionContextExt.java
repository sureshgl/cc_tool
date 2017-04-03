package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.MultiplicativeExpressionContext;

public class MultiplicativeExpressionContextExt extends AbstractBaseExt{

	@Getter private MultiplicativeExpressionContext ctx;

	public MultiplicativeExpressionContextExt(MultiplicativeExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).multiplicativeExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof MultiplicativeExpressionContext){
				this.ctx = (MultiplicativeExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+MultiplicativeExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
