package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.TranslationUnitContext;

public class TranslationUnitContextExt extends AbstractBaseExt{

	@Getter private TranslationUnitContext ctx;

	public TranslationUnitContextExt(TranslationUnitContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).translationUnit());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof TranslationUnitContext){
				this.ctx = (TranslationUnitContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+TranslationUnitContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
