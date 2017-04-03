package com.proteus.parser.verilog.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.proteus.common.util.FileUtils;
import com.proteus.parser.antlr4.Antlr4Reflection;
import com.proteus.parser.antlr4.Antlr4Reflection.RuleAlt;
import com.proteus.parser.antlr4.Antlr4Reflection.RuleNormal;
import com.proteus.parser.antlr4.Antlr4Reflection.RuleType;

public class ContextClassGenerator {

	private static void generateTestClasses(Map<String, RuleType> rules) throws FileNotFoundException {
		int count = 0;

		STGroupFile stgf = new STGroupFile("templates/p416/ClassContext.stg");
		Set<String> altRules = new LinkedHashSet<>();
		for(Entry<String, RuleType> e:rules.entrySet()){
			if(e.getValue().isAlt()){
				RuleAlt r = (RuleAlt) e.getValue();
				altRules.add(r.getParentRule().getRuleName());
			}
		}


		for(Entry<String, RuleType> e:rules.entrySet()){
			if(! e.getValue().isAlt()){
				RuleNormal r = (RuleNormal) e.getValue();

				ST st = stgf.getInstanceOf("contextClassSkel");
				String classname = toContextCase(r.getRuleName());
				st.add("classname", classname);
				st.add("rulename",r.getRuleName());
				count++;
				System.out.println(st.render());
				FileUtils.WriteFile(new File("src/com.proteus.parser/p416/ext/"+classname+"Ext.java"), st.render());

			}
		}

		System.out.println("Generated "+ count + " classes");
	}

	public static void main(String[] args) throws IOException {
		generateTestClasses(Antlr4Reflection.getParserRules("grammar/p416.g4"));
	}

	private static String toContextCase(String input){
		StringBuilder sb = new StringBuilder();
		sb.append(input.substring(0, 1).toUpperCase());
		sb.append(input.substring(1));
		sb.append("Context");
		return sb.toString();
	}


}
