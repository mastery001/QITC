package edu.jxau.service;

import static org.junit.Assert.fail;

import org.junit.Test;

public class CheckThesisServiceTest {

	@Test
	public void testCheckThesisService() {
		CheckThesisService cts = new CheckThesisService("");
		String document = "Java集合.doc";
		cts.check(document);
	}

	@Test
	public void testCheck() {
		fail("Not yet implemented");
	}

}
