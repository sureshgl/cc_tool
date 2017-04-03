package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.DeclarationSpecifiers2Context;

public class DeclarationSpecifiers2ContextExt extends AbstractBaseExt{

	@Getter private DeclarationSpecifiers2Context ctx;

	public DeclarationSpecifiers2ContextExt(DeclarationSpecifiers2Context ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).declarationSpecifiers2());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof DeclarationSpecifiers2Context){
				this.ctx = (DeclarationSpecifiers2Context) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+DeclarationSpecifiers2Context.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
