package com.mastery.common.exception;



public class CommonException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8597829683133573474L;

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

	public CommonException() {
		super();
		
	}

	public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public CommonException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CommonException(Throwable cause) {
		super(cause);
		
	}


}
