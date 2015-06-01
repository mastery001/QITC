package edu.jxau.dao;

import org.web.dao.core.support.AbstractVoDaoAdvice;
import org.web.dao.core.support.VoResolve;

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
				UserThesis.class };
		return helpAdvice.getVoResolve(allPo, voClass, needPoObjectClass, null);
	}

	@Override
	protected Class<?>[] whenUpdateOrDeleteUnNecessaryClasses() {
		return new Class<?>[]{UserThesis.class};
	}

}
