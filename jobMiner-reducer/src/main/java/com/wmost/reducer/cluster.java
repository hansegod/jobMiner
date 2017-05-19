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
		//启动flume日志收集服务
		new Thread(new flume_in()).start();
		//启动kafka消息服务
		new Thread(new kafka()).start();
		//启动spark实时计算服务
		new Thread(new spark()).start();
		//启动storm数据清洗服务
		new Thread(new storm()).start();
		//启动hdfs入仓服务
		new Thread(new hdfs()).start();
		//启动flume数据落地服务
		new Thread(new flume_out()).start();
		//启动hive统计计算服务
		new Thread(new hive()).start();
		//启动zookeeper同步管理服务
		new Thread(new zookeeper()).start();
	}
}
