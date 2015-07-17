package edu.train.chapter3;

public class BuildNumber {
	
	// 从四位数构建不重复的三位数，存储在此数组中
	private String[] buildNumbers;
	
	// 记录buildNumbers的下标
	private int index = 0;
	
	/**
	 * @param numbers	初始存储的数组 例如原题中的1，2，3，4
	 * @return
	 */
	public void build(int[] numbers) {
		if(numbers == null || numbers.length == 0) {
			throw new NullPointerException("数组不能为空或者长度必须大于0");
		}
		int length = numbers.length;
		buildNumbers = new String[length*length*length];
		for(int i = 0 ; i < length ; i++) {
			for(int j = 0 ; j < length; j++) {
				for(int k = 0 ; k < length ; k ++) {
					if(i != j && i != k && j != k) {
						buildNumbers[index++] = "" + numbers[i] + numbers[j] + numbers[k];
					}
				}
			}
		}
		for(int i = 0 ; i < index; i++) {
			System.out.print(buildNumbers[i] + "    ");
			// 隔5个数字换行一次
			if((i+1) % 5 == 0) {
				System.out.println();
			}
			
		}
	}
	
	public static void main(String[] args) {
		new BuildNumber().build(new int[]{1,2,3,4});
	}
}
