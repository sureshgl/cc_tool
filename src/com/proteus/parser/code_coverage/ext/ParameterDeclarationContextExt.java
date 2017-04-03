package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.ParameterDeclarationContext;

public class ParameterDeclarationContextExt extends AbstractBaseExt{

	@Getter private ParameterDeclarationContext ctx;

	public ParameterDeclarationContextExt(ParameterDeclarationContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).parameterDeclaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ParameterDeclarationContext){
				this.ctx = (ParameterDeclarationContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ParameterDeclarationContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
