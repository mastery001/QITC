package edu.jxau.dao;

import java.util.List;

import org.web.dao.core.support.AbstractVoDaoAdvice;
import org.web.dao.core.support.VoResolve;
import org.web.exception.DBException;

import edu.jxau.po.Grade;
import edu.jxau.po.User;
import edu.jxau.po.UserClass;
import edu.jxau.vo.UserInfo;

public class UserInfoDao extends AbstractVoDaoAdvice {

	@Override
	protected VoResolve buildVoResolve() {
		Class<?>[] allPo = new Class<?>[] { User.class, Grade.class,
				UserClass.class };
		Class<?> voClass = UserInfo.class;
		Class<?>[] needPoObjectClass = new Class<?>[] { User.class,
				UserClass.class };
		return helpAdvice.getVoResolve(allPo, voClass, needPoObjectClass, null);
	}

	@Override
	protected Class<?>[] whenUpdateOrDeleteUnNecessaryClasses() {
		return null;
	}

	public UserInfo getByUser(User user) throws DBException {
		UserInfo userInfo = new UserInfo();
		userInfo.setU_id(user.getU_id());
		List<Object> list = this.query(UserInfo.class, userInfo, null, false);
		if (list.size() == 0) {
			throw new DBException("该用户不存在！");
		}
		userInfo = (UserInfo) list.get(0);
		return userInfo;
	}

}
