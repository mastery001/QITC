package edu.jxau.dao;

import org.web.dao.core.support.AbstractVoDaoAdvice;
import org.web.dao.core.support.VoResolve;
import org.web.exception.DBException;

import edu.jxau.po.Grade;
import edu.jxau.po.Thesis;
import edu.jxau.po.User;
import edu.jxau.po.UserClass;
import edu.jxau.po.UserThesis;
import edu.jxau.vo.Thesises;

public class ThesisesDao extends AbstractVoDaoAdvice{

	@Override
	protected VoResolve buildVoResolve() {
		Class<?>[] allPo = new Class<?>[] { User.class, Grade.class,
				Thesis.class, UserClass.class, UserThesis.class };
		Class<?> voClass = Thesises.class;
		Class<?>[] needPoObjectClass = new Class<?>[] { Thesis.class,
				UserThesis.class , Grade.class };
		return helpAdvice.getVoResolve(allPo, voClass, needPoObjectClass, null);
	}

	@Override
	protected Class<?>[] whenUpdateOrDeleteUnNecessaryClasses() {
		return new Class<?>[]{UserThesis.class};
	}

	@Override
	protected void update(Object[] poValue) throws DBException {
		for(Object po : poValue) {
			DAO.update(po);
		}
	}

	@Override
	protected void delete(Object[] poValue) throws DBException {
		Thesis t = (Thesis) poValue[0];
		if(t.getIsdelete() == null) {
			// 将是否删除的标记为设置为1，代表此论文删除
			t.setIsdelete(1);
			DAO.update(t);
		}else {
			// 如果存在状态标记是已经在回收站的数据，则直接删除
			DAO.delete(t);
		}
		
	}
}
