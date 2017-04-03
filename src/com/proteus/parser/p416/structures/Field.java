package com.proteus.parser.p416.structures;

import lombok.Data;

@Data
public class Field {

	private String name;
	private String bit_offset_hdr;
	private String byte_offset_hdr;
	private String byte_offset_phv;
	private String width;
	private String byte_width_phv;
	private String lineno;
	
	public Field(){};

}
	
	
	/*private String name;
	private String type;
	private boolean prefixedType;
	private boolean basicTypeDef;
	
	
	public Field(String name,String type){
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isPrefixedType() {
		return prefixedType;
	}
	
	public void setPrefixedType(boolean prefixedType) {
		this.prefixedType = prefixedType;
	}
	
	public String getPrefixedTypeOrDef(){
		if(isPrefixedType()){
			return getType();
		} else {
			return "bv";
		}
	}
	
	public String Print(){
		StringBuilder sb = new StringBuilder();
		if(isPrefixedType()){
			sb.append(type+ " ");
		}
		else {
			sb.append("rand_var< sc_bv < "+type+" > > ");
		}
		sb.append(name+";\n");
		return sb.toString();
	}

	public boolean isBasicTypeDef() {
		return basicTypeDef;
	}

	public void setBasicTypeDef(boolean isTypeDef) {
		this.basicTypeDef = isTypeDef;
	}
	*/
