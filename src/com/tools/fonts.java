package com.tools;

import java.io.UnsupportedEncodingException;

public class fonts {
	public static String convertToutf8(String s){
		if(s==null)
			return null;
		else{
			try {
				s = new String(s.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s;
		}
		
	}
	
	public static String htmlspecialchars(String str) {
		if(str==null) return null;
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
}
