/**
@description  配置中心
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码

**/


package com.wmost.cfig;


public class cfig {
	public static void submit(String[] args) {
		long startTime, endTime;
        startTime =System.currentTimeMillis();
        
        
		
        endTime = System.currentTimeMillis();
        System.out.println("【配置中心】启动完成,耗时(ms):" + (endTime - startTime));
	}
}
