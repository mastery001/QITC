package edu.jxau.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.database.db.DBUtil;
import org.web.dao.core.support.AbstractPoDaoAdvice;
import org.web.exception.DBException;
import org.web.framework.action.support.InitOperations;

import tool.mastery.file.FileUtils;
import tool.mastery.log.Logger;
import edu.jxau.po.Documents;


public class DocumentsDao extends AbstractPoDaoAdvice{
	
	private static final Logger LOG = Logger.getLogger(DocumentsDao.class);
	
	@Override
	public void delete(Object entity) throws DBException {
		Documents doc = (Documents) super.get(entity);
		// 将该论文对应的文档删除
		try {
			FileUtils.delFile(InitOperations.ServicesPath,
					doc.getDocument());
		} catch (FileNotFoundException e) {
			LOG.debug(e.getMessage(), e);
		}
		super.delete(doc);
	}

	public String[] getAllThesisPath() throws DBException {
		Connection conn = DBUtil.getConnection();
		String[] paths = null;
		String sql = "select document from t_docs";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.last();
			paths = new String[rs.getRow()];
			rs.beforeFirst();
			int index = 0;
			while (rs.next()) {
				paths[index++] = rs.getString("document");
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DBUtil.close();
		}
		return paths;
	}
}
