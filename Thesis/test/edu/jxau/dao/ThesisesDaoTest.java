package edu.jxau.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.web.exception.DBException;

import tool.mastery.core.StringUtil;

public class ThesisesDaoTest {

	@Test
	public void testBuildVoResolve() {
		fail("Not yet implemented");
	}

	@Test
	public void testWhenUpdateOrDeleteUnNecessaryClasses() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllThesisPath() throws DBException {
		System.out
				.println(StringUtil.changeArrayStringToString(new ThesisesDao()
						.getAllThesisPath()));

	}

}
