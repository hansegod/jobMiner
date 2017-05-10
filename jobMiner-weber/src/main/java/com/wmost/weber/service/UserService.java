package com.wmost.weber.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


/**
 * 用户服务
 *
 * @author huangyong
 * @since 1.0.0
 */
@Service
public class UserService {
	private Logger logger  =  Logger.getLogger(UserService.class);
	
    public boolean login(String username, String password) {
        // TODO
    	logger.debug("[登录]用户名:"+username+",密码:"+password);
    	
        return true;
    }
}
