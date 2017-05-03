/**
@description  数据引擎-hive服务-离线数据计算-并存储计算结果
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
		
		
**/

package com.wmost.reducer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.google.gson.Gson;
import com.wmost.cfig.LOG;
import com.wmost.reducer.hive_record.hive_record;
import com.wmost.reducer.tables.company;
import com.wmost.reducer.tables.position;
import com.wmost.reducer.tables.tables_interface;
import com.wmost.util.ExecuteCallBack;
import com.wmost.util.JDBCWrapper;
import com.wmost.util.logg;
import com.wmost.util.timeUtil;

public class hive implements Runnable{
	private static final int BUFFER_SIZE = 10000;
	private static BlockingQueue <String> buffer = new ArrayBlockingQueue<String>(BUFFER_SIZE);
	private static Queue<hive_record> hive_records = new LinkedList<hive_record>();
	private static Queue<tables_interface> tables_records = new LinkedList<tables_interface>();
	
	//模拟kafka生产者服务
	public static void collect(String msg){
		try {
			buffer.put(msg);
			//System.out.println("hive获取:"+msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//模拟kafka消费者服务
	public static String distribution(){
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
		long daymillis = 0;
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//读取hdfs数据(一般离线处理周期为一天),离线计算后写入数据库
			long now = System.currentTimeMillis();
			boolean IS_DEBUG = true;
			if (timeUtil.isSameDayOfMillis(daymillis,now) || buffer.size() >= BUFFER_SIZE || IS_DEBUG) {
				daymillis = now;
				process();
			}
		}
	}
	
	//对数据进行离线批量
	public void process() {
		//1.日志转化为hive记录存储
		synchronized(hive.class){
			while(!buffer.isEmpty()){
				String msg = hive.distribution();
				hive_record o = new hive_record(msg);
				if (null != o) {
					hive_records.add(o);	
				}
			}
		}

		//2.计算		
		//将hive记录处理后,形成数据库表记录(后续做更复杂的操作)
		for (final hive_record record : hive_records) {
			String json = new Gson().toJson(record.o);
			tables_interface o = null;
			switch(record.type) {
				case LOG.LOG_TYPE.LOG_TYPE_POSITION:
					o = new Gson().fromJson(json, position.class);
					break;
				case LOG.LOG_TYPE.LOG_TYPE_COMPANY:
					o = new Gson().fromJson(json, company.class);
					break;
				default:
					break;
			}
			tables_records.add(o);
		}
		hive_records.clear();
		
		//3.结果集写入数据库
		final JDBCWrapper jdbcWrapper = JDBCWrapper.getJDBCInstance(
				"localhost:3306",
				"jobMiner",
				"root",
				"root",
				10
				);
		for (final tables_interface iter : tables_records){
			if (null == iter) {
				continue;
			}
			
			final String sql 			= iter.getQuerSQL();
			final String sql_updating 	= iter.getUpdataSQL();
			final String sql_inserting 	= iter.getInsertSQL();
			jdbcWrapper.doQueryUnCommit(
					sql,
					iter.getQueryObj(),
					new ExecuteCallBack() {
		  				@Override
		  				public void resultCallBack(ResultSet result,Connection conn) throws Exception {
		  				if(result.next()){
		  					ArrayList<Object[]> updateParametersList = new ArrayList<Object[]>();
		  					updateParametersList.add(iter.getUpdataObj());
		  					jdbcWrapper.doBatchUnCommit(sql_updating, updateParametersList,conn);
		  				} else {
		  					ArrayList<Object[]> insertParametersList = new ArrayList<Object[]>();
		  					insertParametersList.add(iter.getInsertObj());
		  					jdbcWrapper.doBatchUnCommit(sql_inserting, insertParametersList,conn);
		  				}
		  			}
					@Override
					public void resultCallBack(ResultSet result) throws Exception {

					}
           		},
           		jdbcWrapper.getConnection()
           	);
		}
	}
}
