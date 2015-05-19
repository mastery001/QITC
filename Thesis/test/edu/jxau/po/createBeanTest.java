package edu.jxau.po;

import org.junit.Test;

import tool.mastery.core.CreateBeanUtil;

public class createBeanTest {

	@Test
	public void test() {
		CreateBeanUtil.create("edu.jxau.vo", "vo.txt");
	}

}
