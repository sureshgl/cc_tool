package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.EqualityExpressionContext;

public class EqualityExpressionContextExt extends AbstractBaseExt{

	@Getter private EqualityExpressionContext ctx;

	public EqualityExpressionContextExt(EqualityExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).equalityExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof EqualityExpressionContext){
				this.ctx = (EqualityExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+EqualityExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
