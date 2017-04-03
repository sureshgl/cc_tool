package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.StructDeclaratorListContext;

public class StructDeclaratorListContextExt extends AbstractBaseExt{

	@Getter private StructDeclaratorListContext ctx;

	public StructDeclaratorListContextExt(StructDeclaratorListContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).structDeclaratorList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof StructDeclaratorListContext){
				this.ctx = (StructDeclaratorListContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+StructDeclaratorListContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
