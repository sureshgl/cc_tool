package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.ArgumentExpressionListContext;

public class ArgumentExpressionListContextExt extends AbstractBaseExt{

	@Getter private ArgumentExpressionListContext ctx;

	public ArgumentExpressionListContextExt(ArgumentExpressionListContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).argumentExpressionList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ArgumentExpressionListContext){
				this.ctx = (ArgumentExpressionListContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ArgumentExpressionListContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
