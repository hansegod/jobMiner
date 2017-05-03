package com.wmost.framework.security;

/**
 * 令牌异常
 *
 * @author huangyong
 * @since 1.0.0
 */
public class TokenException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7422515811661488845L;

	public TokenException(String message) {
        super(message);
    }
}
