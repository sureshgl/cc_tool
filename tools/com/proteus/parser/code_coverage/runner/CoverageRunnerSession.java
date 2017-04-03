package com.proteus.parser.code_coverage.runner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import lombok.Data;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proteus.common.util.FileUtils;
import com.proteus.parser.code_coverage.gen.CCoverageParser.CompilationUnitContext;

@Data
public class CoverageRunnerSession {
	private static final Logger L = LoggerFactory.getLogger(CoverageRunnerSession.class);

	private File outputDir;
	private File inputFile;
	private File gcovFile;
	private File p4File;
	private Boolean prettyPrint;
	private HashMap<Integer, List<Integer>> cP4LineMap;
	private List<LineCoverageStats> coverageStats = new ArrayList<LineCoverageStats>();


	private  HashMap<File,Boolean> filePreprocessStatusMap = new HashMap<File, Boolean>();

	public CoverageRunnerSession(File outputDir,File inputFile,File gcovFile,File p4File, Boolean prettyPrint ,HashMap<Integer, List<Integer>> cP4LineMap){
		this.outputDir = outputDir;
		this.inputFile = inputFile;
		this.gcovFile  = gcovFile;
		this.p4File = p4File;
		this.prettyPrint = prettyPrint;
		this.cP4LineMap = cP4LineMap;
	}

	public void process(){
		FileParser fp = new FileParser();
		CompilationUnitContext compilationUnitContext = fp.getFileContent(this.getInputFile());
		this.cP4LineMap = new HashMap<Integer, List<Integer>>();
		compilationUnitContext.extendedContext.getCP4LinesMap(this);
		writeToFile(this.getCP4LineMap(),"out");

		Map <Integer,String> cLinesToExecutionCountMap = generateTestCoverage(this.gcovFile);
		Map <Integer,Map<Integer, String>> p4LinesToExecutionCountMap = getConsolidatedP4LineToCountMap(this.getCP4LineMap(),cLinesToExecutionCountMap);
		writeToFile(p4LinesToExecutionCountMap,"coverage");
		writeCoverageStats(p4LinesToExecutionCountMap);
		writeCoverageFile();
		writeHtmlFile();
	}

	private void writeHtmlFile(){
		StringBuilder sb = new StringBuilder();
		String colour;
		sb.append("<!DOCTYPE html>\n");
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("<style>\n");
		sb.append("table {\n");
		sb.append("		font-family: arial, sans-serif;\n");
		sb.append("		border-collapse: collapse;\n");
		sb.append("		width: 100%;\n");
		sb.append("}\n\n");

		sb.append("td, th {\n");
		sb.append("		text-align: left;\n");
		sb.append("		padding: 4px;\n");
		sb.append("}\n\n");
		
		sb.append("th { background-color:yellow; color:black; }\n\n");

		sb.append("</style>\n");
		sb.append("</head>\n");
		sb.append("<body>\n\n");
		
		sb.append("<table style=\"background-color:#FFFFE0;\">\n");
		sb.append("<tr style=\"background-color:#BDB76B;color:#ffffff;\">\n");
		
		if(this.getPrettyPrint()){
			sb.append("<th>Table Header</th><th>%of coverge</th><th>source line</th>\n");
		}
		else{
			sb.append("<th>Line No</th><th>%of coverge</th><th>source line</th><th>detailed coverage</th>\n");
		}
		sb.append("</tr>\n");
		
		for(LineCoverageStats lineCoverageStats : coverageStats){
			if(lineCoverageStats.getExecutionRate()==0){
				colour = "rgb(255, 0, 0)";
			}else{
				colour = "rgb(0, "+(256*lineCoverageStats.getExecutionRate())/100+", 0)";
			}
			sb.append("<tr>\n");
			String style = " style=\"white-space: pre; width:10px; background-color:"+colour+";\"";
			sb.append("<td"+style+">"+lineCoverageStats.getLineNum()+"</td>\n");
			sb.append("<td"+style+">"+lineCoverageStats.getExecutionRate()+"</td>\n");
			sb.append("<td"+style+">"+lineCoverageStats.getData()+"</td>\n");
			if(!this.getPrettyPrint()){
				sb.append("<td"+style+">"+lineCoverageStats.getCoverageDetails()+"</td>\n");
			}
			sb.append("</tr>\n\n");
		}
		sb.append("</table>\n\n");
		sb.append("</body>\n");
		sb.append("</html>\n");
		File coverageFile = new File(outputDir+"/coverage.html");
		FileUtils.WriteFile(coverageFile, sb);

	}

	private void writeCoverageFile() {
		StringBuilder sb = new StringBuilder();
		for(LineCoverageStats lineCoverageStats : coverageStats){
			if(this.getPrettyPrint()){
				String temp = String.format("%8d%% : %4d :  %s\n",lineCoverageStats.getExecutionRate(),lineCoverageStats.getLineNum(),lineCoverageStats.getData());
				sb.append(temp);
			}
			else {
				String temp = String.format("%8d%% : %4d :  %20s : %10s\n",lineCoverageStats.getExecutionRate(),lineCoverageStats.getLineNum(),lineCoverageStats.getData(),lineCoverageStats.getCoverageDetails());
				sb.append(temp);
			}
		}
		File coverageFile = new File(outputDir+"/coverage.txt");
		FileUtils.WriteFile(coverageFile, sb);
	}

	private void writeCoverageStats(Map<Integer, Map<Integer, String>> p4LinesToExecutionCountMap) {
		List<String> lines = FileUtils.ReadLines(this.p4File);
		for (int i=0; i<lines.size()-1;i++){
			LineCoverageStats lineCoverageStats = new LineCoverageStats();
			String executionCount;
			Integer executionRate = 0;
			if(p4LinesToExecutionCountMap.containsKey(i+1)){
				Map<Integer, String> executionCountList = p4LinesToExecutionCountMap.get(i+1);
				String countMap = "";
				Integer numOfHits = 0;
				for(Integer cline: executionCountList.keySet()){
					if(executionCountList.get(cline).equals("#####") || executionCountList.get(cline).equals("-")){
						countMap = countMap+0+"("+cline+")"+",";
					}else{
						countMap = countMap+executionCountList.get(cline)+"("+cline+")"+",";
						numOfHits++;
					}
				}
				executionCount = "    "+countMap.toString().substring(0, countMap.toString().length()-1);
				executionRate = ((numOfHits*100)/(executionCountList.keySet().size()));
			}else{
				executionCount = "    #####";
			}
			String lineText = lines.get(i);
			int lineNum = i;
			lineCoverageStats.setData(lineText);
			lineCoverageStats.setExecutionRate(executionRate);
			lineCoverageStats.setCoverageDetails(executionCount);
			lineCoverageStats.setLineNum(lineNum+1);
			coverageStats.add(lineCoverageStats);
		}
	}

	private void writeToFile(String processedText,String fileName){
		if(outputDir.exists() || outputDir.mkdirs()){ 
			File preprocessDir = new File(outputDir+"/");
			if(!preprocessDir.exists())
				preprocessDir.mkdir();
			File processedFile = new File(preprocessDir+"/"+fileName);
			FileUtils.AppendToFile(processedFile, processedText);
		}else{
			throw new RuntimeException("Couldn't create OP directory: "+outputDir.getAbsolutePath());
		}
	}

	private Map<Integer, Map<Integer, String>> getConsolidatedP4LineToCountMap(Map<Integer, List<Integer>> cLinesToP4LinesMap,
			Map<Integer, String> cLinesToExecutionCountMap) {
		Map<Integer,Map<Integer,String>> consolidatedP4LineToCountMap = new HashMap<Integer,Map<Integer,String>>();
		for (Entry<Integer,List<Integer>> entry:cLinesToP4LinesMap.entrySet()){
			int cLineNum = entry.getKey();
			List<Integer> p4LineNumList = entry.getValue();

			if (cLinesToExecutionCountMap.containsKey(cLineNum)){
				String cLineCoverage = cLinesToExecutionCountMap.get(cLineNum);
				for (int p4Line:p4LineNumList){
					Map<Integer,String> executionCountList = consolidatedP4LineToCountMap.get(p4Line);
					if (consolidatedP4LineToCountMap.containsKey(p4Line)){
						if (executionCountList!=null){
							executionCountList.put(cLineNum,cLineCoverage);
						}
					}
					else{
						executionCountList= new HashMap<Integer,String>();
						executionCountList.put(cLineNum,cLineCoverage);
					}
					consolidatedP4LineToCountMap.put(p4Line, executionCountList);
				}
			}
		}
		return consolidatedP4LineToCountMap;
	}

	private Map<Integer, String> generateTestCoverage(File gcoverageFile) {
		List<String> lines = FileUtils.ReadLines(gcoverageFile);
		Map<Integer,String> codeCoverageMapByLine = getCodeCoverageMapByLine(lines);
		return codeCoverageMapByLine;
	}

	private Map<Integer, String> getCodeCoverageMapByLine(List<String> lines) {
		Map<Integer,String> codeCoverageMapLineByLine = new HashMap<Integer,String>();
		for (String line:lines){
			StringTokenizer s = new StringTokenizer(line,":");
			if (s.countTokens()>=2){
				String token1 = s.nextToken();
				String token2 = s.nextToken();
				int lineNum = -1;
				String executionCount = null;
				try{
					executionCount = token1.trim();
				}catch(NumberFormatException nfe){
					//Do Nothing. Ignore
				}
				try{
					lineNum = Integer.parseInt(token2.trim());
				}catch(NumberFormatException nfe){
					//Do Nothing. Ignore
				}
				//if (lineNum!=-1 && executionCount!=-1){
				if (lineNum!=-1){
					codeCoverageMapLineByLine.put(lineNum, executionCount);
				}
			}
		}
		return codeCoverageMapLineByLine;
	}

	private void writeToFile(Object map,String fileName){
		if(outputDir.exists() || outputDir.mkdirs()){ 
			File outDir = new File(outputDir+"/");
			if(!outDir.exists())
				outDir.mkdir();
			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.defaultPrettyPrintingWriter();
			try {
				writer.writeValue(new File(outDir+"/"+fileName+".json"), map);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			throw new RuntimeException("Couldn't create OP directory: "+outputDir.getAbsolutePath());
		}
	}

}
