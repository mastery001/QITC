package com.mastery.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastery.model.AlbumInfoModel;

public class IAlbumInfoDaoTest {


	ApplicationContext ac = new ClassPathXmlApplicationContext("core-applicationContext.xml");
	
	IAlbumInfoDao dao = ac.getBean(IAlbumInfoDao.class);
	
	@Test
	public void testInsert() {
		fail("Not yet implemented");
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
		AlbumInfoModel model = new AlbumInfoModel();
		model.setCid(1L);
		model.setName("何以");
		System.out.println(dao.selectVagueByModel(model));
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
