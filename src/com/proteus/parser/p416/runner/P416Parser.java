package com.proteus.parser.p416.runner;

import lombok.Data;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proteus.parser.p416.gen.p416Lexer;
import com.proteus.parser.p416.gen.p416Parser;
import com.proteus.parser.p416.gen.p416Parser.InputContext;
import com.proteus.parser.p416.ExtendedContextVisitor;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.ext.AbstractBaseExt;
import com.proteus.parser.p416.ext.InputContextExt;

@Data
public class P416Parser {

	private static final Logger L = LoggerFactory.getLogger(P416Parser.class);
	
	public InputContext getModule(String text,String FileName){
		L.info("trying to parse "+FileName);
		ParserRuleContext p = trySLLContent(text);
		if(p==null){
			p = tryLLContent(text);
		}
		if(p!=null){
			PopulateExtendedContextVisitor pecv = new PopulateExtendedContextVisitor();
			pecv.visit(p);
			ExtendedContextVisitor ecv = new ExtendedContextVisitor();
			AbstractBaseExt abxt = ecv.visit(p);
			InputContextExt stxt = (InputContextExt) abxt;
			if(stxt==null){
				L.warn("No context");
			}
			InputContext stc = (InputContext)stxt.getContext();
			L.warn("Done with "+FileName);
			return stc;
		}else{
			throw new IllegalStateException("Could not parse p416 file :"+FileName);
		}
	}
	
	public static ParserRuleContext parse(String content){
		ParserRuleContext p = trySLLContent(content);
		if(p==null){
			p = tryLLContent(content);
		}
		return p;
	}
	
	
	public static ParserRuleContext tryLLContent(String content){
		p416Lexer lexer = new p416Lexer(new ANTLRInputStream(content));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		p416Parser parser = new p416Parser(null);
		try{
			parser.getInterpreter().setPredictionMode(PredictionMode.LL);
			parser.setErrorHandler(new BailErrorStrategy());
			parser.setBuildParseTree(true);
			parser.setTokenStream(tokens);
			ParserRuleContext tree = parser.input();
			return tree;
		}catch(Exception e){
			L.error("Error parsing content with LL strategy");
			return null;
		}
	}
	
	public static ParserRuleContext trySLLContent(String content){
		p416Lexer lexer = new p416Lexer(new ANTLRInputStream(content));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		p416Parser parser = new p416Parser(null);
		try{
			parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
			parser.setErrorHandler(new BailErrorStrategy());
			parser.setBuildParseTree(true);
			parser.setTokenStream(tokens);
			ParserRuleContext tree = parser.input();
			return tree;
		}catch(Exception e){
			L.debug("Error parsing content with SLL strategy");
			return null;
		}
	}
	
	
}
