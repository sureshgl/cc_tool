package com.proteus.parser.p416.structures;

import java.util.List;

import lombok.Data;

@Data
public class Header {
	
	private String header_instance;
	private String header_instance_t;
	private List<Field> fields;
	private String byte_offset_phv;
	private String bytes;
	private int bits;
	private String type;
	private String bitsInBytes;
	private String lineno;
	
	public Field getField(String name){
		for(Field f : fields){
			if(f.getName().equals(name)){
				return f;
			}
		}
		return null;
	}
	
	public void setBytes(){
		int bytes_int = 0;
		for(Field f : fields){
			bytes_int += Integer.parseInt(f.getByte_width_phv());
		}
		bytes = Integer.toString(bytes_int);
	}

	public void setByte_offset_phv_forFields(){
		int prev = Integer.parseInt(byte_offset_phv);
		for(Field f : fields){
			f.setByte_offset_phv(Integer.toString(prev));
			prev += Integer.parseInt(f.getByte_width_phv());
		}
	}
}
