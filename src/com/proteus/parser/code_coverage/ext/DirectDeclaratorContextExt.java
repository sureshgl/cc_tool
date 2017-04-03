package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.DirectDeclaratorContext;

public class DirectDeclaratorContextExt extends AbstractBaseExt{

	@Getter private DirectDeclaratorContext ctx;

	public DirectDeclaratorContextExt(DirectDeclaratorContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).directDeclarator());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof DirectDeclaratorContext){
				this.ctx = (DirectDeclaratorContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+DirectDeclaratorContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
