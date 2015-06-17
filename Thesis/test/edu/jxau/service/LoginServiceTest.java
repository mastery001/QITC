package edu.jxau.service;

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
		// 生成的数字
		String str="1234";
		// 输入的数字
		String str1 = "1234";
		char strArray[] = str.toCharArray();
		int index = -1;
		for(int i = 0 ; i < strArray.length ; i++ ) {
			if((index = str1.indexOf(String.valueOf(strArray[i]))) != -1 ) {
				if(index == i) {
					System.out.println("数字相同且位置正确！");
				}else {
					System.out.println("数字相同但位置正确！");
				}
			}else {
				System.out.println("不存在该数字");
			}
		}
	}

}
