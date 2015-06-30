package edu.jxau.dao;

import java.io.FileNotFoundException;

import org.web.dao.core.support.AbstractVoDaoAdvice;
import org.web.dao.core.support.VoResolve;
import org.web.exception.DBException;
import org.web.framework.action.support.InitOperations;

import tool.mastery.file.FileUtils;

import edu.jxau.po.Grade;
import edu.jxau.po.Thesis;
import edu.jxau.po.User;
import edu.jxau.po.UserClass;
import edu.jxau.po.UserThesis;
import edu.jxau.vo.Thesises;

public class ThesisesDao extends AbstractVoDaoAdvice {

	@Override
	protected VoResolve buildVoResolve() {
		Class<?>[] allPo = new Class<?>[] { User.class, Grade.class,
				Thesis.class, UserClass.class, UserThesis.class };
		Class<?> voClass = Thesises.class;
		Class<?>[] needPoObjectClass = new Class<?>[] { Thesis.class,
				UserThesis.class };
		return helpAdvice.getVoResolve(allPo, voClass, needPoObjectClass, null);
	}

	@Override
	protected Class<?>[] whenUpdateOrDeleteUnNecessaryClasses() {
		return new Class<?>[] { UserThesis.class };
	}

	@Override
	protected void save(Object[] poValue) throws DBException {
		Thesis t = (Thesis) poValue[0];
		if (t.getT_front() == null) {
			t.setT_front("images/noperson.jpg");
		}
		DAO.save(t);
		DAO.save(poValue[1]);
	}

	@Override
	protected void update(Object[] poValue) throws DBException {
		for (Object po : poValue) {
			DAO.update(po);
		}
	}

	@Override
	protected void delete(Object[] poValue) throws DBException {
		Thesis t = (Thesis) poValue[0];
		if (t.getIsdelete() == null) {
			// 将是否删除的标记为设置为1，代表此论文删除
			t.setIsdelete(1);
			DAO.update(t);
		} else {
			t = (Thesis) DAO.get(t);
			try {
				// 将该论文对应的文档和封面删除
				FileUtils.delFile(InitOperations.ServicesPath, t.getDocument());
				if(t.getT_front() != null && t.getT_front().contains("noperson")) {
					FileUtils.delFile(InitOperations.ServicesPath, t.getT_front());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 如果存在状态标记是已经在回收站的数据，则直接删除
			DAO.delete(t);
		}
	}

}
