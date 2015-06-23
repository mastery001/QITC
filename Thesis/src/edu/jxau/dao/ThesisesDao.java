package edu.jxau.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				UserThesis.class};
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
	
	public String[] getAllThesisPath() throws DBException  {
		String[] paths = null;
		String sql = "select document from t_thesis where isdelete=0";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.last();
			paths = new String[rs.getRow()];
			rs.beforeFirst();
			int index = 0;
			while(rs.next()) {
				paths[index++] = rs.getString("document");
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		return paths;
	}
}
