/**
@description  数据引擎-kafka服务-消息传递中间件-接收flume收集来的日志数据-分发给spark计算、storm计算及数据清洗
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		
		
**/

package com.wmost.reducer;

import java.util.ArrayList;

public class kafka implements Runnable{
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
			
			msg = kafka.distribution();
			
			//将数据发送至spark订阅
			spark.collect(msg);
			
			//将数据发送至storm订阅
			storm.collect(msg);
		}
	}
}
