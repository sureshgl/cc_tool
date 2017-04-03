package com.proteus.parser.p416.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proteus.parser.p416.gen.p416Parser.ParserStateContext;

public class StatesInfo {

	private static final Logger L = LoggerFactory.getLogger(StatesInfo.class);
	private Map<String,ParserStateContext> states;

	public StatesInfo(){
		states = new HashMap<String,ParserStateContext>();
	}

	public void add(String name,ParserStateContext state){
		states.put(name,state);
	}

	public ParserStateContext getState(String name){
		return states.get(name);
	}

	public ParserStateContext getCustomState(String name){
		return states.get(name);
	}

	/*
	public void process(SymbolTable st,String name, File outDir) {
		for(String stateName : states.keySet()){
			getState(stateName).extendedContext.process(states.get(stateName),st,this);
		}
		//findPaths(outDir);
		File file = new File(outDir+"/out.cpp");
		spitTopFile(file,name);
	}
	*/
	/*
	private void spitTopFile(File file,String name) {
		StringBuilder sb = new StringBuilder();
		String tab = "    ";
		sb.append("string "+name+"(){\n");
		sb.append(tab+"std::stringstream ss;\n");
		sb.append(tab+"ss << \"{\";\n");
		CustomState cs = states.get("start");
		spitTopFile(cs, sb,tab,file);
		sb.append(tab+"ss << \"}\";\n");
		sb.append(tab+"return ss.str();\n");
		sb.append("}\n");
		FileUtils.AppendToFile(file, sb.toString());
		FileUtils.AppendToFile(file, "\nint main(){}\n");
	}

	private void spitTopFile(CustomState cs,StringBuilder sb,String tab,File file) {
		for(Accept accept : cs.getSequence()){
			sb.append(tab+accept.getType()+" "+accept.getType()+"_obj;\n");
			sb.append(tab+accept.getType()+"_obj.randomize();\n");
			sb.append(tab+"ss << \"\\\""+accept.getType()+"\\\" :\";\n");
			sb.append(tab+"ss << "+accept.getType()+"_obj.getJson();\n");
		}
		if(cs.hasTransition()){
			Transition b = cs.getTransition();
			if(b.hasPaths()){
				String begin = "if";
				for(Pair<String,String> p : b.getPaths().keySet()){
					String[] splits = p.first().split("\\.");
					if(splits.length != 2){
						L.warn("something wrong with the constraint");
					}
					String condition = splits[0]+"_obj."+splits[1]+".getValue() == "+p.second();
					sb.append(tab+begin+"("+condition+"){\n");
					CustomState cs_l1 = b.getPaths().get(p);
					spitTopFile(cs_l1,sb,tab+tab,file);
					sb.append(tab+"}\n");
					begin = "else if";
				}
				
			} else {
				CustomState cs_l1 = b.getDirectState();
				spitTopFile(cs_l1, sb, tab, file);
			}
		}
	}
	*/
//	private void findPaths(File outDir) {
//		CustomState cs = states.get("start");
//		File file = new File(outDir+"/out.cpp");
//		FileUtils.CreateNewFile(file);
//		List<String> stack = new ArrayList<String>();
//		List<Pair<String,String>> constraints = new ArrayList<Pair<String,String>>();
//		findPaths(cs, stack,constraints,file);
//		FileUtils.AppendToFile(file, "int main(){}\n");
//	}
//	
//	private void findPaths(CustomState cs,List<String> stack,List<Pair<String,String>> constraints, File outFile){
//		for(Accept accept : cs.getSequence()){
//			ClassStructure c = SingletonClassStructure.getInstance().getClass(accept.getType());
//			stack.add(c.getName());
//		}
//		if(cs.hasTransition()){
//			Transition b = cs.getTransition();
//			if(b.hasPaths()){
//				Map<Pair<String,String>,CustomState> transition = b.getPaths();
//				for(Pair<String,String> key : transition.keySet()){
//					String[] splits = key.first().split("\\.");
//					if(splits.length != 2){
//						L.warn("something wrong in the constraint; splitting");
//					}
//					constraints.add(key);
//					CustomState cs1 = transition.get(key);
//					findPaths(cs1,stack,constraints,outFile);
//				}
//			} else {
//				CustomState cs1 = b.getDirectState();
//				findPaths(cs1,stack,constraints,outFile);
//			}
//		} else {
//			printStack(stack,constraints, outFile);
//			stack = new ArrayList<String>();
//		}
//	}
//	
//	public void printStack(List<String> stack,List<Pair<String,String>> constraints,File outFile){
//		StringBuilder sb = new StringBuilder();
//		String methodname = "top";
//		String tab = "    ";
//		for(String name : stack){
//			sb.append(tab+name+" "+name+"_obj;\n");
//		}
//		for(Pair<String,String> consPair : constraints){
//			String[] splits = consPair.first().split("\\.");
//			if(splits.length != 2){
//				L.warn("something wrong with the constraint");
//			}
//			sb.append(tab+splits[0]+"_obj.constraint("+splits[0]+"_obj."+splits[1]+"() == "+consPair.second()+");\n");
//		}
//		for(String name : stack){
//			sb.append(tab+name+"_obj.randomize();\n");
//		}
//		sb.append(tab+"std::stringstream ss;\n");
//		sb.append(tab+"ss << \"{\";\n");
//		String prefix = "";
//		for(String key : stack){
//			methodname += "_"+key;
//			if(!prefix.equals("")){
//				sb.append(tab+"ss << \",\";\n");
//			}
//			prefix = ",";
//			sb.append(tab+"ss << \"\\\""+key+"\\\" :\";\n");
//			sb.append(tab+"ss << "+key+"_obj.getJson();\n");
//		}
//		sb.append(tab+"ss << \"}\";\n");
//		sb.append(tab+"return ss.str();\n");
//		FileUtils.AppendToFile(outFile, "string "+methodname+"(){\n"+sb.toString()+"}\n\n");
//	}
	
	public boolean contains(String name) {
		return states.keySet().contains(name);
	}

}
