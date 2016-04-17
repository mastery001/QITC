package com.mastery.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastery.model.User;

public class IUserDaoTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext("core-applicationContext.xml");
	IUserDao userDao = ac.getBean(IUserDao.class);

	@Test
	public void test() {
		User user = new User();
		user.setUsername("zouziwen");
		user.setPassword("123546");
		System.out.println(userDao.selectByModel(user));
	}
}
