package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.StructDeclarationListContext;

public class StructDeclarationListContextExt extends AbstractBaseExt{

	@Getter private StructDeclarationListContext ctx;

	public StructDeclarationListContextExt(StructDeclarationListContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).structDeclarationList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof StructDeclarationListContext){
				this.ctx = (StructDeclarationListContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+StructDeclarationListContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
