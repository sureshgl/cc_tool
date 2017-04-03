package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.PostfixExpressionContext;

public class PostfixExpressionContextExt extends AbstractBaseExt{

	@Getter private PostfixExpressionContext ctx;

	public PostfixExpressionContextExt(PostfixExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).postfixExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PostfixExpressionContext){
				this.ctx = (PostfixExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PostfixExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
