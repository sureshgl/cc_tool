package com.proteus.parser.p416.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.proteus.common.util.FileUtils;
import com.proteus.parser.p416.gen.p416Parser.InputContext;
import com.proteus.parser.p416.structures.Field;
import com.proteus.parser.p416.structures.Header;
import com.proteus.parser.p416.structures.SingletonStructures;
import com.proteus.parser.p416.structures.SymbolTable;
import com.proteus.parser.p416.utils.UtilsP416;
import org.stringtemplate.v4.ST;

@Data
public class P416RunnerSession {
	private static final Logger L = LoggerFactory.getLogger(P416RunnerSession.class);

	private final CommandLineParser clp;
	private P416Parser mp;
	private List<File> allFiles;

	private void index(){
		File dir = clp.getOutputDir();
		allFiles = FileUtils.allFilesInDir(dir.toString(), ".p4");
	}

	public void run(){
		index();
		if((clp.getOutputDir().exists() || clp.getOutputDir().mkdirs())){
			mp = new P416Parser();
			for(File file:allFiles){
				String text = FileUtils.readFileIntoString(file,"\n");
				InputContext ctx = mp.getModule(text, file.getName());
				SymbolTable st = new SymbolTable();
				ST top = UtilsP416.getSTGgrp().getInstanceOf("Top");
				headerStgs(top,ctx,st);
			}
		}
	}
	
	private void headerStgs(ST top,InputContext ctx,SymbolTable st){
		ctx.extendedContext.getHeadersForMethods(st, 0);
		ctx.extendedContext.getStructsForMethods(st, 0);
		List<ST> stmts = new ArrayList<ST>();
		for(Header h : SingletonStructures.getInstance().getheaders()){
			ST template_0 = UtilsP416.getSTGgrp().getInstanceOf("extractHeader1");
			template_0.add("header_instance", h.getHeader_instance_t());
			template_0.add("fields",h.getFields());
			template_0.add("lineno",h.getLineno());
			stmts.add(template_0);
		}
		ST template_1 = UtilsP416.getSTGgrp().getInstanceOf("extractHeader2");
		template_1.add("headers", SingletonStructures.getInstance().getheaders());
		stmts.add(template_1);
		ST template_2 = UtilsP416.getSTGgrp().getInstanceOf("parser_extract_metadata_full");
		template_2.add("headers", SingletonStructures.getInstance().getMetadataHeaders());
		stmts.add(template_2);
		List<ST> stmts_0 = new ArrayList<ST>();
		for(Header h : SingletonStructures.getInstance().getMetadataHeaders()){
			List<ST> stmts_1 = new ArrayList<ST>();
			for(Field f: h.getFields()){
				ST line = UtilsP416.getSTGgrp().getInstanceOf("lines_forFields_parser_extract_metadata");
				line.add("field",f);
				String name = h.getHeader_instance_t()+"_"+f.getName();
				line.add("name",name);
				stmts_1.add(line);
			}
			ST block = UtilsP416.getSTGgrp().getInstanceOf("lines_ForHeaders_parser_extract_metadata");
			block.add("stmts",stmts_1);
			block.add("bitsInBytes",h.getBitsInBytes());
			stmts_0.add(block);
		}
		ST parser_extract_metadata = UtilsP416.getSTGgrp().getInstanceOf("parser_extract_metadata");
		parser_extract_metadata.add("stmts",stmts_0);
		stmts.add(parser_extract_metadata);
		
		ctx.extendedContext.processStates(stmts, st,ctx.extendedContext.getNextStateFromIngress());
		ST template_3 = UtilsP416.getSTGgrp().getInstanceOf("final");
		stmts.add(template_3);
		top.add("stmts", stmts);
		writeToFile(top.render(),"parser.c");
	}


	private void writeToFile(String processedText,String name){
		File f = new File(clp.getOutputDir()+"/"+name);
		if(f.exists()){
			FileUtils.Delete(f, true);
		}
		FileUtils.CreateNewFile(f);
		FileUtils.AppendToFile(f, processedText);
	}


	public static void main(String[] args)
	{
		CommandLineParser clp = new CommandLineParser(new File("./").getAbsolutePath());
		P416RunnerSession proteusRunnerSession = new P416RunnerSession(clp);
		JCommander jCommander = new JCommander(clp);
		jCommander.parse(args);
		proteusRunnerSession.run();
	}
}

