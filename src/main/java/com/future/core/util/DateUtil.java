package com.future.core.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 日期操作辅助类
 * 
 * @author: zhaowp
 */
public final class DateUtil {
	
	private final static Logger log = Logger.getLogger(DateUtil.class);

	private DateUtil() {
	}
	public static String getNowDayString(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = new Date();
		String time = format.format(date);
		return time;
	}
	
	public static String getNowNextDayString(){ 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = new Date();
		String time = format.format(date.getTime()+86400000);
		return time;
	}
	
	public static String getNowMonthFirstDayString(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar   cal_1=Calendar.getInstance();//获取当前日期 
		cal_1.add(Calendar.MONTH, 0);
		cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		String firstDay = format.format(cal_1.getTime());
		return firstDay;
	}
	
	public static Date getNowDay(){
		return new Date();
	}
	
	public static Date getNowMonthFirstDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar   cal_1=Calendar.getInstance();//获取当前日期 
		cal_1.add(Calendar.MONTH, 0);
		cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		String firstDay = format.format(cal_1.getTime());
		Date date = null;
		try {
			date = format.parse(firstDay);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date getNowNextDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Date time = null;
		try {
			time = format.parse(Long.toString(date.getTime()+86400000));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return time;
	}
	
	public static String getDateString(String type){
		if("day".equals(type)){
			return getNowDayString();
		}else if("month".equals(type)){
			return getNowMonthFirstDayString();
		}else{
			return "1970-01-01";
		}
	}
}
