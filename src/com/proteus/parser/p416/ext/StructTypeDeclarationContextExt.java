package com.proteus.parser.p416.ext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.StructTypeDeclarationContext;
import com.proteus.parser.p416.structures.Field;
import com.proteus.parser.p416.structures.Header;
import com.proteus.parser.p416.structures.SingletonStructures;
import com.proteus.parser.p416.structures.SymbolTable;

public class StructTypeDeclarationContextExt extends AbstractBaseExt{

	public StructTypeDeclarationContextExt(StructTypeDeclarationContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (StructTypeDeclarationContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).structTypeDeclaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof StructTypeDeclarationContext){
				addToContexts((StructTypeDeclarationContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+StructTypeDeclarationContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override
	public void getStructsForMethods(SymbolTable st,int offset){
		StructTypeDeclarationContext ctx = (StructTypeDeclarationContext) getContext();
		if(ctx.structFieldList().extendedContext.shouldGetAHeader()){
			Header h = new Header();
			h.setHeader_instance(ctx.name().getText());
			h.setHeader_instance_t(ctx.name().getText().replace("_t", ""));
			h.setBits(0);
			List<Field> fields = new ArrayList<Field>();
			ctx.structFieldList().extendedContext.getFields(h,fields, st);
			for(Field field:fields){
				String key = ctx.name().getText()+"."+field.getName();
				String value = "bv";
				st.put(key, value);
			}
			h.setFields(fields);
			h.setBytes();
			offset = 0;
			for(Header header : SingletonStructures.getInstance().getheaders()){
				offset += Integer.parseInt(header.getBytes());
			}
			h.setByte_offset_phv(Integer.toString(offset));
			//if(h.getBits()%8 != 0){L.error("size of a header is not a multiple of 8");}
			h.setBitsInBytes(Integer.toString((int)Math.ceil((double)h.getBits()/8)));
			h.setType("Struct");
			h.setByte_offset_phv_forFields();
			h.setLineno(""+ctx.name().start.getLine());
			SingletonStructures.getInstance().add(ctx.name().getText(),h);
		} else {
			Map<String,String> fieldMap = new HashMap<String,String>();
			ctx.structFieldList().extendedContext.addFieldsToSt(fieldMap,ctx.name().getText(),st);
		}
	}
}