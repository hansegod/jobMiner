/**
@description  工作信息日志
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		2017-04-21	22:01	按照日志格式要求精简了日志输出toString
		2017-05-02	22:01	根据日志修正抽象数据结构
		
**/


package com.wmost.reducer.hive_record;

import com.wmost.cfig.UNICODE;
import com.wmost.cfig.cfig;

public class position {
	public String time_stamp		;//日志时间戳
	public String log_type			;//日志类型
	public String search_key		;//日志唯一标识[0-9A-Za-z]{32}
	public String time_ms			;//处理耗时(ms)
	public String error_code		;//错误码
	
	public String key				;//标识
	public String src				;//来源
	public String name				;//职位
	public String company			;//公司
	public String industry			;//行业
	public String scale				;//规模
	public String nature			;//性质
	public String website			;//网址
	public String count				;//数量
	public String type				;//类型
	public String pubtime			;//发布
	public String offtime			;//截止
	public String salary			;//薪资
	public String location			;//地址
	public String major				;//学历
	public String school			;//学校
	public String experience		;//经验
	public String tag				;//标签
	public String duty				;//职责
	
	public String server_ip			;//服务器ip地址(日志最后一个字段，仅用于内部调使用)
	
	
	public position(String msg) {
		String[] splited = UNICODE.SPACE.split(msg);
		
		int i = 0;
		time_stamp			= splited[i++];
		log_type			= splited[i++];
		search_key			= splited[i++];
		time_ms				= splited[i++];
		error_code			= splited[i++];

		src					= splited[i++];
		name				= splited[i++];
		company				= splited[i++];
		industry			= splited[i++];
		scale				= splited[i++];
		nature				= splited[i++];
		website				= splited[i++];
		count				= splited[i++];
		type				= splited[i++];
		pubtime				= splited[i++];
		offtime				= splited[i++];
		salary				= splited[i++];
		location			= splited[i++];
		major				= splited[i++];
		school				= splited[i++];
		experience			= splited[i++];
		tag					= splited[i++];
		duty				= splited[i++];
		
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
				name				,
				company				,
				industry			,
				scale				,
				nature				,
				website				,
				count				,
				type				,
				pubtime				,
				offtime				,
				salary				,
				location			,
				major				,
				school				,
				experience			,
				tag					,
				duty				,
				
				server_ip				
				);
	}
}
