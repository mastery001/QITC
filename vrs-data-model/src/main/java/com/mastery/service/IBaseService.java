package com.mastery.service;

import java.util.List;
import java.util.Map;

import com.mastery.common.sql.object.SqlBuilder;

public interface IBaseService<T> {

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
	 * 修改记录，至修改不为空的字段
	 * @param t
	 * @throws Exception
	 */
	void updateBySelective(T t) ;
	
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
	 * 根据model查询总数
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	Integer selectByModelCount(T t);
	
	/**
	 * 根据map查询总数
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	<K,V> Integer selectByMapCount(Map<K,V>  map);
	
	/**
	 * 根据map查询list记录，分页,默认10条
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	List<T> selectByModel(T t);
	
	/**
	 * 根据map查询list记录，不分页。
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	<K,V> List<T> selectByMap(Map<K,V>  map);
	
	/**
	 * 取得当前service对应的实体类型
	 *
	 * @author zouziwen
	 * @date 2015年2月28日 下午5:28:50 
	 * @return
	 */
	public Class<T> getEntityClass();
	
	/**
	 * 根据sql构造器查询对象
	 *
	 * @author zhumingyuan
	 * @date 2015年2月11日 下午6:32:05 
	 * @param sqlBuilder
	 * @return
	 */
    public List<T> selectByBuilder(SqlBuilder sqlBuilder);

    /**
     * 根据sql构造器查询数量
     *
     * @author zhumingyuan
     * @date 2015年2月11日 下午6:32:50 
     * @param sqlBuilder
     * @return
     */
    public Integer selectCountByBuilder(SqlBuilder sqlBuilder);
}
