/**
@description  数据引擎-kafka服务-消息传递中间件-接收flume收集来的日志数据-分发给spark计算、storm计算及数据清洗
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		2017-05-02	00:00	修改采用BlockingQueue实现消息缓冲
		
**/

package com.wmost.reducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class kafka implements Runnable{
	private static final int BUFFER_SIZE = 100;
	private static BlockingQueue <String> buffer = new ArrayBlockingQueue<String>(BUFFER_SIZE);
	//模拟kafka生产者服务
	public static void collect(String msg){
		try {
			buffer.put(msg);
			//System.out.println("kafka获取:"+msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//模拟kafka消费者服务
	public static String distribution(){
		String msg = null;
		try {
			msg = buffer.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return msg;
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
