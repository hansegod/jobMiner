package com.wmost.reducer;

public class cluster {
	public static void Submit(){
		new Thread(new flume()).start();
		
		new Thread(new kafka()).start();
		
		new Thread(new spark()).start();
		
		new Thread(new storm()).start();
		
		new Thread(new hdfs()).start();
		
		new Thread(new hive()).start();
		
		new Thread(new zookeeper()).start();
	}
}
