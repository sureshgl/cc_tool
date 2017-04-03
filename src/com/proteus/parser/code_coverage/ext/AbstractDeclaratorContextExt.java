package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.AbstractDeclaratorContext;

public class AbstractDeclaratorContextExt extends AbstractBaseExt{

	@Getter private AbstractDeclaratorContext ctx;

	public AbstractDeclaratorContextExt(AbstractDeclaratorContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).abstractDeclarator());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof AbstractDeclaratorContext){
				this.ctx = (AbstractDeclaratorContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+AbstractDeclaratorContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
