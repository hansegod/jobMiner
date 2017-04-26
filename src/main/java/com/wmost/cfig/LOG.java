/**
@description  日志格式及字段编码(爬虫引擎 ----> 数据引擎)
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
**/


package com.wmost.cfig;

public class LOG {
	//该部分与com.wmost.spider.model需保持一致
	public class LOG_TYPE{
		public final static int LOG_TYPE_CANDIDATE	= 1;
		public final static int LOG_TYPE_COMPANY	= 2;
		public final static int LOG_TYPE_POSITION	= 3;
	}
	//该部分与com.wmost.spider.peline.readme.md需保持一致
	public final static String version		= "0.0.1";
	public final static String log_type 	= "log_type";
	public final static String search_key 	= "search_key";
	public final static String time_ms 		= "time_ms";
	public final static String error_code 	= "error_code";
	/*******************日志的BODY部分**********************/
	//该部分与com.wmost.spider.model.readme.md需保持一致
	public final static String body			= "body";

	public final static String server_ip 	= "server_ip";
}
