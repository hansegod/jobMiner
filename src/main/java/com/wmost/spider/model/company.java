/**
@description  公司信息保存结构体
@author hanse/irene
@data	2017-04-08	00:00:00	初稿
		2017-04-21	00:00:00	整理代码
		2017-04-21	22:01:00	按照日志格式要求精简了日志输出toString
**/


package com.wmost.spider.model;

import com.wmost.cfig.UNICODE;


public class company {
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
	
	public company(){}
	
	@Override
	public String toString() {
		return String.join(
				UNICODE.JOIN		, 
				getKey()			,
				src					,
				name				,
				industry			,
				scale				,
				nature				,
				position			,
				salary				,
				location			,
				website				,
				tag
				);
	}
	
	public String getKey(){
		//生成标识公司的唯一标识,后续可采用主键字段组合MD5
		key = this.hashCode()+"";
		
		return key;
	}
}
