package com.proteus.parser.p416.ext;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.stringtemplate.v4.ST;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.AssignmentOrMethodCallStatementContext;
import com.proteus.parser.p416.structures.Header;
import com.proteus.parser.p416.structures.SingletonStructures;
import com.proteus.parser.p416.structures.SymbolTable;
import com.proteus.parser.p416.utils.UtilsP416;

public class AssignmentOrMethodCallStatementContextExt extends AbstractBaseExt{

	public AssignmentOrMethodCallStatementContextExt(AssignmentOrMethodCallStatementContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (AssignmentOrMethodCallStatementContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).assignmentOrMethodCallStatement());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof AssignmentOrMethodCallStatementContext){
				addToContexts((AssignmentOrMethodCallStatementContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+AssignmentOrMethodCallStatementContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override
	public void processStates(List<ST> stmts,SymbolTable st, String accept){
		AssignmentOrMethodCallStatementContext ctx = (AssignmentOrMethodCallStatementContext) getContext();
		if(ctx.lvalue().getText().contains("extract")){	
			if(ctx.argumentList().getText().equals("")){
				L.warn("no arguments passed in extract");
			} else {
				String[] args = ctx.argumentList().getText().split(",");
				if(args.length > 1){
					L.warn("more than 1 argument supplied in extract");
				} else {
					ST stmt = UtilsP416.getSTGgrp().getInstanceOf("extractLines");
					String rhs = ctx.argumentList().getText();
					String type = st.getType(rhs);
					stmt.add("headerinstance_name", type.replace("_t", ""));
					Header h = SingletonStructures.getInstance().getHeader(type);
					stmt.add("bytes",h.getBitsInBytes());
					stmt.add("lineno", ctx.start.getLine());
					stmts.add(stmt);
				}
			}
		}
	}
}
