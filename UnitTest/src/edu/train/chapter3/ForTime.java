package edu.train.chapter3;

import org.junit.Test;

public class ForTime {

	@Test
	public void test1() {
		long begin = System.currentTimeMillis();
		System.out.println("循环前时间为：" + begin);
		long count = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 10; j++) {
				count *= 2;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("循环后时间为：" + end);
		System.out.println("运行时间为：" + (end - begin));
	}

	@Test
	public void test2() {
		long begin = System.currentTimeMillis();
		System.out.println("循环前时间为：" + begin);
		long count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				count *= 2;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("循环后时间为：" + end);
		System.out.println("运行时间为：" + (end - begin));
	}
}
