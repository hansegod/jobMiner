	
	
	
	《工程架构》

	com.wmost
			|
			|
			|
			|
			app		应用中心
			|		1.负责各功能模块的协调
			|
			|
			|
			weber	服务引擎
			|		1.定时处理数据引擎写入的数据库数据,生成各中间数据报表
			|		2.根据用户前端输入的查询条件,映射为SQL查询语句
			|		3.将查询结果反馈前端向用户展示
			|
			reducer	数据引擎(仅生产模式)
			|		1.Collect:采用日志收集工具flume,收集爬虫集群各节点日志文件
			|		2.Store:日志经由kafka中间件后,落地HDFS分布式文件系统
			|		3.Process:数据入仓后,通过hive任务定时计算统计后,将结果写入数据库
			|
			spider	爬虫引擎
			|		1.开发模式,爬取数据输出至控制台
			|		2.测试模式,爬取数据输出至数据库
			|		3.生产模式,爬取数据输出至日志文件
			|
			cfig	配置中心
			|		1.系统的配置信息,如:运行模式、各模块运行参数、各类编码等
			|		2.读取配置文件信息,对系统运行状态进行控制与查看
			|
			|
			util	工具类
			