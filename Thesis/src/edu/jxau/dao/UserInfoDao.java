package edu.jxau.dao;

import org.web.dao.core.support.AbstractVoDaoAdvice;
import org.web.dao.core.support.VoResolve;

import edu.jxau.po.Grade;
import edu.jxau.po.User;
import edu.jxau.po.UserClass;
import edu.jxau.vo.UserInfo;

public class UserInfoDao extends AbstractVoDaoAdvice {

	@Override
	protected VoResolve buildVoResolve() {
		Class<?>[] allPo = new Class<?>[] { User.class, Grade.class,
				UserClass.class};
		Class<?> voClass = UserInfo.class;
		
		return helpAdvice.getVoResolve(allPo, voClass, null, null);
	}

	@Override
	protected Class<?>[] whenUpdateOrDeleteUnNecessaryClasses() {
		return null;
	}

}
