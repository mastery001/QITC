package com.mastery.common.exception;

/**
 * 业务性异常
 * @author zouziwen
 *
 * 2016年3月3日 下午4:49:21
 */
public class BusinessException extends RuntimeException{

	/**
	 * 2016年3月3日 下午4:49:03
	 */
	private static final long serialVersionUID = 894191043794424480L;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BusinessException(Throwable cause) {
		super(cause);
		
	}
	
}
