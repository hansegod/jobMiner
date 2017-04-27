/**
@description  数据引擎-storm服务-数据清洗-数据计算
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		
		
**/

package com.wmost.reducer;

import java.util.ArrayList;

public class storm implements Runnable{
	private static ArrayList<String> buffer = new ArrayList<String>();
	//模拟kafka生产者服务
	public static void collect(String msg){
		buffer.add(msg);
		buffer.notify();
	}
	
	//模拟kafka消费者服务
	public static String distribution(){
		if(buffer.size()<=0) {
			try {
				buffer.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return buffer.get(0);
	}

	@Override
	public void run() {
		while(true) {
			String msg = null;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			msg = storm.distribution();
			
			//清洗数据
			msg = wash(msg);
			
			//将数据计算后写入hdfs
			if(null!=msg) {
				//处理数据
				hdfs.collect(msg);
			}
		}
	}
	
	//数据清洗
	public static String wash(String msg){
		String result = null;
		//合法性校验,字段缺失补齐,数据规整等处理,数据非法时返回null
		{
			//暂不做处理,后续优化
			result = msg;
			
			
		}
		
		return result;
	}
}
