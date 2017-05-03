/**
@description  数据引擎-抽象
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		2017-05-02	00:00	分离flume,日志收集及落地hdfs为两个服务
		2017-05-02	00:00	修改采用BlockingQueue实现消息缓冲
**/


package com.wmost.reducer;

public class cluster {
	public static void Submit(){
		new Thread(new flume_in()).start();
		
		new Thread(new kafka()).start();
		
		new Thread(new spark()).start();
		
		new Thread(new storm()).start();
		
		new Thread(new hdfs()).start();
		
		new Thread(new flume_out()).start();
		
		new Thread(new hive()).start();
		
		new Thread(new zookeeper()).start();
	}
}
