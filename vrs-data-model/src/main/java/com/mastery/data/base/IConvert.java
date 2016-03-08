package com.mastery.data.base;

import java.util.List;

/**
 * 数据模型转换接口
 * @author zouziwen
 *
 * 2016年3月8日 下午2:30:49
 */
public interface IConvert {
	
	/**
	 * 转换对象
	 * @param convertObject
	 * @param retClass
	 * @return
	 * 2016年3月8日 下午2:30:57
	 */
	<T> T convert(Object convertObject , Class<T> retClass);
	
	/**
	 * 转换list
	 * @param convertObject
	 * @param retClass
	 * @return
	 * 2016年3月8日 下午2:31:21
	 */
	<T> List<T> convert(List<? extends Object> convertObjects , Class<T> retClass);
}
