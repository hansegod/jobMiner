/**
@description  数据引擎-hive服务-离线数据计算-并存储计算结果
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		
		
**/

package com.wmost.reducer;

import java.util.ArrayList;

public class hive implements Runnable{
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
			
			msg = hive.distribution();
			
			//读取hdfs数据,离线计算后写入数据库
			System.out.println("hive计算:"+msg);
		}
	}
}
