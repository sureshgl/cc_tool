package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.StaticAssertDeclarationContext;

public class StaticAssertDeclarationContextExt extends AbstractBaseExt{

	@Getter private StaticAssertDeclarationContext ctx;

	public StaticAssertDeclarationContextExt(StaticAssertDeclarationContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).staticAssertDeclaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof StaticAssertDeclarationContext){
				this.ctx = (StaticAssertDeclarationContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+StaticAssertDeclarationContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
