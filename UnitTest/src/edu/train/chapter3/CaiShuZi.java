package edu.train.chapter3;

import java.util.Scanner;

class CaiShuZi {
	public static void main(String[] args) {

		System.out.println("随机数已生成，请输入您猜想的数字：");
		int[] random = generateRandomNumber();
		System.out.println(arrayIntToString(random));
		int[] inputNumber = inputshu();
		// 记录输入了多少次
		int count = 0;
		while (true) {
			if(count == 8) {
				System.out.println("你太笨了");
				break;
			}
			// 判断是否满足，如果满足直接跳循环，结束程序
			if(judge(random, inputNumber)) {
				break;
			}
			inputNumber = inputshu();
			count++;
		}
	}

	private static String arrayIntToString(int[] random) {
		String s = "";
		for (int i = 0; i < random.length; i++) {
			s += random[i];
		}
		return s;
	}

	public static int[] generateRandomNumber() {
		int[] random = new int[4];// 定义随机数数组
		// 产生第一个数字
		random[0] = (int) (Math.random() * 10);
		for (int i = 1; i < random.length; i++) {
			random[i] = (int) (Math.random() * 10);
			for (int j = 0; j < i; j++)
				// 判断是否有元素重复
				if (random[i] == random[j]) {
					i--;
					break;
				}

		}
		return random;
	}

	public static int[] inputshu() {
		Scanner scan = new Scanner(System.in);
		int[] random = new int[4];
		while (true) {
			String input = scan.nextLine();
			for (int i = 0; i < 4; i++) {
				random[i] = (int) (input.charAt(i)) - 48;
			}
			break;
		}
		return random;
	}

	public static boolean judge(int[] random, int[] inputNumber) {
		int countA = 0;
		int countB = 0;
		// 判断位置和数字是否正确
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (random[i] == inputNumber[j] && i == j) {
					countA++;
				} else if (random[i] == inputNumber[j]) {
					countB++;
				}
			}
		}
		if (countA == 4) {
			System.out.println("聪明伶俐一百分");
			return true;
		}
		System.out.println(countA + "A" + countB + "B");
		return false;
	}
	
	public void test(int x ,int a , int b) {
		if(a>1) {
			if(b == 0) {
				x = x/a;
			}
		}
		if(a== 2 || x>1) {
			x = x+1;
		}
	}
}