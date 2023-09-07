package com.cadu172.workshopmongo.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	
	public static String decodeParam(String param) {
		try {
			return URLDecoder.decode(param, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

}
