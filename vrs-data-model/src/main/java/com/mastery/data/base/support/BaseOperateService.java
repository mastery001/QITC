package com.mastery.data.base.support;

import java.util.List;

import com.mastery.common.CalendarUtil;
import com.mastery.common.PagingUtil;
import com.mastery.common.PagingUtil.PagingVO;
import com.mastery.data.base.BaseModel;
import com.mastery.data.base.BaseVo;
import com.mastery.data.base.IBaseDao;
import com.mastery.data.base.IOperateService;

/**
 * 包含继承了AbstractConvert的基础操作接口
 * 
 * @author zouziwen
 *
 * @param <V>
 * @param <M>
 *            2016年3月9日 上午10:00:22
 */
public abstract class BaseOperateService<V extends BaseVo, M extends BaseModel> extends AbstractConvert
		implements IOperateService<V> {

	public BaseOperateService() {
	}

	@Override
	public void insert(V t) {
		getDao().insert(convert(t, getModelClass()));
	}

	@Override
	public void update(V t) {
		if(t.getId() == null) {
			insert(t);
		}else {
			getDao().updateBySelective(convert(t, getModelClass()));
		}
	}

	@Override
	public void delete(V t) {
		M model = convert(t, getModelClass());
		model.setDeleted(true);
		getDao().delete(model);
	}

	@Override
	public List<V> selectByModel(V t) {
		return convert(getDao().selectByModel(convert(t, getModelClass())), getVoClass());
	}

	@Override
	public V selectById(Long id) {
		if (id != null) {
			M model = getDao().selectById(id);
			return convert(model, getVoClass());
		}
		return null;
	}

	protected abstract IBaseDao<M> getDao();
	
	/**
	 * 获取model对应的字节码
	 * @return
	 * 2016年3月9日 上午10:26:10
	 */
	public abstract Class<M> getModelClass();
	
	/**
	 * 获取vo对应的字节码
	 * @return
	 * 2016年3月9日 上午10:26:22
	 */
	public abstract Class<V> getVoClass();
	

	@SuppressWarnings("unchecked")
	@Override
	protected <K> K innerConvert(Object convertObject, Class<K> retClass) {
		K k = super.innerConvert(convertObject, retClass);
		if (convertObject instanceof BaseModel && k instanceof BaseVo) {
			M model = (M) convertObject;
			V vo = (V) k;
			vo.setCreateTimeStr(CalendarUtil.getDefaultDateString(model.getCreateTime()));
			vo.setUpdateTimeStr(CalendarUtil.getDefaultDateString(model.getUpdateTime()));
			convertModelToVo(model ,vo);
		} else if (convertObject instanceof BaseVo && k instanceof BaseModel) {
			V vo = (V) convertObject;
			M model = (M) k;
			int count = getDao().selectByModelCount((M) model);
			PagingVO pageVo = PagingUtil.getPagingSupport(vo.getNumPerPage(), count, vo.getPageNum(), 0);
			vo.setPageVo(pageVo);
			model.setBaseSize(vo.getNumPerPage());
			model.setBaseStart(pageVo.getRecordBegin());
			convertVoToModel(vo ,model);
		}
		return k;
	}

	/**
	 * 将vo转换成model的实现
	 * @time 2016年3月12日下午10:13:51
	 * @param vo
	 * @param model
	 */
	protected void convertVoToModel(V vo , M model) {
		
	}
	
	/**
	 * 将model转换成vo的实现
	 * @time 2016年3月12日下午10:14:09
	 * @param model
	 * @param vo
	 */
	protected void convertModelToVo(M model , V vo) {
		
	}
}
