package com.proteus.parser.p416.ext;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.StructFieldContext;
import com.proteus.parser.p416.structures.Field;
import com.proteus.parser.p416.structures.Header;
import com.proteus.parser.p416.structures.SymbolTable;

public class StructFieldContextExt extends AbstractBaseExt{

	public StructFieldContextExt(StructFieldContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (StructFieldContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).structField());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof StructFieldContext){
				addToContexts((StructFieldContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+StructFieldContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override
	protected void getFields(Header h,List<Field> fields,SymbolTable st){
		StructFieldContext ctx = (StructFieldContext) getContext();
		Field f = new Field();
		f.setName(ctx.name().getText());
		f.setByte_offset_hdr(Integer.toString(h.getBits()/8));
		f.setBit_offset_hdr(Integer.toString(h.getBits()%8));
		String width = ctx.typeRef().extendedContext.getSize();
		if(width == null){
			L.error("trying to get the width of a complex variable.");
			L.error("working on a header that you shouldnt be");
		} else {
			f.setWidth(width);
			int size = Integer.parseInt(width);
			String byte_width_phv = (size/8)>4 ? Integer.toString(size/8) : "4";
			f.setByte_width_phv(byte_width_phv);
			h.setBits(h.getBits()+size);
		}
		f.setLineno(Integer.toString(ctx.start.getLine()));
		fields.add(f);
	}
	
	protected void addFieldsToSt(Map<String,String> fieldMap,String name,SymbolTable st){
		StructFieldContext ctx = (StructFieldContext) getContext();
		String fieldName = ctx.name().getText();
		String width = ctx.typeRef().extendedContext.getSize();
		if(width == null){
			String type = ctx.typeRef().getText();
			st.put(name+"."+fieldName,type);
		} else {
			st.put(name+"."+fieldName,"bv");
		}
	}
}
