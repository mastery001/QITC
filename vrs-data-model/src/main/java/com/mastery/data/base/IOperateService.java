package com.mastery.data.base;

import java.util.List;

/**
 * 操作的Service可能出现的操作
 * @author zouziwen
 *
 * @param <T>
 * 2016年3月8日 下午6:00:11
 */
public interface IOperateService<T> {


	/**
	 * 插入记录
	 * @return
	 * @throws Exception
	 */
	void insert(T t);
	
	/**
	 * 修改记录
	 * @return
	 * @throws Exception
	 */
	 void update(T t);
	
	/**
	 * 根据id删除记录
	 * @param ids
	 * @throws Exception
	 */
	void delete(T t);
	
	/**
	 * 根据id查找记录记录，返回单条记录
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	T selectById(Long id);
	
	/**
	 * 根据map查询list记录，分页,默认10条
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	List<T> selectByModel(T t);
	
}
