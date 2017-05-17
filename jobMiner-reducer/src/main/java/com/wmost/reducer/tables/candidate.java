/**
@description  个人信息数据表
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		2017-04-21	22:01	按照日志格式要求精简了日志输出toString
		2017-05-02	22:01	根据日志修正抽象数据结构
		
**/


package com.wmost.reducer.tables;

import com.wmost.cfig.UNICODE;

public class candidate implements tables_interface {
	public final static String TABLE = "candidate";
	
	public String time_stamp		;//日志时间戳
	public String log_type			;//日志类型
	public String search_key		;//日志唯一标识[0-9A-Za-z]{32}
	public String time_ms			;//处理耗时(ms)
	public String error_code		;//错误码
	
	public String key				;//标识
	public String src				;//来源
	public String name				;//名称
	public String gender			;//性别
	public String ethnic			;//民族
	public String major				;//学历
	public String school			;//学校
	public String capacity			;//能力
	public String experience		;//经验
	public String industry			;//行业
	public String scale				;//规模
	public String nature			;//性质
	public String position			;//职位
	public String type				;//类型
	public String salary			;//薪资
	public String location			;//地址
	public String expect_industry	;//行业*
	public String expect_scale		;//规模*
	public String expect_nature		;//性质*
	public String expect_position	;//职位*
	public String expect_type		;//类型*
	public String expect_salary		;//薪资*
	public String expect_location	;//地址*
	public String tag				;//标签
	
	public String server_ip			;//服务器ip地址(日志最后一个字段，仅用于内部调使用)
	
	
	public candidate(){}
	
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
				gender				,
				ethnic				,
				major				,
				school				,
				capacity			,
				experience			,
				industry			,
				scale				,
				nature				,
				position			,
				type				,
				salary				,
				location			,
				expect_industry		,
				expect_scale		,
				expect_nature		,
				expect_position		,
				expect_type			,
				expect_salary		,
				expect_location		,
				tag					,
				
				server_ip					
    			);
    }

	@Override
	public String getQuerSQL() {
		return "SELECT * FROM " 
				+ TABLE 
				+ " WHERE " 
				+ " time_stamp=? AND `name`=? AND gender=? AND ethnic=?";
	}

	@Override
	public String getInsertSQL() {
		return "INSERT INTO " 
				+ TABLE 
				+ " (time_stamp,log_type,search_key,time_ms,error_code,`key`,src,`name`,gender,ethnic,major,school,capacity,experience,industry,scale,nature,position,type,salary,location,expect_industry,expect_scale,expect_nature,expect_position,expect_type,expect_salary,expect_location,tag,server_ip)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}

	@Override
	public String getUpdataSQL() {
		return "UPDATE " 
				+ TABLE 
				+ " SET time_stamp=?,log_type=?,search_key=?,time_ms=?,error_code=?,`key`=?,src=?,`name`=?,gender=?,ethnic=?,major=?,school=?,capacity=?,experience=?,industry=?,scale=?,nature=?,position=?,type=?,salary=?,location=?,expect_industry=?,expect_scale=?,expect_nature=?,expect_position=?,expect_type=?,expect_salary=?,expect_location=?,tag=?,server_ip=? "
				+ " WHERE time_stamp=? AND `name`=? AND gender=? AND ethnic=?";
	}

	@Override
	public Object[] getQueryObj() {
		return new Object[]{
				time_stamp			,
				name				,
				gender				,
				ethnic				,
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
				gender				,
				ethnic				,
				major				,
				school				,
				capacity			,
				experience			,
				industry			,
				scale				,
				nature				,
				position			,
				type				,
				salary				,
				location			,
				expect_industry		,
				expect_scale		,
				expect_nature		,
				expect_position		,
				expect_type			,
				expect_salary		,
				expect_location		,
				tag					,
				
				server_ip			,
				
				
				time_stamp			,
				name				,
				gender				,
				ethnic				,
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
				gender				,
				ethnic				,
				major				,
				school				,
				capacity			,
				experience			,
				industry			,
				scale				,
				nature				,
				position			,
				type				,
				salary				,
				location			,
				expect_industry		,
				expect_scale		,
				expect_nature		,
				expect_position		,
				expect_type			,
				expect_salary		,
				expect_location		,
				tag					,
				
				server_ip			,
			};
	}
}