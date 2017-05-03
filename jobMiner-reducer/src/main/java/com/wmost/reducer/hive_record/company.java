/**
@description  公司信息日志
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		2017-04-21	22:01	按照日志格式要求精简了日志输出toString
		2017-05-02	22:01	根据日志修正抽象数据结构
		
**/


package com.wmost.reducer.hive_record;

import com.wmost.cfig.UNICODE;


public class company {
	public String time_stamp		;//日志时间戳
	public String log_type			;//日志类型
	public String search_key		;//日志唯一标识[0-9A-Za-z]{32}
	public String time_ms			;//处理耗时(ms)
	public String error_code		;//错误码
	
	public String key				;//标识
	public String src				;//来源
	public String name				;//名称
	public String industry			;//行业
	public String scale				;//规模
	public String nature			;//性质
	public String position			;//职位
	public String salary			;//薪资
	public String location			;//地址
	public String website			;//网址
	public String tag				;//标签
	
	public String server_ip			;//服务器ip地址(日志最后一个字段，仅用于内部调使用)
	
	public company(){}
	
	public company(String msg) {
		String[] splited = UNICODE.SPACE.split(msg);
		
		int i = 0;
		time_stamp			= splited[i++];
		log_type			= splited[i++];
		search_key			= splited[i++];
		time_ms				= splited[i++];
		error_code			= splited[i++];
		
		src					= splited[i++];
		name				= splited[i++];
		industry			= splited[i++];
		scale				= splited[i++];
		nature				= splited[i++];
		position			= splited[i++];
		salary				= splited[i++];
		location			= splited[i++];
		website				= splited[i++];
		tag					= splited[i++];
		
		server_ip			= splited[i++];
	}

	@Override
	public String toString() {
		return String.join(
				UNICODE.JOIN		,
				time_stamp			,
				log_type			,
				search_key			,
				time_ms				,
				error_code			,
				
				key					,
				src					,
				name				,
				industry			,
				scale				,
				nature				,
				position			,
				salary				,
				location			,
				website				,
				tag					,
				
				server_ip
				);
	}
}
