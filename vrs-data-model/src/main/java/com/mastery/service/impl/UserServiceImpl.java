package com.mastery.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.mastery.dao.IBaseDao;
import com.mastery.dao.IUserDao;
import com.mastery.model.User;
import com.mastery.service.AbstractBaseService;
import com.mastery.service.IUserService;

@Service("userService")
public class UserServiceImpl  extends AbstractBaseService<User>  implements IUserService {

	public UserServiceImpl() {
		super(User.class);
	}

	@Resource
	private IUserDao userDao;

	@Override
	public User login(User user) {
		Assert.notNull(user, "user is null");
		List<User> users = this.selectByModel(user);
		if (users != null && !users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public IBaseDao<User> getDao() {
		return userDao;
	}

}
