/**
@description  数据引擎-hdfs服务-数据存储-数据仓库
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		2017-05-02	00:00	修改采用BlockingQueue实现消息缓冲
		
**/


package com.wmost.reducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class hdfs implements Runnable{
	private static final int BUFFER_SIZE = 100;
	private static BlockingQueue <String> buffer = new ArrayBlockingQueue<String>(BUFFER_SIZE);
	//模拟kafka生产者服务
	public static void collect(String msg){
		try {
			buffer.put(msg);
			//System.out.println("hdfs获取:"+msg);
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

			msg = hdfs.distribution();
			
			//数据落地hdfs,消费完成
			//写入hdfs文件系统
			
			//数据供hive离线计算
			hive.collect(msg);
		}
	} 
}
