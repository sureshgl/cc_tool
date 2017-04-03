package com.proteus.parser.code_coverage.ext;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import lombok.Getter;

import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser.Pragma_textContext;

public class Pragma_textContextExt extends AbstractBaseExt{

	@Getter private Pragma_textContext ctx;

	public Pragma_textContextExt(Pragma_textContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).pragma_text());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Pragma_textContext){
				this.ctx = (Pragma_textContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Pragma_textContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}

	//PRAGMALeftBracket  PRAGMADigit (  PRAGMAMinus  PRAGMADigit  )?  PRAGMARightBracket ;
	@Override
	public void getLineNumbers(List<Integer> p4LineNumbers) {
		Pragma_textContext ctx = (Pragma_textContext) getContext();
		Integer min = Integer.parseInt(ctx.PRAGMADigit().get(0).getText());
		if(ctx.PRAGMADigit().size()>1){
			Integer max = Integer.parseInt(ctx.PRAGMADigit().get(1).getText());
			for(int i =min ; i<= max;i++){
				p4LineNumbers.add(i);
			}
		}else{
			p4LineNumbers.add(min);
		}
	}
}
