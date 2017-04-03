package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.ExternalDeclarationContext;

public class ExternalDeclarationContextExt extends AbstractBaseExt{

	@Getter private ExternalDeclarationContext ctx;

	public ExternalDeclarationContextExt(ExternalDeclarationContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).externalDeclaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ExternalDeclarationContext){
				this.ctx = (ExternalDeclarationContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ExternalDeclarationContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
