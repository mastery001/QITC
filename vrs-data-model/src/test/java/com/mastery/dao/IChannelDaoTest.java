package com.mastery.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastery.model.Channel;

public class IChannelDaoTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext("core-applicationContext.xml");
	
	IChannelDao channelDao = ac.getBean(IChannelDao.class);
	
	@Test
	public void testInsert() {
		Channel channel = new Channel();
		channel.setName("电影");
		channelDao.insert(channel);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByModelCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByMapCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByModel() {
		System.out.println(channelDao.selectByModel(new Channel()));
	}

	@Test
	public void testSelectByMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByBuilder() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectCountByBuilder() {
		fail("Not yet implemented");
	}

}
