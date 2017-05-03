/**
@description  数据引擎-zookeeper服务-用于数据与服务同步-协调同步各集群组件
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		2017-05-02	00:00	修改采用BlockingQueue实现消息缓冲
		
**/

package com.wmost.reducer;

public class zookeeper implements Runnable {

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//各组件服务同步,如偏移量保存
		}	
	}
}
