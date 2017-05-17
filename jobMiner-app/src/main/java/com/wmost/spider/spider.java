/**
@description  爬虫引擎
@author hanse/irene
@data	2017-04-08	00:00:00	初稿
		2017-04-21	00:00:00	整理代码
		2017-04-21	21:51:00	对JSON与对象互转方法进行了升级,采用util中方法,并增强了调试日志输出
		2017-04-23	21:00:00	修改爬取信息组织形式,采用json封装对象数组至body,支持同时爬取多个对象


**/


package com.wmost.spider;

import us.codecraft.webmagic.Spider;

import com.wmost.spider.peline.logpeline;
import com.wmost.spider.processor.dianhouCompanyProcessor;
import com.wmost.spider.processor.dianhouPositionProcessor;
import com.wmost.spider.processor.lyrcCandidateProcessor;

public class spider {
	//private static boolean IS_DEBUG = false;
	
	public static void submit(String[] args) {
		long startTime, endTime;
        startTime =System.currentTimeMillis();
        
        /*********************************************/
        //System.out.println("【www.dianhou.com-爬取演示】");
        spider.Dianhou();
		
		/*********************************************/
		//System.out.println("【rc.lyrc.net-爬取演示】");
        spider.LYRC();
		
        endTime = System.currentTimeMillis();
        System.out.println("【爬虫引擎】启动成功,耗时(ms):" + (endTime - startTime));
	}
	
	public static void Dianhou() {
		Spider
		.create(new dianhouCompanyProcessor())
		.addUrl("http://www.dianhou.com/company?p=company&page=1")
		.addPipeline(new logpeline())
		.thread(5)
		.start();
		
		Spider
		.create(new dianhouPositionProcessor())
		.addUrl("http://www.dianhou.com")
		.addPipeline(new logpeline())
		.thread(5)
		.start();
	}
	
	public static void LYRC() {
		Spider
		.create(new lyrcCandidateProcessor())
		.addUrl("http://rc.lyrc.net/Companyzp.aspx?Page=1")
		.addPipeline(new logpeline())
		.thread(5)
		.start();
	}
}
