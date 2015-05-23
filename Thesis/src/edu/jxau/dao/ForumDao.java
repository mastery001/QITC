package edu.jxau.dao;

import org.web.dao.core.support.AbstractVoDaoAdvice;
import org.web.dao.core.support.VoResolve;
import org.web.exception.DBException;

import edu.jxau.po.Article;
import edu.jxau.po.Grade;
import edu.jxau.po.User;
import edu.jxau.po.UserArticle;
import edu.jxau.po.UserClass;
import edu.jxau.vo.Forum;

public class ForumDao extends AbstractVoDaoAdvice {

	@Override
	protected VoResolve buildVoResolve() {
		// TODO Auto-generated method stub
		Class<?>[] allPo = new Class<?>[] { User.class, Grade.class,
				Article.class, UserClass.class, UserArticle.class };
		Class<?> voClass = Forum.class;
		Class<?>[] needPoObjectClass = new Class<?>[] { Article.class,
				UserArticle.class };
		return helpAdvice.getVoResolve(allPo, voClass, needPoObjectClass, null);
	}

	@Override
	protected void save(Object[] poValue) throws DBException {
		DAO.save(poValue[0]);
		Article article = (Article) DAO.query(Article.class, poValue[0], null, false).get(0);
		UserArticle ua = (UserArticle) poValue[1];
		ua.setA_id(article.getA_id());
		DAO.save(ua);
	}

	@Override
	protected Class<?>[] whenUpdateOrDeleteUnNecessaryClasses() {
		return new Class<?>[]{UserArticle.class};
	}
	
}
