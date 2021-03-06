package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.UnaryOperatorContext;

public class UnaryOperatorContextExt extends AbstractBaseExt{

	@Getter private UnaryOperatorContext ctx;

	public UnaryOperatorContextExt(UnaryOperatorContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).unaryOperator());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof UnaryOperatorContext){
				this.ctx = (UnaryOperatorContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+UnaryOperatorContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
