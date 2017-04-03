package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.DeclarationSpecifierContext;

public class DeclarationSpecifierContextExt extends AbstractBaseExt{

	@Getter private DeclarationSpecifierContext ctx;

	public DeclarationSpecifierContextExt(DeclarationSpecifierContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).declarationSpecifier());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof DeclarationSpecifierContext){
				this.ctx = (DeclarationSpecifierContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+DeclarationSpecifierContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
