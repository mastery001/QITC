package edu.jxau.service;

import org.web.access.factory.DaoAdviceFactory;
import org.web.dao.core.DaoAdvice;
import org.web.exception.DBException;
import org.web.exception.ErrorException;

import tool.mastery.log.Logger;
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
			User existUser = (User) dao.get(user);
			if(existUser == null) {
				throw new ErrorException("用户名或密码错误！请重新登录!");
			}
			userInfo = new UserInfo();
			userInfo.setU_id(user.getU_id());
			dao = DaoAdviceFactory.getDao("UserInfo");
			userInfo = (UserInfo) dao.query(UserInfo.class, userInfo, null, false).get(0);
		} catch (DBException e) { 
			LOG.debug(e.getMessage() , e);
			throw new ErrorException("系统数据库异常，请查看日志");
		}
		return userInfo;
	}
	
	
}
