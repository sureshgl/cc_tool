package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.GccAttributeListContext;

public class GccAttributeListContextExt extends AbstractBaseExt{

	@Getter private GccAttributeListContext ctx;

	public GccAttributeListContextExt(GccAttributeListContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).gccAttributeList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof GccAttributeListContext){
				this.ctx = (GccAttributeListContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+GccAttributeListContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
