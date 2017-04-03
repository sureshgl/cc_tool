package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.AlignmentSpecifierContext;

public class AlignmentSpecifierContextExt extends AbstractBaseExt{

	@Getter private AlignmentSpecifierContext ctx;

	public AlignmentSpecifierContextExt(AlignmentSpecifierContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).alignmentSpecifier());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof AlignmentSpecifierContext){
				this.ctx = (AlignmentSpecifierContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+AlignmentSpecifierContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
