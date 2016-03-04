package com.mastery.dao;

import java.util.List;
import java.util.Map;

import com.mastery.dao.sql.object.ISql;

public interface IBaseDao<T> {
	
	public void insert(T t);
	
	public void update(T t);
	
	public void updateBySelective(T t);
	
	public void delete(T t);
	
	public T selectById(Long Id);
	
	public Integer selectByModelCount(T  t);
	
	public <K,V> Integer selectByMapCount(Map<K,V>  map);
	
	public List<T> selectByModel(T t);
	
	public <K,V> List<T> selectByMap(Map<K,V>  map);
	
	public List<T> selectByBuilder(ISql sql);
	
	public Integer selectCountByBuilder(ISql sql);

}
