package com.proteus.parser.p416.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.stringtemplate.v4.ST;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.ParserDeclarationContext;
import com.proteus.parser.p416.structures.SymbolTable;

public class ParserDeclarationContextExt extends AbstractBaseExt{

	public ParserDeclarationContextExt(ParserDeclarationContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (ParserDeclarationContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).parserDeclaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ParserDeclarationContext){
				addToContexts((ParserDeclarationContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ParserDeclarationContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override
	public void processStates(List<ST> stmts,SymbolTable st, String accept){
		ParserDeclarationContext ctx = (ParserDeclarationContext) getContext();
		Map<String,String> parameters = new HashMap<String,String>();
		ctx.parserTypeDeclaration().extendedContext.getInputParameters(parameters);
		for(String key : parameters.keySet()){
			st.put(key, parameters.get(key));
		}
		super.processStates(stmts, st, accept);
	}
}
