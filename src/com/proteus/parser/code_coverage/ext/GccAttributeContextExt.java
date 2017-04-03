package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.GccAttributeContext;

public class GccAttributeContextExt extends AbstractBaseExt{

	@Getter private GccAttributeContext ctx;

	public GccAttributeContextExt(GccAttributeContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).gccAttribute());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof GccAttributeContext){
				this.ctx = (GccAttributeContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+GccAttributeContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
