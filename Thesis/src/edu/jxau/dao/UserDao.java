package edu.jxau.dao;

import java.util.List;

import org.web.dao.core.support.DefaultDaoAdvice;
import org.web.dao.core.support.Page;
import org.web.exception.DBException;

public class UserDao extends DefaultDaoAdvice{

	@Override
	public List<Object> query(Class<?> entityClass, Object entity, Page page,
			boolean flag) throws DBException {
		// TODO Auto-generated method stub
		return super.query(entityClass, entity, page, flag);
	}
	
	
	
}
