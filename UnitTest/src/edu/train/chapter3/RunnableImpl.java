package edu.train.chapter3;

public class RunnableImpl {

	/**
	 * ��ȡ�����ڲ���ʵ�ֵ�Runnable
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
		// �����߳���ΪAnonymouse
		t1.setName("Anonymouse");
		// �������ȼ�Ϊ1
		t1.setPriority(1);

		Thread t2 = new Thread(new UnanonymouseRunnable());
		// �����߳���ΪUnanonymouse
		t1.setName("Unanonymouse");
		// �������ȼ�Ϊ2
		 t1.setPriority(2);
		 
		 // �ֱ������߳�1���߳�2
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
