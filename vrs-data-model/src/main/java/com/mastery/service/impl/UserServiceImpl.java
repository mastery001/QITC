package com.mastery.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.mastery.dao.IUserDao;
import com.mastery.model.User;
import com.mastery.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	@Override
	public User login(User user) {
		Assert.notNull(user, "user is null");
		List<User> users = userDao.selectByModel(user);
		if (users != null && !users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

}
