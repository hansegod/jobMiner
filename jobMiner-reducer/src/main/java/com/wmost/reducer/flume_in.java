/**
@description  数据引擎-flume服务-日志数据收集
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		2017-05-02	00:00	分离flume,日志收集及落地hdfs为两个服务
		
**/

package com.wmost.reducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class flume_in implements Runnable{
	private static final int BUFFER_SIZE = 100;
	private static BlockingQueue <String> buffer = new ArrayBlockingQueue<String>(BUFFER_SIZE);
	//模拟flume收集日志服务(后期可改造成收集服务,日志文件采用日期切分模式,如 logfilename-yyyy-mm-dd.log形式)
	public static void collect(String msg){
		try {
			buffer.put(msg);
			//System.out.println("flume获取:"+msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//模拟flume转发日志服务
	public static  String distribution(){
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
			
			//将收集的日志数据发送至kafka
			msg = flume_in.distribution();
			kafka.collect(msg);
		}	
	}
}
