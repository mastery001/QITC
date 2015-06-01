package edu.jxau.service;

import java.util.List;

import org.web.access.factory.DaoAdviceFactory;
import org.web.exception.DBException;
import org.web.exception.ErrorException;

import tool.mastery.log.Logger;
import edu.jxau.dao.UserInfoDao;
import edu.jxau.po.User;
import edu.jxau.vo.UserInfo;

public class UserService {

	private static final Logger LOG = Logger.getLogger(UserService.class);
	
	public UserService() {
	}
	
	public UserInfo execute(User user , String operate) throws ErrorException {
		try {
			DaoAdviceFactory.getDao("User").update(user);
			// 如果是基本信息更改,则需要更新session中的user
			if(!"ps".equals(operate)) {
				return new UserInfoDao().getByUser(user);
			}
		}catch (DBException e) {
			throw new ErrorException(e.getMessage());
		}
		return null;
	}
	
	public User getUser(String u_id) {
		if (u_id != null) {
			User user = new User();
			user.setU_id(u_id);
			try {
				user = (User) DaoAdviceFactory.getDao("User").get(user);
			} catch (Exception e) {
				// 该异常将不会被抛出，如果出错请查看日志
				LOG.debug(e.getMessage() , e );
			}
			return user;
		}
		return null;
	}
	
	/** 
	* @Title: validateUserIsExist 
	* @Description: 验证该用户是否存在，若user参数为null，抛出NullPointerException 
	* @param @param user
	* @param @return   
	* @return boolean    返回类型 
	* @throws 
	*/ 
	public boolean validateUserIsExist(User user) {
		if(user != null) {
			try {
				List<Object> list = DaoAdviceFactory.getDao("User").query(User.class, user, null, false);
				if(list.size() != 0) {
					return true;
				}
			}catch (DBException e) {
				// 该异常将不会被抛出，如果出错请查看日志
				LOG.debug(e.getMessage() , e );
			}
		}
		
		return false;
	}
	
}
