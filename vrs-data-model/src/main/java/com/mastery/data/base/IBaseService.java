package com.mastery.data.base;

import java.util.List;
import java.util.Map;

import com.mastery.common.sql.object.SqlBuilder;

public interface IBaseService<T> extends IConvert,IOperateService<T> {

	
	/**
	 * 修改记录，至修改不为空的字段
	 * @param t
	 * @throws Exception
	 */
	void updateBySelective(T t) ;
	
	
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
	 * 根据map查询list记录，不分页。
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	<K,V> List<T> selectByMap(Map<K,V>  map);

	
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
