/*
@description  	jobMiner数据库结构表
				数据库账号 root	密码 root	端口 3306
@author hanse/irene
@data	2017-04-21	00:00	初稿
		2017-04-27	21:01	调整,写入成功
		2017-05-03	21:01	调整id字段
		
*/

#数据库存在时注释
CREATE DATABASE `jobMiner`;

USE `jobMiner`;

CREATE TABLE `position` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	
	`time_stamp` 	varchar(20) 	DEFAULT '' COMMENT '日志时间戳',
	`log_type` 		varchar(4) 		DEFAULT '' COMMENT '日志类型',
	`search_key` 	varchar(32) 	DEFAULT '' COMMENT '日志唯一标识[0-9A-Za-z]{32}',
	`time_ms` 		varchar(10) 	DEFAULT '' COMMENT '处理耗时(ms)',
	`error_code` 	varchar(10) 	DEFAULT '' COMMENT '错误码',
	
	
	`key` 				varchar(64) 	DEFAULT '' COMMENT '标识',
	`src` 				varchar(64) 	DEFAULT '' COMMENT '来源',
	`name` 				varchar(64) 	DEFAULT '' COMMENT '职位',
	`company` 			varchar(64) 	DEFAULT '' COMMENT '公司',
	`industry` 			varchar(64) 	DEFAULT '' COMMENT '行业',
	`scale` 			varchar(20) 	DEFAULT '' COMMENT '规模',
	`nature` 			varchar(64) 	DEFAULT '' COMMENT '性质',
	`website` 			varchar(64) 	DEFAULT '' COMMENT '网址',
	`count` 			varchar(10) 	DEFAULT '' COMMENT '数量',
	`type` 				varchar(4) 		DEFAULT '' COMMENT '类型',
	`pubtime` 			varchar(20) 	DEFAULT '' COMMENT '发布',
	`offtime` 			varchar(20) 	DEFAULT '' COMMENT '截止',
	`salary` 			varchar(10) 	DEFAULT '' COMMENT '薪资',
	`location` 			varchar(64) 	DEFAULT '' COMMENT '地址',
	`major` 			varchar(64) 	DEFAULT '' COMMENT '学历',
	`school` 			varchar(64) 	DEFAULT '' COMMENT '学校',
	`experience` 		varchar(512) 	DEFAULT '' COMMENT '经验',
	`tag` 				varchar(64) 	DEFAULT '' COMMENT '标签',
	`duty` 				varchar(64) 	DEFAULT '' COMMENT '职责',
	
	
	`server_ip` 	varchar(64) 	DEFAULT '' COMMENT '服务器ip地址',
	
	
	`last_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `company` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	
	`time_stamp` 	varchar(20) 	DEFAULT '' COMMENT '日志时间戳',
	`log_type` 		varchar(4) 		DEFAULT '' COMMENT '日志类型',
	`search_key` 	varchar(32) 	DEFAULT '' COMMENT '日志唯一标识[0-9A-Za-z]{32}',
	`time_ms` 		varchar(10) 	DEFAULT '' COMMENT '处理耗时(ms)',
	`error_code` 	varchar(10) 	DEFAULT '' COMMENT '错误码',
	
	
	`key` 				varchar(64) 	DEFAULT '' COMMENT '标识',
	`src` 				varchar(64) 	DEFAULT '' COMMENT '来源',
	`name` 				varchar(64) 	DEFAULT '' COMMENT '名称',
	`industry` 			varchar(20) 	DEFAULT '' COMMENT '行业',
	`scale` 			varchar(20) 	DEFAULT '' COMMENT '规模',
	`nature` 			varchar(20) 	DEFAULT '' COMMENT '性质',
	`position` 			varchar(64) 	DEFAULT '' COMMENT '职位',
	`salary` 			varchar(10) 	DEFAULT '' COMMENT '薪资',
	`location` 			varchar(64) 	DEFAULT '' COMMENT '地址',
	`website` 			varchar(64) 	DEFAULT '' COMMENT '网址',
	`tag` 				varchar(64) 	DEFAULT '' COMMENT '标签',
	
	
	`server_ip` 	varchar(64) 	DEFAULT '' COMMENT '服务器ip地址',
	
	
	`last_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `candidate` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	
	`time_stamp` 	varchar(20) 	DEFAULT '' COMMENT '日志时间戳',
	`log_type` 		varchar(4) 		DEFAULT '' COMMENT '日志类型',
	`search_key` 	varchar(32) 	DEFAULT '' COMMENT '日志唯一标识[0-9A-Za-z]{32}',
	`time_ms` 		varchar(10) 	DEFAULT '' COMMENT '处理耗时(ms)',
	`error_code` 	varchar(10) 	DEFAULT '' COMMENT '错误码',
	
	
	`key` 				varchar(64) 	DEFAULT '' COMMENT '标识',
	`src` 				varchar(64) 	DEFAULT '' COMMENT '来源',
	`name` 				varchar(64) 	DEFAULT '' COMMENT '名称',
	`gender` 			varchar(4) 		DEFAULT '' COMMENT '性别',
	`ethnic` 			varchar(10) 	DEFAULT '' COMMENT '民族',
	`school` 			varchar(64) 	DEFAULT '' COMMENT '学校',
	`major` 			varchar(64) 	DEFAULT '' COMMENT '学历',
	`capacity` 			varchar(64) 	DEFAULT '' COMMENT '能力',
	`experience` 		varchar(512) 	DEFAULT '' COMMENT '经验',
	`industry` 			varchar(64) 	DEFAULT '' COMMENT '行业',
	`scale` 			varchar(20) 	DEFAULT '' COMMENT '规模',
	`nature` 			varchar(64) 	DEFAULT '' COMMENT '性质',
	`position` 			varchar(64) 	DEFAULT '' COMMENT '职位',
	`type` 				varchar(4) 		DEFAULT '' COMMENT '类型',
	`salary` 			varchar(10) 	DEFAULT '' COMMENT '薪资',
	`location` 			varchar(64) 	DEFAULT '' COMMENT '地址',
	`expect_industry` 	varchar(64) 	DEFAULT '' COMMENT '行业*',
	`expect_scale` 		varchar(64) 	DEFAULT '' COMMENT '规模*',
	`expect_nature` 	varchar(20) 	DEFAULT '' COMMENT '性质*',
	`expect_position` 	varchar(64) 	DEFAULT '' COMMENT '职位*',
	`expect_type` 		varchar(4) 		DEFAULT '' COMMENT '类型*',
	`expect_salary` 	varchar(10) 	DEFAULT '' COMMENT '薪资*',
	`expect_location` 	varchar(64) 	DEFAULT '' COMMENT '地址*',
	`tag` 				varchar(64) 	DEFAULT '' COMMENT '标签',
	
	
	`server_ip` 	varchar(64) 	DEFAULT '' COMMENT '服务器ip地址',
	
	
	`last_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
