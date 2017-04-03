package com.proteus.parser.p416.structures;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class SingletonStructures {

private static final SingletonStructures instance = new SingletonStructures();
    
    //private constructor to avoid client applications to use constructor
    private SingletonStructures(){
    	headers = new LinkedHashMap<String,Header>();
    }

    public static SingletonStructures getInstance(){
        return instance;
    }
    
    private Map<String,Header> headers;
    
    public void add(String name,Header h){
    	headers.put(name,h);
    }
    
    public Header getHeader(String name){
    	return headers.get(name);
    }
    
    public List<Header> getheaders(){
    	return new ArrayList<Header>(headers.values());
    }
    
    public List<Header> getMetadataHeaders(){
    	List<Header> metadataHeaders = new ArrayList<Header>();
    	for(String key:headers.keySet()){
    		if(headers.get(key).getType().equals("Struct")){
    			metadataHeaders.add(headers.get(key));
    		}
    	}
    	return metadataHeaders;
    }
}
