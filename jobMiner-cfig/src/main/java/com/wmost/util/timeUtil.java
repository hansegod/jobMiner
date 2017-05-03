package com.wmost.util;

import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException; 
import java.util.Calendar;


public class timeUtil {
	//时间格式相关
	public static final String 	DB_DATE_FORMAT	= "yyyy-MM-dd";							//数据库日期格式
	public static final String 	LOG_TIME_FORMAT	= "yyyy/MM/dd HH:mm:ss";				//日志文件时间格式
	
	
	//获取当前时间
	public final static String getTime(){
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(LOG_TIME_FORMAT);
        return sdf.format(d);
	}
	public final static String getTime(String format){
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
	}
	
	public final static String getFTime(String ftime){
		//将日志文件的时间格式整理为标准格式(只包含日期)
		if (	null == ftime ||
				ftime.equals("")	){
			return null;
		}
		SimpleDateFormat src = new SimpleDateFormat(LOG_TIME_FORMAT);
	    SimpleDateFormat sdf = new SimpleDateFormat(DB_DATE_FORMAT);
        Date d = null;
		try {
			d = src.parse(ftime);
		} catch (ParseException e) {
			e.printStackTrace();
			logg.Println("Date parse failed! " + e);
		}
        
        return sdf.format(d);
	}
	
	public final static String getFHour(String ftime){
		//将日志文件的时间格式整理为标准格式(只包含24小时数)
		if (	null == ftime ||
				ftime.equals("")	){
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat src = new SimpleDateFormat(LOG_TIME_FORMAT);
	    Date d = null;
		try {
			d = src.parse(ftime);
		} catch (ParseException e) {
			e.printStackTrace();
			logg.Println("Date parse failed! " + e);
		}
		calendar.setTime(d);
		
        return calendar.get(Calendar.HOUR_OF_DAY)+"";
	}
	
	public final static String getFTime(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat(DB_DATE_FORMAT);
        return sdf.format(d);
	}
	
	public final static long getTimeNowDisSecs(String ftime){
		//获取时间与当前时间的间隔秒数
		if (	null == ftime ||
				ftime.equals("")	){
			return Long.MAX_VALUE;
		}
		SimpleDateFormat src = new SimpleDateFormat(LOG_TIME_FORMAT);
	    Date d = null;
		try {
			d = src.parse(ftime);
		} catch (ParseException e) {
			e.printStackTrace();
			logg.Println("Date parse failed! " + e);
		}
		long tar = d.getTime();
		long now = System.currentTimeMillis();
		
		return Math.abs(tar - now)/(1000 * 1);
	}
	
	public final static Date paseFtime(String ftime){
		Date date = new Date();
		try  {  
		    SimpleDateFormat sdf = new SimpleDateFormat(DB_DATE_FORMAT);  
		    date = sdf.parse(ftime);
		}  
		catch (ParseException e)  {  
		    System.out.println(e.getMessage());  
		}
		return date;
	}

	@SuppressWarnings("deprecation")
	public final static String getFTime(String ftime,String fomat){
		//将日志文件的时间格式整理为标准格式
		Date d = new Date(ftime);
        SimpleDateFormat sdf = new SimpleDateFormat(fomat);
        return sdf.format(d);
	}
	
	//判断是否为数字串
	public final static boolean isNumeric(String str){ 
		Pattern pattern = Pattern.compile("[0-9]*"); 
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false; 
		} 
		return true; 
	}
	
	public static boolean isSameDayOfMillis(final long ms1, final long ms2) {
		final int SECONDS_IN_DAY = 60 * 60 * 24;
	    final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;
		final long interval = ms1 - ms2;
        return interval < MILLIS_IN_DAY
                && interval > -1L * MILLIS_IN_DAY
                && toDay(ms1) == toDay(ms2);
    }
	 private static long toDay(long millis) {
		final int SECONDS_IN_DAY = 60 * 60 * 24;
		final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;
	    return (millis + TimeZone.getDefault().getOffset(millis)) / MILLIS_IN_DAY;
	}
}
