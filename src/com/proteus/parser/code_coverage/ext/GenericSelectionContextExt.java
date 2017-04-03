package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.GenericSelectionContext;

public class GenericSelectionContextExt extends AbstractBaseExt{

	@Getter private GenericSelectionContext ctx;

	public GenericSelectionContextExt(GenericSelectionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).genericSelection());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof GenericSelectionContext){
				this.ctx = (GenericSelectionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+GenericSelectionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
