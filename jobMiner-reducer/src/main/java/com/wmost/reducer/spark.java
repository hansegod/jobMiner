/**
@description  数据引擎-spark服务-准实时计算并保存计算结果
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		2017-05-02	00:00	修改采用BlockingQueue实现消息缓冲
		
**/


package com.wmost.reducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class spark implements Runnable{
	private static final int BUFFER_SIZE = 100;
	private static BlockingQueue <String> buffer = new ArrayBlockingQueue<String>(BUFFER_SIZE);
	//模拟kafka生产者服务
	public static void collect(String msg){
		try {
			buffer.put(msg);
			//System.out.println("spark获取:"+msg);
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
			@SuppressWarnings("unused")
			String msg = null;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			msg = spark.distribution();
			
			//将数据实时计算后写入数据库,由于本项目对实时数据要求不高,该部分数据丢弃
			
		}
	}
}
