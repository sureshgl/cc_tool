package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.StructOrUnionSpecifierContext;

public class StructOrUnionSpecifierContextExt extends AbstractBaseExt{

	@Getter private StructOrUnionSpecifierContext ctx;

	public StructOrUnionSpecifierContextExt(StructOrUnionSpecifierContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).structOrUnionSpecifier());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof StructOrUnionSpecifierContext){
				this.ctx = (StructOrUnionSpecifierContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+StructOrUnionSpecifierContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
