package edu.train.chapter1;

public class FindMax {
	
	public static int caculMaxNumber(int[] arrs) {
		int max = arrs[0];
		for(int i = 1 ; i < arrs.length ; i++) {
			if(arrs[i] > max) {
				max = arrs[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arrs = new int[]{4 , 2 , 10 , 5 , 23 , 1 , 32 , 54 , 8 , 7};
		int max = caculMaxNumber(arrs);
		System.out.println("这10个数的最大值是" + max);
	}
}
