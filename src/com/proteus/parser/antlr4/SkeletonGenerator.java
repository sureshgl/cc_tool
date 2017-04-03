package com.proteus.parser.antlr4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import lombok.Data;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.proteus.common.util.FileUtils;
import com.proteus.parser.antlr4.Antlr4Reflection.RuleAlt;
import com.proteus.parser.antlr4.Antlr4Reflection.RuleNormal;
import com.proteus.parser.antlr4.Antlr4Reflection.RuleType;

public class SkeletonGenerator {

	@Data
	private static class RuleClass{
		private final String rulename;
		private final String rulebody;
		private final String classname;
		private final String rulenameclass;
	}


	private static void generateClasses(Map<String, RuleType> rules){
		int count=0;
		STGroupFile stgf = new STGroupFile("templates/javaSkeleton.stg");
		for(Entry<String,RuleType> e:rules.entrySet()){
			
			RuleType r = e.getValue();
			if(!r.isAlt()){
				
				RuleNormal rule = (RuleNormal)r;
				String rulename = rule.getRuleName();
				String rulebody = rule.getRuleBody();
				String classname = toCamelCase(rulename);
				String rulenameclass = capitalize(rulename);
				
				ST st = stgf.getInstanceOf("javaskel");
				st.add("classname", classname);
				st.add("rulebody", rulebody);
				st.add("rulename", rulename);
				st.add("rulenameclass", rulenameclass);
				FileUtils.WriteFile(new File("src/com.proteus.struct/verilog/gen/struct/"+classname+".java"), st.render());
				count++;
			}else{
				RuleAlt rule =(RuleAlt)r;
				String rulealtname=rule.getAltName();
				String rulealttext = rule.getAltText();
				String classname = toCamelCase(rulealtname);
				String rulealtnameClass = capitalize(rulealtname);
				String superclass = toCamelCase(rule.getParentRule().getRuleName());
				
				ST st = stgf.getInstanceOf("javaskel2");
				st.add("rulealtname", rulealtname);
				st.add("rulealttext", rulealttext);
				st.add("classname", classname);
				st.add("rulealtnameClass", rulealtnameClass);
				st.add("superclass", superclass);
				st.add("rulebody", rule.getParentRule().getRuleBody());
				FileUtils.WriteFile(new File("src/com.proteus.struct/verilog/gen/struct/"+classname+".java"), st.render());
				count++;
			}
		}
		System.out.println("Generated "+count+" classes");
	}
	
	public static void generateVisitorClasses(Map<String, RuleType> rules){
		STGroupFile stgf = new STGroupFile("templates/javaSkeleton.stg");
		Set<String> parents = new LinkedHashSet<>();
		for(Entry<String, RuleType> e:rules.entrySet()){
			if(e.getValue().isAlt()){
				RuleAlt r = (RuleAlt) e.getValue();
				parents.add(r.getParentRule().getRuleName());
			}
		}
		for(String s:parents){
			rules.remove(s);
			//System.out.println(s);
		}
		int count = 0;
		for(Entry<String, RuleType> e:rules.entrySet()){
			if(e.getValue().isAlt()){
				RuleAlt r = (RuleAlt) e.getValue();
				ST st = stgf.getInstanceOf("visitorskel");
				String classname = toCamelCase(r.getAltName());
				st.add("classname", classname);
				st.add("rulename", capitalize(r.getAltName()));
				st.add("ruletext", r.getAltText());
				count++;
				FileUtils.WriteFile(new File("src/com.proteus.struct/verilog/gen/visitor/"+classname+"Visitor.java"), st.render());
			}else{
				RuleNormal r = (RuleNormal) e.getValue();
				ST st = stgf.getInstanceOf("visitorskel");
				String classname = toCamelCase(r.getRuleName());
				st.add("classname", classname);
				st.add("rulename", capitalize(r.getRuleName()));
				st.add("ruletext", r.getRuleBody());
				count++;
				FileUtils.WriteFile(new File("src/com.proteus.struct/verilog/gen/visitor/"+classname+"Visitor.java"), st.render());
			}
		}
		System.out.println("Generated "+ count + " visitor classes");
		/*
		List<RuleClass> allrules = new ArrayList<>();
		for(Entry<String, RuleType> e:rules.entrySet()){
			if(e.getValue().isAlt()){
				RuleAlt r = (RuleAlt) e.getValue();
				String rulename = r.getAltName();
				String rulebody = r.getAltText();
				String classname = toCamelCase(rulename);
				String rulenameclass = capitalize(rulename);
				allrules.add(new RuleClass(rulename, rulebody, classname, rulenameclass));
			}else{
				RuleNormal r = (RuleNormal) e.getValue();
				String rulename = r.getRuleName();
				String rulebody = r.getRuleBody();
				String classname = toCamelCase(rulename);
				String rulenameclass = capitalize(rulename);
				allrules.add(new RuleClass(rulename, rulebody, classname, rulenameclass));
			}
		}
		ST st = stgf.getInstanceOf("visitor");
		st.add("rules", allrules);
		System.out.println(st.render());
		FileUtils.WriteFile(new File("src/com.proteus.struct/verilog/gen/visitor/VerilogNodeVisitor.java"), st.render());
		*/
	}

	public static void generateListenerClass(Map<String, RuleType> rules){
		STGroupFile stgf = new STGroupFile("templates/javaSkeleton.stg");
		Set<String> parents = new LinkedHashSet<>();
		for(Entry<String, RuleType> e:rules.entrySet()){
			if(e.getValue().isAlt()){
				RuleAlt r = (RuleAlt) e.getValue();
				parents.add(r.getParentRule().getRuleName());
			}
		}
		for(String s:parents){
			rules.remove(s);
			//System.out.println(s);
		}
		List<RuleClass> allrules = new ArrayList<>();
		for(Entry<String, RuleType> e:rules.entrySet()){
			if(e.getValue().isAlt()){
				RuleAlt r = (RuleAlt) e.getValue();
				String rulename = r.getAltName();
				String rulebody = r.getAltText();
				String classname = toCamelCase(rulename);
				String rulenameclass = capitalize(rulename);
				allrules.add(new RuleClass(rulename, rulebody, classname, rulenameclass));
			}else{
				RuleNormal r = (RuleNormal) e.getValue();
				String rulename = r.getRuleName();
				String rulebody = r.getRuleBody();
				String classname = toCamelCase(rulename);
				String rulenameclass = capitalize(rulename);
				allrules.add(new RuleClass(rulename, rulebody, classname, rulenameclass));
			}
		}
		ST st = stgf.getInstanceOf("listener");
		st.add("rules", allrules);
		System.out.println(st.render());
	}
	
	public static void main(String[] args) throws IOException {
		//generateClasses(Antlr4Reflection.getParserRules("grammar/Verilog.g4"));
		//generateVisitorClasses(Antlr4Reflection.getParserRules("grammar/Verilog.g4"));
		generateListenerClass(Antlr4Reflection.getParserRules("grammar/Verilog.g4"));
	}

	private static String toCamelCase(String input){
		StringBuilder sb = new StringBuilder();
		String[] parts = input.split("_");
		for(String part:parts){
			sb.append(part.substring(0, 1).toUpperCase());
			sb.append(part.substring(1));
		}
		return sb.toString();
	}

	private static String capitalize(String input){
		return input.substring(0,1).toUpperCase()+input.substring(1);
	}

}
