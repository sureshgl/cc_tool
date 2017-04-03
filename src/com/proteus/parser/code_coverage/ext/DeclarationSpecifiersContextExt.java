package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.DeclarationSpecifiersContext;

public class DeclarationSpecifiersContextExt extends AbstractBaseExt{

	@Getter private DeclarationSpecifiersContext ctx;

	public DeclarationSpecifiersContextExt(DeclarationSpecifiersContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).declarationSpecifiers());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof DeclarationSpecifiersContext){
				this.ctx = (DeclarationSpecifiersContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+DeclarationSpecifiersContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
