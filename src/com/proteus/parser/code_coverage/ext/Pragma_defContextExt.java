package com.proteus.parser.code_coverage.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import lombok.Getter;

import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.Pragma_defContext;
import com.proteus.parser.code_coverage.runner.CoverageRunnerSession;

public class Pragma_defContextExt extends AbstractBaseExt{

	@Getter private Pragma_defContext ctx;

	public Pragma_defContextExt(Pragma_defContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).pragma_def());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Pragma_defContext){
				this.ctx = (Pragma_defContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Pragma_defContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
	
	
	////PRAGMA_SPECIFIER  pragma_text  NEW_LINE
	@Override
	public void getCP4LinesMap(CoverageRunnerSession coverageRunnerSession){
		Pragma_defContext ctx = (Pragma_defContext) getContext();
		List<Integer> p4LineNumbers = new ArrayList<Integer>();
		ctx.pragma_text().extendedContext.getLineNumbers(p4LineNumbers);
		coverageRunnerSession.getCP4LineMap().put(ctx.start.getLine(), p4LineNumbers);
	}
}
