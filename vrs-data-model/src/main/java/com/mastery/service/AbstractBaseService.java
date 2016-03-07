package com.mastery.service;

import java.util.List;
import java.util.Map;

import com.mastery.common.sql.object.SqlBuilder;
import com.mastery.dao.IBaseDao;
import com.mastery.model.BaseModel;

public abstract class AbstractBaseService<T extends BaseModel> implements IBaseService<T> {

	protected final Class<T> entityClass;

	public AbstractBaseService(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void insert(T t) {
		 getDao().insert(t);
	}

	@Override
	public void update(T t) {
		getDao().update(t);
	}

	@Override
	public void updateBySelective(T t) {
		getDao().updateBySelective(t);
	}

	@Override
	public void delete(T t) {
		getDao().delete(t);
	}

	@Override
	public T selectById(Long id) {
		return getDao().selectById(id);
	}

	@Override
	public Integer selectByModelCount(T t) {
		return getDao().selectByModelCount(t);
	}

	@Override
	public <K, V> Integer selectByMapCount(Map<K, V> map) {
		return getDao().selectByMapCount(map);
	}

	@Override
	public List<T> selectByModel(T t) {
		return getDao().selectByModel(t);
	}

	@Override
	public <K, V> List<T> selectByMap(Map<K, V> map) {
		return getDao().selectByMap(map);
	}

	@Override
	public Class<T> getEntityClass() {
		return this.entityClass;
	}

	@Override
	public List<T> selectByBuilder(SqlBuilder sqlBuilder) {
		return getDao().selectByBuilder(sqlBuilder.build());
	}

	@Override
	public Integer selectCountByBuilder(SqlBuilder sqlBuilder) {
		return getDao().selectCountByBuilder(sqlBuilder.build());
	}

	/**
	 * 获取对应的dao
	 * @return
	 * 2016年3月7日 下午6:22:52
	 */
	public abstract IBaseDao<T> getDao();
}
