package edu.train.chapter3;

public class MonkyDividePeachProblem {
	
	/**
	 * @param n	 多少只猴子
	 */
	public static void dividePeach(int n) {
		int i , count = 0, temp =0 , j = 0;
		for(i = 4; i < 10000 ; i+=4) {
			count = 0;
			temp = i;
			for(int k = 0 ; k < n ; k++) {
				j = i / 4 * n + 1;
				i = j;
				if(j % 4 == 0) {
					count ++;
				}else {
					break;
				}
			}
			i = temp;
			if(count == 4) {
				System.out.println("原来有桃子: " + j + "个");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		dividePeach(5);
	}
}
