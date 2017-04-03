package com.proteus.parser.code_coverage.runner;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;
import lombok.Getter;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

@Data
public class CommandLineParser{
	private static final Logger L = LoggerFactory.getLogger(CommandLineParser.class);
	@Parameter()
	private List<String> parameters;

	@Parameter(names = {"-o","-output"}, description="Output file name", converter=FileNameConverter.class,required=true)
	File outputFile;
	
	@Parameter(names = {"-i","-input"}, description="Input file name", converter=FileNameConverter.class,required=true)
	File inputFile;
	
	@Parameter(names = {"-cov","-gcov"}, description="coverage report file name", converter=FileNameConverter.class,required=true)
	File covFile;
	
	@Parameter(names = {"-p4","-p4File"}, description="p4 file name", converter=FileNameConverter.class,required=true)
	File p4File;
	
	@Parameter(names = {"-pp","-prettyPrint"}, description="pretty print",required=false)
	Boolean prettyPrint = false;

	public File getOutputDir(){
		if(outputFile.getParentFile()==null)
			return new File(".");
		return outputFile.getParentFile();
	} 
	
	private File designFile;

	@Parameter(names = "-help",help=true,description="Produces this Output")
	private boolean help; 

	public static class FileNameConverter implements IStringConverter<File>{
		@Override
		public File convert(String value) {
			return new File(value);
		}

	}

	public final Integer MAX_FILES_COUNT =1000;
	@Getter
	private Path sourceFile;
	private Path basePath;
	private List<CommandLineParser> children;
	private boolean CompletedprocessingAllFOptionFiles;

	public CommandLineParser(String path) throws InvalidOptionException{
		children = new ArrayList<CommandLineParser>();
		sourceFile = FileSystems.getDefault().getPath(path).normalize();
		if ( !sourceFile.toFile().exists()){
			throw new InvalidOptionException(basePath.toString());
		}
		if ( sourceFile.toFile().isDirectory() ){
			basePath = sourceFile;
			sourceFile = null;
		}
		else{
			basePath = sourceFile.getParent();
		}
		parameters = new ArrayList<String>();
	}


	private Path getNormalizedPath(String path){
		return basePath.resolve(path).normalize();
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("parameters=\n");
		for(String param:parameters)
		{
			sb.append("\t"+param+"\n");
		}
		sb.append("includeFileList=\n");
		return sb.toString();
	}

	public static void main(String[] args) {


		Path basePath = FileSystems.getDefault().getPath("/");

		CommandLineParser clp = new CommandLineParser(new File("./").getAbsolutePath());
		try{
			System.out.println(System.setProperty(JCommander.DEBUG_PROPERTY,"debug"));
			//		JCommander jCommander = new JCommander(clp, args);
			JCommander jCommander = new JCommander(clp);
			jCommander.parse(args);
			System.out.println("Command="+jCommander.getParsedCommand());

		}
		catch(ParameterException ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println(clp);
	}

}
