package com.proteus.parser.p416.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.stringtemplate.v4.ST;

import com.proteus.common.util.Utils.Pair;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.SelectCaseContext;
import com.proteus.parser.p416.structures.SymbolTable;
import com.proteus.parser.p416.utils.StatesInfo;
import com.proteus.parser.p416.utils.UtilsP416;

public class SelectCaseContextExt extends AbstractBaseExt{

	public SelectCaseContextExt(SelectCaseContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (SelectCaseContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).selectCase());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof SelectCaseContext){
				addToContexts((SelectCaseContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+SelectCaseContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override 
	protected void processCases(List<ST> stmts,SymbolTable st,String accept,int i,String width){
		SelectCaseContext ctx = (SelectCaseContext) getContext();
		String name = ctx.name().extendedContext.getName();
		if(name.equals("accept")){
			ST stmt = UtilsP416.getSTGgrp().getInstanceOf("returnAccept");
			stmt.add("name",accept);
			stmt.add("lineno",ctx.start.getLine());
			stmts.add(stmt);
		} else {
			ST stmt = UtilsP416.getSTGgrp().getInstanceOf("transition");
			stmt.add("i",i);
			stmt.add("next", name);
			stmt.add("size",width);
			List<String> values = new ArrayList<String>();
			String[] lhs = ctx.keysetExpression().getText().split(",");
			if(lhs.length>1){
				L.error("Multiple values to select from;");
			}
			String second_rev =  new StringBuffer(lhs[0]).reverse().toString();
			for(int j=0;j<Integer.parseInt(width);j++){
				values.add(""+second_rev.charAt(j));
			}
			stmt.add("values",values);
			stmt.add("lineno",ctx.start.getLine());
			stmts.add(stmt);
		}
	}

//	@Override
//	protected void getCases(List<Pair<String, String>> cases) {
//		SelectCaseContext ctx = (SelectCaseContext) getContext();
//		String name = ctx.name().extendedContext.getName();
//		String[] lhs = ctx.keysetExpression().getText().split(",");
//		if(lhs.length>1){
//			L.error("Multiple values to select from;");
//		}
//		cases.add(Pair.of(ctx.keysetExpression().getText(),name));
//	}
}
