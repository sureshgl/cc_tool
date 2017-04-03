package com.proteus.parser.p416.ext;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.stringtemplate.v4.ST;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.StateExpressionContext;
import com.proteus.parser.p416.structures.SymbolTable;
import com.proteus.parser.p416.utils.UtilsP416;

public class StateExpressionContextExt extends AbstractBaseExt{

	public StateExpressionContextExt(StateExpressionContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (StateExpressionContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).stateExpression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof StateExpressionContext){
				addToContexts((StateExpressionContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+StateExpressionContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override
	public void processStates(List<ST> stmts,SymbolTable st, String accept){
		StateExpressionContext ctx = (StateExpressionContext) getContext();
		if(ctx.name() != null){
			if(ctx.name().getText().equals("accept")){
				ST stmt = UtilsP416.getSTGgrp().getInstanceOf("returnAccept");
				stmt.add("name", accept); 
				stmt.add("lineno",ctx.start.getLine());
				stmts.add(stmt);
			} else {
				ST stmt = UtilsP416.getSTGgrp().getInstanceOf("returnNextState");
				stmt.add("name", ctx.name().getText());
				stmt.add("lineno",ctx.start.getLine());
				stmts.add(stmt);
			}
		} else {
			ctx.selectExpression().extendedContext.processStates(stmts, st, accept);
		}
	}
}
