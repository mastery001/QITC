package edu.jxau.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.web.exception.ErrorException;

import edu.jxau.po.User;

public class LoginServiceTest {

	@Test
	public void testLoginService() throws ErrorException {
		User user = new User();
		user.setU_id("20121576");
		user.setPassword("123");
		new LoginService(user).login();
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

}
