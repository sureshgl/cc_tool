package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.StructOrUnionContext;

public class StructOrUnionContextExt extends AbstractBaseExt{

	@Getter private StructOrUnionContext ctx;

	public StructOrUnionContextExt(StructOrUnionContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).structOrUnion());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof StructOrUnionContext){
				this.ctx = (StructOrUnionContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+StructOrUnionContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
