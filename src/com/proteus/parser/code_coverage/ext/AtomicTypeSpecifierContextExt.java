package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.AtomicTypeSpecifierContext;

public class AtomicTypeSpecifierContextExt extends AbstractBaseExt{

	@Getter private AtomicTypeSpecifierContext ctx;

	public AtomicTypeSpecifierContextExt(AtomicTypeSpecifierContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).atomicTypeSpecifier());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof AtomicTypeSpecifierContext){
				this.ctx = (AtomicTypeSpecifierContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+AtomicTypeSpecifierContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
