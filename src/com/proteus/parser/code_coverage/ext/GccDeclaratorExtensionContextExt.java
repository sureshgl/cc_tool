package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.GccDeclaratorExtensionContext;

public class GccDeclaratorExtensionContextExt extends AbstractBaseExt{

	@Getter private GccDeclaratorExtensionContext ctx;

	public GccDeclaratorExtensionContextExt(GccDeclaratorExtensionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).gccDeclaratorExtension());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof GccDeclaratorExtensionContext){
				this.ctx = (GccDeclaratorExtensionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+GccDeclaratorExtensionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
