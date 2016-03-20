package com.mastery.data.base;

import java.util.List;

/**
 * 模糊搜索器
 * @author mastery
 * @time 2016年3月20日上午9:45:35
 */
public interface IBaseVagueSelector<T>{

	/**
	 * 按名称模糊搜索
	 * @time 2016年3月20日上午9:43:51
	 * @param t
	 * @return
	 */
	public List<T> selectVagueByModel(T t);
}
