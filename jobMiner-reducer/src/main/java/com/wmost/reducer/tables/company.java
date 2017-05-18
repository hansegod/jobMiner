/**
@description  公司信息数据表
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		2017-04-21	22:01	按照日志格式要求精简了日志输出toString
		2017-05-02	22:01	对与mysql关键字冲突的key、name进行了·转义处理
		2017-05-02	22:01	根据日志修正抽象数据结构
		2017-05-18	09:01	增加key字段解析
		
**/


package com.wmost.reducer.tables;

import com.wmost.cfig.UNICODE;


public class company implements tables_interface{
	public final static String TABLE = "company";
	
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

	@Override
	public String getQuerSQL() {
		return "SELECT * FROM " 
				+ TABLE 
				+ " WHERE " 
				+ " time_stamp=? AND `name`=? AND industry=?";
	}

	public String getInsertSQL(){
		return "INSERT INTO " 
				+ TABLE 
				+ " (time_stamp,log_type,search_key,time_ms,error_code,`key`,src,`name`,industry,scale,nature,position,salary,location,website,tag,server_ip)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
	
	public String getUpdataSQL(){
		return "UPDATE " 
				+ TABLE 
				+ " SET time_stamp=?,log_type=?,search_key=?,time_ms=?,error_code=?,`key`=?,src=?,`name`=?,industry=?,scale=?,nature=?,position=?,salary=?,location=?,website=?,tag=?,server_ip=? WHERE "
				+ " time_stamp=? AND `name`=? AND industry=?";
    }

	@Override
	public Object[] getQueryObj() {
		return new Object[]{
				time_stamp			, 
				name				,
				industry			,
			};
	}

	@Override
	public Object[] getUpdataObj() {
		return new Object[]{
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
				
				server_ip			,
				

				time_stamp			, 
				name				,
				industry			,
			};
	}

	@Override
	public Object[] getInsertObj() {
		return new Object[]{
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
				
				server_ip			,
			};
	}
}
