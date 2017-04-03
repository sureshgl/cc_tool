package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.StructDeclaratorContext;

public class StructDeclaratorContextExt extends AbstractBaseExt{

	@Getter private StructDeclaratorContext ctx;

	public StructDeclaratorContextExt(StructDeclaratorContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).structDeclarator());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof StructDeclaratorContext){
				this.ctx = (StructDeclaratorContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+StructDeclaratorContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
