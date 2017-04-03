package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.TypeQualifierListContext;

public class TypeQualifierListContextExt extends AbstractBaseExt{

	@Getter private TypeQualifierListContext ctx;

	public TypeQualifierListContextExt(TypeQualifierListContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).typeQualifierList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof TypeQualifierListContext){
				this.ctx = (TypeQualifierListContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+TypeQualifierListContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
