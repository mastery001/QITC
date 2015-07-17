package edu.train.chapter3;

public class RunnableImpl {

	/**
	 * 获取匿名内部类实现的Runnable
	 * 
	 * @return
	 */
	public static Runnable getAnonymousRunnable() {
		Runnable r = new Runnable() {
			public void run() {
				int index = 0;
				while(index < 10) {
					index ++;
					System.out.println("This is Anonymouse class;---" + index);
				}
				
			}
		};
		return r;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(getAnonymousRunnable());
		// 设置线程名为Anonymouse
		t1.setName("Anonymouse");
		// 设置优先级为1
		t1.setPriority(1);

		Thread t2 = new Thread(new UnanonymouseRunnable());
		// 设置线程名为Unanonymouse
		t1.setName("Unanonymouse");
		// 设置优先级为2
		 t1.setPriority(2);
		 
		 // 分别启动线程1和线程2
		 t1.start();
		 t2.start();
	}

}

class UnanonymouseRunnable implements Runnable {

	public void run() {
		int index = 0;
		while(index < 10) {
			index ++;
			System.out.println("This is Unanonymouse class;---" + index);
		}
	}

}
