package com.proteus.parser.p416.utils;

import java.util.ArrayList;
import java.util.List;

import org.stringtemplate.v4.STGroupFile;

public class UtilsP416 {
	
	private static int c = 0;
	private static STGroupFile grp = new STGroupFile("templates/P416/parser.stg");
	
	public static List<String> getHeaders(){
		List<String> headerslist = new ArrayList<String>();
		headerslist.add("#include <iostream>");
		headerslist.add("#include <cassert>");
		headerslist.add("#include <iomanip>");
		headerslist.add("#include <csolver.h>");
		headerslist.add("#include <csolver/systemc.h>");

		headerslist.add("using sc_dt::sc_bv;");
		headerslist.add("using sc_dt::sc_uint;");
		headerslist.add("using sc_dt::sc_int;");
		headerslist.add("using sc_dt::sc_biguint;");
		headerslist.add("using namespace csolver;");
		headerslist.add("using namespace std;");
		return headerslist;
	}

	public static int getSuffix(){
		return c++;
	}
	
	public static STGroupFile getSTGgrp(){
		return grp;
	}
}
