package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.ParameterTypeListContext;

public class ParameterTypeListContextExt extends AbstractBaseExt{

	@Getter private ParameterTypeListContext ctx;

	public ParameterTypeListContextExt(ParameterTypeListContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).parameterTypeList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ParameterTypeListContext){
				this.ctx = (ParameterTypeListContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ParameterTypeListContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
