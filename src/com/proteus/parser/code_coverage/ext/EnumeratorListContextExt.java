package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.EnumeratorListContext;

public class EnumeratorListContextExt extends AbstractBaseExt{

	@Getter private EnumeratorListContext ctx;

	public EnumeratorListContextExt(EnumeratorListContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).enumeratorList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof EnumeratorListContext){
				this.ctx = (EnumeratorListContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+EnumeratorListContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
