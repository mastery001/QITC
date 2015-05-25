package edu.jxau.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.web.exception.ErrorException;

import edu.jxau.po.User;
import edu.jxau.vo.UserInfo;

public class LoginServiceTest {

	@Test
	public void testLoginService() throws ErrorException {
		User user = new User();
		user.setU_id("20121576");
		user.setPassword("123");
		UserInfo ui = new LoginService(user).login();
		System.out.println(ui);
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

}
