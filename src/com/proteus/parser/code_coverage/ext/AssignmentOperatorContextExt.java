package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.AssignmentOperatorContext;

public class AssignmentOperatorContextExt extends AbstractBaseExt{

	@Getter private AssignmentOperatorContext ctx;

	public AssignmentOperatorContextExt(AssignmentOperatorContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).assignmentOperator());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof AssignmentOperatorContext){
				this.ctx = (AssignmentOperatorContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+AssignmentOperatorContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
