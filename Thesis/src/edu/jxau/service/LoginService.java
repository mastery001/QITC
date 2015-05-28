package edu.jxau.service;

import java.util.List;

import org.web.access.factory.DaoAdviceFactory;
import org.web.dao.core.DaoAdvice;
import org.web.exception.DBException;
import org.web.exception.ErrorException;

import tool.mastery.log.Logger;
import edu.jxau.dao.UserInfoDao;
import edu.jxau.po.User;
import edu.jxau.vo.UserInfo;

public class LoginService {

	private static final Logger LOG = Logger.getLogger(LoginService.class);
	
	private User user;
	private DaoAdvice dao;
	
	public LoginService(User user) {
		this.user = user;
		dao = DaoAdviceFactory.getDao("User");
	}

	public UserInfo login() throws ErrorException{
		if(user == null) {
			throw new NullPointerException("user对象不能为空");
		}
		UserInfo userInfo = null;
		try {
			List<Object> list = dao.query(user.getClass(), user, null, false);
			if(list.size() == 0) {
				throw new ErrorException("用户名或密码错误！请重新登录!");
			}
			userInfo = new UserInfoDao().getByUser((User)list.get(0));
		} catch (DBException e) { 
			LOG.debug(e.getMessage() , e);
			throw new ErrorException("系统数据库异常，请查看日志");
		}
		return userInfo;
	}
	
	
}
