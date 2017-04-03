package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.AndExpressionContext;

public class AndExpressionContextExt extends AbstractBaseExt{

	@Getter private AndExpressionContext ctx;

	public AndExpressionContextExt(AndExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).andExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof AndExpressionContext){
				this.ctx = (AndExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+AndExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
