/**
@description  日志抽象,日志采用接口抽象,具体日志进行实现
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		2017-04-21	22:01	按照日志格式要求精简了日志输出toString
		2017-05-02	22:01	根据日志修正抽象数据结构
		
**/

package com.wmost.reducer.hive_record;


import com.wmost.cfig.LOG;
import com.wmost.cfig.UNICODE;

public class hive_record {
	public int 	type;
	public Object 	o;
	
	public  hive_record(String msg) {
		if (null == msg || "" == msg) {
			return;
		}
		
		String[] splited = UNICODE.SPACE.split(msg);
		String logtype = splited[UNICODE.LOG_TYPE_NUM];

		switch (logtype) {
			case LOG.LOG_TYPE.LOG_TYPE_POSITION+"":
				type = LOG.LOG_TYPE.LOG_TYPE_POSITION;
				o = new position(msg);
				break;
			case LOG.LOG_TYPE.LOG_TYPE_COMPANY+"":
				type = LOG.LOG_TYPE.LOG_TYPE_COMPANY;
				o = new company(msg);
				break;
			case LOG.LOG_TYPE.LOG_TYPE_CANDIDATE+"":
				type = LOG.LOG_TYPE.LOG_TYPE_CANDIDATE;
				o = new candidate(msg);
				break;
			default:
				break;
		}
	}
}
