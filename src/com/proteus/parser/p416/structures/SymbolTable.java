package com.proteus.parser.p416.structures;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SymbolTable {
	
	protected static final Logger L = LoggerFactory.getLogger(SymbolTable.class);

	public SymbolTable(){
		map = new HashMap<String,String>();
	}

	private Map<String,String> map;

	public void put(String key,String value){
		map.put(key,value);
	}

	public boolean contains(String key){
		return map.containsKey(key);
	}

	public void remove(String key) {
		map.remove(key);
	}

	public String getType(String text) {
		String[] parts = text.split("\\.");
		if(parts.length == 1){
			return text;
		} else if(map.containsKey(parts[0])){
			if(map.get(parts[0]).equals("bv")){
				return map.get(parts[0]);
			} else {
				parts[0] = map.get(parts[0]);
				return getType(join(parts,"."));
			}
		} else if(map.containsKey(parts[0]+"."+parts[1])){
			if(map.get(parts[0]+"."+parts[1]).equals("bv")){
				return parts[0]+"."+parts[1]; 
			} else {
				parts[0] = map.get(parts[0]+"."+parts[1]);
				parts[1] = null;
				return getType(join(parts,"."));
			}
		} else {
			L.warn("Soemthing wrong");
			return join(parts,".");
		}
	}
	
	public boolean isBasic(String text){
		if(map.containsKey(text)){
			if(map.get(text) == "bv"){
				return true;
			} else {
				return isBasic(map.get(text));
			}
		} else {
			return false;
		}
	}

	private String join(String[] arr,String d){
		StringBuilder sb = new StringBuilder();
		String prefix = "";
		for(int i=0;i<arr.length;i++){
			if(arr[i] != null){
				sb.append(prefix);
				prefix = d;
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}
}
