package com.mastery.service;

import java.util.List;
import java.util.Map;

import com.mastery.common.CalendarUtil;
import com.mastery.common.PagingUtil;
import com.mastery.common.PagingUtil.PagingVO;
import com.mastery.common.sql.object.SqlBuilder;
import com.mastery.data.base.BaseModel;
import com.mastery.data.base.BaseVo;
import com.mastery.data.base.IBaseDao;
import com.mastery.data.base.IBaseService;

public abstract class AbstractBaseService<T extends BaseModel> extends AbstractConvert implements IBaseService<T> {

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

	@SuppressWarnings("unchecked")
	@Override
	protected <K> K innerConvert(Object convertObject, Class<K> retClass) {
		K k = super.innerConvert(convertObject, retClass);
		if(convertObject instanceof BaseModel && k instanceof BaseVo) {
			BaseModel model = (BaseModel)convertObject;
			BaseVo vo = (BaseVo)k;
			vo.setId(model.getId());
			vo.setCreateTimeStr(CalendarUtil.getDefaultDateString(model.getCreateTime()));
			vo.setUpdateTimeStr(CalendarUtil.getDefaultDateString(model.getUpdateTime()));
		}else if(convertObject instanceof BaseVo && k instanceof BaseModel) {
			BaseVo vo = (BaseVo)convertObject;
			BaseModel model = (BaseModel)k;
			int count = selectByModelCount((T)model);
			PagingVO pageVo = PagingUtil.getPagingSupport(vo.getNumPerPage(), count, vo.getPageNum(), 0);
			vo.setPageVo(pageVo);
			model.setId(vo.getId());
			model.setBaseSize(vo.getNumPerPage());
			model.setBaseStart(pageVo.getRecordBegin());
		}
		return k;
	}
	
	
}
