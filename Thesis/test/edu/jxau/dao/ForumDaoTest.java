package edu.jxau.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.web.access.factory.DaoAdviceFactory;
import org.web.exception.DBException;

import edu.jxau.vo.Forum;

public class ForumDaoTest {

	@Test
	public void testBuildVoResolve() throws DBException {
		Forum f = new Forum();
		f.setU_id("20121576");
		f.setIsleaf(0);
		List<Object> list = DaoAdviceFactory.getDao("Forum").query(f.getClass(), f, null, false);
		System.out.println(list.size());
	}

	@Test
	public void testSaveObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testWhenUpdateOrDeleteUnNecessaryClasses() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddWhereOrOrderCondition() throws DBException {
		Forum f = new Forum();
		f.setP_id(5);
		new ForumDao().delete(f);
		
	}

	
	
}
