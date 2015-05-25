package edu.jxau.dao;

import org.web.access.factory.DaoAdviceFactory;

import edu.jxau.po.User;

public class UserDao {

	public User getUser(String u_id) {
		if (u_id != null) {
			User user = new User();
			user.setU_id(u_id);
			try {
				user = (User) DaoAdviceFactory.getDao("User").get(user);
			} catch (Exception e) {
				// 该异常将不会被抛出
				throw new AssertionError("系统异常");
			}
			return user;
		}
		return null;
	}
}
