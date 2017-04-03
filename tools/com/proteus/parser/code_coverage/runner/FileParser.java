package com.proteus.parser.code_coverage.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proteus.parser.code_coverage.ExtendedContextVisitor;
import com.proteus.parser.code_coverage.PopulateExtendedContextVisitor;
import com.proteus.parser.code_coverage.ext.AbstractBaseExt;
import com.proteus.parser.code_coverage.ext.CompilationUnitContextExt;
import com.proteus.parser.code_coverage.gen.CCoverageLexer;
import com.proteus.parser.code_coverage.gen.CCoverageParser;
import com.proteus.parser.code_coverage.gen.CCoverageParser.CompilationUnitContext;

public class FileParser {

	private static final Logger L = LoggerFactory.getLogger(FileParser.class);

	public CompilationUnitContext getFileContent(File file){
		L.info("trying to parse "+file);
		ParserRuleContext p = trySLLModule(file);
		if(p==null){
			p = tryLLModule(file);
		}
		if(p!=null){
			PopulateExtendedContextVisitor pecv = new PopulateExtendedContextVisitor();
			pecv.visit(p);
			ExtendedContextVisitor ecv = new ExtendedContextVisitor();
			AbstractBaseExt abxt = ecv.visit(p);
			CompilationUnitContextExt stxt = (CompilationUnitContextExt) abxt;
			if(stxt==null){
				L.warn("No context");
			}
			CompilationUnitContext stc = (CompilationUnitContext)stxt.getContext();
			L.warn("Done with "+file);
			return stc;
		}else{
			throw new IllegalStateException("Could not parse module :"+file);
		}
	}

	private ParserRuleContext trySLLModule(File file) {
		try {
			String moduleString = readFile(file);
			return trySLLContent(moduleString);
		} catch (IOException e) {
			L.error("Error reading file "+file);
			e.printStackTrace();
			return null;
		}
	}

	private ParserRuleContext tryLLModule(File file) {
		try {
			String moduleString = readFile(file);
			return tryLLContent(moduleString);
		} catch (IOException e) {
			L.error("Error reading file "+file);
			e.printStackTrace();
			return null;
		}
	}

	private String readFile(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				if(!line.endsWith("\\")){
					sb.append(line);
					sb.append("\n");
				}else{
					sb.append(line.substring(0, line.length()-1));
				}
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}

	public static ParserRuleContext tryLLContent(String content){
		CCoverageLexer lexer = new CCoverageLexer(new ANTLRInputStream(content));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CCoverageParser parser = new CCoverageParser(null);
		try{
			parser.getInterpreter().setPredictionMode(PredictionMode.LL);
			parser.setErrorHandler(new BailErrorStrategy());
			parser.setBuildParseTree(true);
			parser.setTokenStream(tokens);
			ParserRuleContext tree = parser.compilationUnit();
			return tree;
		}catch(Exception e){
			L.error("Error parsing content with LL strategy");
			return null;
		}
	}

	public ParserRuleContext trySLLContent(String content){
		CCoverageLexer lexer = new CCoverageLexer(new ANTLRInputStream(content));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CCoverageParser parser = new CCoverageParser(null);
		try{
			parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
			parser.setErrorHandler(new BailErrorStrategy());
			parser.setBuildParseTree(true);
			parser.setTokenStream(tokens);
			ParserRuleContext tree = parser.compilationUnit();
			return tree;
		}catch(Exception e){
			L.debug("Error parsing content with SLL strategy");
			return null;
		}
	}

	public CompilationUnitContext getStartContext(String defineIdValue){
		ParserRuleContext p = trySLLContent(defineIdValue);
		if(p==null){
			p = tryLLContent(defineIdValue);
		}
		if(p!=null){
			PopulateExtendedContextVisitor pecv = new PopulateExtendedContextVisitor();
			pecv.visit(p);
			ExtendedContextVisitor ecv = new ExtendedContextVisitor();
			AbstractBaseExt abxt = ecv.visit(p);
			CompilationUnitContextExt dtxt = (CompilationUnitContextExt) abxt;
			if(dtxt==null){
				L.warn("No context");
			}
			CompilationUnitContext stc = (CompilationUnitContext)dtxt.getContext();
			//L.warn("Done with "+defineIdValue);
			return stc;
		}else{
			throw new IllegalStateException("Could not parse content :"+defineIdValue);
		}
	}

}
