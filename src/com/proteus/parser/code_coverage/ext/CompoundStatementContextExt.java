package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.CompoundStatementContext;

public class CompoundStatementContextExt extends AbstractBaseExt{

	@Getter private CompoundStatementContext ctx;

	public CompoundStatementContextExt(CompoundStatementContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).compoundStatement());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof CompoundStatementContext){
				this.ctx = (CompoundStatementContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+CompoundStatementContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
