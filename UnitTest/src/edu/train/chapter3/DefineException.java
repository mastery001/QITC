package edu.train.chapter3;

class DefaultException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3647214598563874559L;

	public DefaultException(String message) {
		super(message);
		// TODO 自动生成的构造函数存根
	}

}

public class DefineException {
	public static void main(String[] args) {
		try {
			throw new DefaultException("错误");
		}catch(Exception a) {
			System.out.println(a);
		}
	}
}
