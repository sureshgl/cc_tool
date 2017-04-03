package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.IncludeDirectivesContext;

public class IncludeDirectivesContextExt extends AbstractBaseExt{

	@Getter private IncludeDirectivesContext ctx;

	public IncludeDirectivesContextExt(IncludeDirectivesContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).includeDirectives());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof IncludeDirectivesContext){
				this.ctx = (IncludeDirectivesContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+IncludeDirectivesContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
