package com.cadu172.workshopmongo.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
	
	public static String decodeParam(String param) {
		try {
			return URLDecoder.decode(param, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	
	public static Date converterData(String dataTXT, Date dataPadrao) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Date dataRetorno;
		try {
			dataRetorno = sdf.parse(dataTXT);
		} catch (ParseException e) {
			return dataPadrao;
		}
		
		return dataRetorno;
		
	}

}
