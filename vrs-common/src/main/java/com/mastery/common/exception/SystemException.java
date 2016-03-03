package com.mastery.common.exception;

/**
 * 系统级异常，bug
 * @author zouziwen
 *
 * 2016年3月3日 下午4:49:21
 */
public class SystemException extends RuntimeException{

	/**
	 * 2016年3月3日 下午4:49:03
	 */
	private static final long serialVersionUID = 894191043794424480L;

	public SystemException(String message) {
		super(message);
	}
}
