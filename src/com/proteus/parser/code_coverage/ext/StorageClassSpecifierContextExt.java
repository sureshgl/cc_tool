package com.proteus.parser.code_coverage.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.StorageClassSpecifierContext;

public class StorageClassSpecifierContextExt extends AbstractBaseExt{

	@Getter private StorageClassSpecifierContext ctx;

	public StorageClassSpecifierContextExt(StorageClassSpecifierContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).storageClassSpecifier());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof StorageClassSpecifierContext){
				this.ctx = (StorageClassSpecifierContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+StorageClassSpecifierContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
