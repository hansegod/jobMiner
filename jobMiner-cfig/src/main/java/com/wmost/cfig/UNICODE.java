/**
@description  统一编码
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		
		
**/


package com.wmost.cfig;

import java.util.regex.Pattern;

//统一编码系统
public class UNICODE {
	//关键字生成相关
	public final static String JOIN 			= "	";
	public static final String 	splitChar 		= "\t"; 								//分割符
	public static final Pattern SPACE 			= Pattern.compile(splitChar);			//参数分割模板
	public static final String 	keySplited 		= "#"; 									//关键字分割符
	public static final Pattern KEY_SPLITED 	= Pattern.compile(keySplited);			//字段分割符
	
	//时间格式相关
	public static final long	dataFalshTime	= 5*60;									//数据有效性阈值
	public static final String 	DB_DATE_FORMAT	= "yyyy-MM-dd";							//数据库日期格式
	public static final String 	LOG_TIME_FORMAT	= "yyyy/MM/dd HH:mm:ss";				//日志文件时间格式
	public static final String 	LOG_DATE_FORMAT	= "yyyy/MM/dd";							//日志文件日期格式
	
	public static final int	LOG_TYPE_NUM 		= 1;
}
