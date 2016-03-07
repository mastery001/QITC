package com.mastery.common.exception;



public class CommonException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8597829683133573474L;

	/**
	 * Creates a new instance of <code>SecurityServiceException</code> without
	 * detail message.
	 */
	public CommonException() {
	}

	/**
	 * Constructs an instance of <code>SecurityServiceException</code> with the
	 * specified detail message.
	 * 
	 * @param msg
	 *            the detail message.
	 */
	public CommonException(String msg) {
		super(msg);
	}

	public CommonException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommonException(Throwable cause) {
		super(cause);
	}



}
