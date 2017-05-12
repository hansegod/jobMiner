/*
@description  	jobMiner系统数据库结构表
				数据库账号 root	密码 root	端口 3306
@author hanse/irene
@data	2017-04-21	00:00	初稿
		2017-04-27	21:01	调整,写入成功
		2017-05-03	21:01	调整id字段
		
*/

#数据库存在时注释
#CREATE DATABASE `jobMiner`;

USE `jobMiner`;

CREATE TABLE `user` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	
	`user_id`			varchar(20) 	COMMENT '用户ID',
	`user_name` 		varchar(128) 	COMMENT '用户名',
	`password` 			varchar(64) 	COMMENT '密码',
	`password_history` 	varchar(256) 	DEFAULT '' COMMENT '历史密码',
	`role` 				varchar(64) 	DEFAULT '' COMMENT '角色组',
	`authority_id` 		varchar(64) 	DEFAULT '' COMMENT '权限编码ID',
	`opration_id` 		varchar(64) 	DEFAULT '' COMMENT '操作记录ID',
	`last_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
	`more` 				varchar(64) 	DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `authority` (
	`authority_id`			varchar(64) 	NOT NULL COMMENT '权限编码ID',
	`authority_list` 		varchar(512) 	DEFAULT '' COMMENT '权限列表',
	`last_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
	`more` 				varchar(64) 	DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `opration` (
	`opration_id`			varchar(64) 	NOT NULL COMMENT '权限编码ID',
	`user_id` 				varchar(20) 	COMMENT '用户ID',
	`opration_type` 		varchar(4) 		DEFAULT '' COMMENT '操作类型',
	`opration_detail` 		varchar(512) 	DEFAULT '' COMMENT '操作详细',
	`last_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
	`more` 					varchar(64) 	DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`opration_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
