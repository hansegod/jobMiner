/**
@description  数据引擎-hdfs服务-数据存储-数据仓库
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		
		
**/


package com.wmost.reducer;

import java.util.ArrayList;

public class hdfs implements Runnable{
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

			msg = hdfs.distribution();
			
			//数据落地hdfs,消费完成
			//写入hdfs文件系统
			
			//数据供hive离线计算
			hive.collect(msg);
		}
	} 
}
