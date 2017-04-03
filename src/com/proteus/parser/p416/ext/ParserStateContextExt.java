package com.proteus.parser.p416.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.stringtemplate.v4.ST;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.ParserStateContext;
import com.proteus.parser.p416.structures.SymbolTable;
import com.proteus.parser.p416.utils.UtilsP416;

public class ParserStateContextExt extends AbstractBaseExt{

	public ParserStateContextExt(ParserStateContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (ParserStateContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).parserState());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ParserStateContext){
				addToContexts((ParserStateContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ParserStateContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override
	public void processStates(List<ST> stmts,SymbolTable st, String accept){
		ParserStateContext ctx = (ParserStateContext) getContext();
		if(ctx.extendedContext.shoudlAddBuildState()){
			ST stmt = UtilsP416.getSTGgrp().getInstanceOf("buildKey_");
			stmt.add("statename", ctx.name().getText());
			String field_instance = ctx.transitionStatement().extendedContext.getFieldInstance(st);
			field_instance = field_instance.replace("_t", "");
			stmt.add("field_instance",field_instance.replace(".", "_"));
			String lineno = ""+ctx.transitionStatement().start.getLine();
			stmt.add("lineno",lineno);
			stmts.add(stmt);
 		}
		ST state = UtilsP416.getSTGgrp().getInstanceOf("parse_state_");
		List<ST> stmts_0 = new ArrayList<ST>();
		ctx.parserStatements().extendedContext.processStates(stmts_0, st, accept);
		state.add("lineno",ctx.start.getLine()+"");
		if(ctx.transitionStatement().extendedContext.hasSelect()){
			ST transitionBegin = UtilsP416.getSTGgrp().getInstanceOf("transition_begin");
			transitionBegin.add("state_name", ctx.name().getText());
			String width = ctx.transitionStatement().extendedContext.getWidth(st);
			transitionBegin.add("width", width);
			String lineno = ""+ctx.transitionStatement().start.getLine();
			transitionBegin.add("lineno",lineno);
			stmts_0.add(transitionBegin);
		}
		ctx.transitionStatement().extendedContext.processStates(stmts_0, st, accept);
		state.add("stmts", stmts_0);
		state.add("statename",ctx.name().getText());
		stmts.add(state);
	}
}