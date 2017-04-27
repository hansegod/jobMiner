/**
@description  数据引擎-flume服务-日志数据收集-并发送至kafka-数据落地入仓
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		
		
**/

package com.wmost.reducer;

import java.util.ArrayList;

public class flume implements Runnable{
	public static class LogFile2Kafka {
		private static ArrayList<String> buffer = new ArrayList<String>();
		//模拟flume收集日志服务
		public static void collect(String msg){
			buffer.add(msg);
			buffer.notify();
		}
		
		//模拟flume转发日志服务
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
	}
	
	public static class Storm2Hdfs {
		private static ArrayList<String> buffer = new ArrayList<String>();
		//模拟flume以storm为源收集清洗日志服务
		public static void collect(String msg){
			buffer.add(msg);
			buffer.notify();
		}
		
		//模拟flume转发清洗后日志落地至HDFS服务
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
			msg = flume.LogFile2Kafka.distribution();
			kafka.collect(msg);
			
			//将清洗后的数据写入hdfs
			msg = flume.Storm2Hdfs.distribution();
			hdfs.collect(msg);
		}	
	}
}
