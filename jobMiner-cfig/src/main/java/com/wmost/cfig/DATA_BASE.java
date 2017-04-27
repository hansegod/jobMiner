package com.wmost.cfig;

public class DATA_BASE {
	public static final String POSITION_TABLE		= "position";	//广告监控报表表名
	public static final int DB_POOL_SIZE 			= 20;			//连接池大小
			
	public static String DB_ADDRESS_PORT;					//数据库地址及端口
	public static String DB_USERNAME;						//用户名
	public static String DB_PASSWORD;						//密码
	public static String DB_NAME;							//数据库名称(线上数据库)
	
	static {
		Init();
	}
	
	public static void Init() {
		DB_ADDRESS_PORT = "3306";
		DB_USERNAME		= "root";
		DB_PASSWORD		= "root";
		DB_NAME			= "jobMiner";
	}
}
