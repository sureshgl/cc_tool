package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.DirectAbstractDeclaratorContext;

public class DirectAbstractDeclaratorContextExt extends AbstractBaseExt{

	@Getter private DirectAbstractDeclaratorContext ctx;

	public DirectAbstractDeclaratorContextExt(DirectAbstractDeclaratorContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).directAbstractDeclarator());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof DirectAbstractDeclaratorContext){
				this.ctx = (DirectAbstractDeclaratorContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+DirectAbstractDeclaratorContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
