package com.baizhi.cmfz.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static java.sql.Date utilToSql(java.util.Date utilDate){
		return new java.sql.Date(utilDate.getTime());
	}
	
	public static java.util.Date strToUtil(String strDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.sql.Date strToSql(String strDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return new java.sql.Date(sdf.parse(strDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public static String toString(java.util.Date utilDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(utilDate);
	}
}
