package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.CompilationUnitContext;

public class CompilationUnitContextExt extends AbstractBaseExt{

	@Getter private CompilationUnitContext ctx;

	public CompilationUnitContextExt(CompilationUnitContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).compilationUnit());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof CompilationUnitContext){
				this.ctx = (CompilationUnitContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+CompilationUnitContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
