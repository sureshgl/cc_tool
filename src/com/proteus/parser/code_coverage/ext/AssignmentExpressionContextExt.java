package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.AssignmentExpressionContext;

public class AssignmentExpressionContextExt extends AbstractBaseExt{

	@Getter private AssignmentExpressionContext ctx;

	public AssignmentExpressionContextExt(AssignmentExpressionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).assignmentExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof AssignmentExpressionContext){
				this.ctx = (AssignmentExpressionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+AssignmentExpressionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
