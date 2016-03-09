package com.mastery.data.base.support;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastery.common.exception.CommonException;
import com.mastery.data.base.IConvert;

/**
 * 抽象转换接口
 * @author zouziwen
 *
 * 2016年3月8日 下午2:39:57
 */
public class AbstractConvert implements IConvert {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public <K> K convert(Object convertObject, Class<K> retClass) {
		return innerConvert(convertObject, retClass);
	}

	@Override
	public <K> List<K> convert(List<? extends Object> convertObjects, Class<K> retClass) {
		List<K> list = null;
		if (convertObjects != null && !convertObjects.isEmpty()) {
			list = new ArrayList<K>(convertObjects.size());
			for (Object convertObject : convertObjects) {
				list.add(convert(convertObject, retClass));
			}
		}
		return list;
	}

	protected <K> K innerConvert(Object convertObject, Class<K> retClass) {
		if(convertObject == null) {
			return null;
		}
		K retVal;
		try {
			retVal = retClass.newInstance();
			copyValue(retVal , convertObject , "serialVersionUID");
		} catch (Exception e) {
			logger.info("value convert failed! exception is {}", e);
			throw new CommonException("value convert failed! exception is {}", e);
		}
		return retVal;
	}
	
	/**
	 * 将一个对象属性值赋值到另一个对象中
	 * @param retObj		需要赋值的对象
	 * @param obj			有值的对象
	 * @param uncopyField	不需要赋值的字段
	 * @return
	 * @throws VoProcessorException 
	 */
	protected void copyValue(Object retObj , Object obj , String uncopyField) throws Exception {
		//得到值对象的所有字段
		Field[] objFields = obj.getClass().getDeclaredFields();
		if(uncopyField == null) {
			uncopyField = "";
		}
		//得到不需要赋值的字段
		String[] uncopyFields = uncopyField.split(",");
		for(Field field : objFields) {
			String objFieldName = field.getName();
			
			//当两者中的属性字段名不相同时
			try {
				retObj.getClass().getDeclaredField(objFieldName);
			} catch (Exception e1) {
				e1.printStackTrace();
				continue;
			} 
			if(!isExist(objFieldName, uncopyFields)) {
				try {
					//得到该字段的值
					Object retVal = PropertyUtils.getProperty(obj, objFieldName);
					//将该字段的值赋给需要返回的对象
					PropertyUtils.setProperty(retObj, objFieldName, retVal);
				} catch (Exception e) {
					throw e;
				} 
			}
		}
	}
	
	private boolean isExist(String fieldName , String[] uncopyFields) {
		for(int i = 0 ; i < uncopyFields.length ; i ++) {
			if(fieldName.equals(uncopyFields[i])) {
				return true;
			}
		}
		return false;
	}
}
