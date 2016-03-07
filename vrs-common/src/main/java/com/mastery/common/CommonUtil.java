/*
 * Pprun's Public Domain.
 */
package com.mastery.common;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.util.StringUtils;

import com.mastery.common.exception.CommonException;


/**
 * Constant used in the utility method.
 * 
 * @author <a href="mailto:quest.run@gmail.com">pprun</a>
 */
public class CommonUtil {
	public static final String UTF8 = "UTF-8";
	public static final String GB18030 = "GB18030";
	public static final String GBK = "gbk";
	public static final String TIME_ZONE_UTC = "UTC";
	private static final String ipRegex = "\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b";
	/**
	 * This is quick way to round a {@link BigDecimal#setScale(2,
	 * java.math.RoundingMode.ROUND_HALF_UP)}.
	 * <p>
	 * No roundingMode parameter was provided because, I trust, if you know how
	 * to specify the {@literal roundingMode}, you might not need this utility
	 * method.
	 * </p>
	 * 
	 * @param value
	 *            the value to round.
	 * @return the rouned value by setting the scale to {@literal 2} and
	 *         {@literal RuondingMode} to {@link BigDecimal#ROUND_HALF_UP}.
	 */
	public static BigDecimal round(BigDecimal value) {
		return value.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 四舍五入
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int round(int num1, int num2) {
		if (num1 == 0 || num2 == 0) {
			return 0;
		}
		BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);
        Double d = b1.divide(b2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return d.intValue();
	}

	/**
	 * Make an empty {@code ""} if the given String is {@code null}.
	 * 
	 * @param src
	 * @return
	 */
	public static String nullToEmpty(String src) {
		return src == null ? "" : src;
	}

	public static String join(Collection<String> collectionOfStrings,
			String delimeter) {
		StringBuilder result = new StringBuilder();
		for (String s : collectionOfStrings) {
			result.append(s);
			result.append(delimeter);
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * 将列名转换成属性名
	 * 
	 * @param columnName
	 * @return
	 */
	public static String changeDbName2JavaName(String name){
		if (!StringUtils.hasText(name)) {
			return null;
		}
        name = name.toLowerCase();
        String[] split = name.split("_");
        if (split.length > 1) {
            StringBuilder sb = new StringBuilder(split[0]);
            for (int i = 1; i < split.length; i++) {
                String columnName = split[i].substring(0, 1).toUpperCase() + split[i].substring(1, split[i].length());
                sb.append(columnName);
            }
            return sb.toString();
        } else {
            return name;
        }
    }

	/**
	 * 将属性名换成列名
	 * 
	 * @param attributeName
	 * @return
	 */
	public static String convertAttrNameToColumnName(String attributeName) {
		char[] flag = attributeName.toCharArray();
		StringBuilder sum = new StringBuilder();
		for (char a : flag) {

			String str = String.valueOf(a);
			if (str.toLowerCase().charAt(0) - a == 32) {
				str = "_" + str.toLowerCase();
			}
			sum.append(str.toUpperCase());
		}
		return sum.toString();

	}

	/**
	 * 将一个字符串的首字母改成大写
	 * 
	 * @param str
	 * @return
	 */
	public static String toFirstLetterUpperCase(String str) {
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0, 1).toUpperCase());
		sb.append(str.substring(1));
		return sb.toString();
	}
	
	/**
	 * 将一个字符串的首字母改成小写
	 * 
	 * @param str
	 * @return
	 */
	public static String toFirstLetterLowerCase(String str) {
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0, 1).toLowerCase());
		sb.append(str.substring(1));
		return sb.toString();
	}

	/**
	 * @author xufei<xufei1@letv.com> 将一个 JavaBean 对象转化为一个 Map
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 */
	public static <K,V> Map<K,V> convertBeanToMap(Object bean) {
		Map<K, V> map = new HashMap<K,V>();
		try {
			map = BeanUtils.describe(bean);
		} catch (IllegalAccessException e) {
			throw new CommonException("bean转换map:实例化 JavaBean 失败", e);
		} catch (InvocationTargetException e) {
			throw new CommonException("bean转换map:实例化 JavaBean 失败", e);
		} catch (NoSuchMethodException e) {
			throw new CommonException("bean转换map:调用属性的 setter 方法失败",e);
		}
		return map;
	}

	/**
	 * 将一个 Map 对象转化为一个 JavaBean
	 * @param <T>
	 * 
	 * @param type
	 *            要转化的类型
	 * @param map
	 *            包含属性值的 map
	 * @return 转化出来的 JavaBean 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InstantiationException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	public static <T> T convertMapToBean(Class<?> type, Map<?,?> map) {
		//改造传入的map,将传入map的key值转换成 驼峰式命名规则 如  TYPE_ID 转换为 typeId
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Iterator<?> iterator = map.keySet().iterator();
		while (iterator.hasNext()){
			String key = (String) iterator.next();
			String newKey = "";
			if(!isPropertyName(key)){
				newKey = changeDbName2JavaName(key.toLowerCase());
			}else{
				newKey = key;
			}
			resultMap.put(newKey, map.get(key));
		}
		T obj = null ;
		try{
			obj = (T) type.newInstance(); // 创建 JavaBean 对象
		} catch (IllegalAccessException e) {
			throw new CommonException("反射安全异常,没有方法的访问权限!",e);
		} catch (InstantiationException e) {
			throw new CommonException("实例化异常!",e);
		}
		
		try {
			BeanUtils.populate(obj, resultMap);
		} catch (IllegalAccessException e) {
			throw new CommonException("反射时参数不合法异常!",e);
		} catch (InvocationTargetException e) {
			throw new CommonException("通过反射执行方法异常!",e);
		}
		return obj;
	}

	/**
	 * 判断给定字符串是否符合属性命名规范
	 * 首字母小写的驼峰命名规范
	 * @param str
	 * @return
	 */
	public static boolean isPropertyName(String str){
		boolean flag = true ;
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			//判断字符是否为字母
			if(!Character.isLetter(ch)){
				flag = false;
				break;
			}
			//判断首字母是否小写
			if(i == 0 && Character.isUpperCase(ch)){
				flag = false;
				break;
			}
		}
		return flag;
	}
	/**
	 * 比较model是否符合conditionModel  如果model完全符合conditionModel中条件
	 * 返回true 否则返回false
	 * 如 model_A:{proId:2,proName:"xxx",type:"CCC"}  
	 *    conditionModel_B:{proName:"xxx"}
	 *   方法返回true 
	 * @param model
	 * @param conditionModel
	 * @return
	 */
	public static <T> boolean isFitModel(T model,T conditionModel){
		boolean flag = true;
		if(!model.getClass().equals(conditionModel.getClass()))
			return false;
		//首先判断两个moudel是不是同样类型,若果不是返回false
		//获得作为条件的model的所有属性字段
		Field [] propertys = conditionModel.getClass().getDeclaredFields();
		for(int i = 0;i<propertys.length;i++){
			Field field = propertys[i];
			String propertyName = field.getName();
			//获得条件model的所有方法
			Method [] methods = conditionModel.getClass().getDeclaredMethods();
			for(int j = 0;j<methods.length;j++){
				Method method = methods[j];
				String methodName = method.getName();
				//如果是set方法跳出本次循环
				if(methodName.startsWith("set")){
					continue;
				}
				//判断是不是get方法   boolean的get方法是以is开头,普通的方法是以get开头,而且不带参数 ,其它方法也跳出本次循环
				if((method.getParameterTypes().length == 0)&&(methodName.equals(getPropertyName(propertyName))) && (methodName.startsWith("get") || methodName.startsWith("is"))){
					try {
//						System.out.println("pName:"+field.getName()+"  mName:"+method.getName()+"   propertyName:"+propertyName+"     method:"+methodName+"      modelValue:"+method.invoke(model)+"    conValue:"+method.invoke(conditionModel) +"   modelIsNull:"+(null == method.invoke(model))+"   conIsNull:"+(null == method.invoke(conditionModel)));
						//得到的值为null跳出本次循环,得到的值不相等也跳出本次循环
						if(null == method.invoke(conditionModel)){
							if(null != method.invoke(model)){
								flag = false;
								break;
							}else if(null == method.invoke(model)){
								continue;
							}
						}else{
								if(null != method.invoke(model)){
									if(! method.invoke(model).equals(method.invoke(conditionModel))){
										flag = false;
										break;
									}
								}else if(null == method.invoke(model)){
									continue;
							} 
						}
					} catch (IllegalArgumentException e) {
						throw new CommonException("反射时传入参数不合法!",e);
					} catch (IllegalAccessException e) {
						throw new CommonException("反射安全异常,没有方法的访问权限!",e);
					} catch (InvocationTargetException e) {
						throw new CommonException("通过反射执行方法异常!",e);
					}
				}else{
					continue;
				}
			}
			if(! flag){
				break;
			}
		}
		return flag; 
	}
	private static String getPropertyName(String str){
		return "get"+toFirstLetterUpperCase(str);
	}
	public static boolean notNullAndEmpty(String str){
		boolean result = true;
		if(null == str||"".equals(str.trim())){
			result =false;
		}
	
	return result; 
	}
	
	/**
	 * 把一些原有系统的字典值转成现有系统的字典值
	 * 
	 * @param valueId
	 * @param objectType
	 * @param typeId
	 * @param count
	 * @return
	 */
	public static Integer fillValueId(String valueId,int objectType, Integer typeId, int count) {
		if (valueId == null || valueId.length() < 1) {
			return null;
		}
		if ("-1".equals(valueId)) {
			return -1;
		}
		valueId = valueId.trim();

		StringBuilder sb = new StringBuilder();
		while (valueId.length() < count) {
			sb.append("0").append(valueId);
			valueId = sb.toString();
			sb = new StringBuilder();
		}
		
		return Integer.parseInt(String.valueOf(typeId) +objectType+ valueId);
	}
	/**
	 * 把原有的码率代码转成新的字典值
	 * @param oldCode
	 * @return
	 */
	public static String convertOldCode2New(String oldCode) {
		//数据库中原有记录convertid为字符串null vid= 1769395, 1769396
		if (!StringUtils.hasLength(oldCode) || "null".equals(oldCode)) {
			return null;
		}
		String[] arr = oldCode.split(Constant.SPLIT_STRING);
		StringBuilder sbBuilder = new StringBuilder(",");
		for (int i = 0; i < arr.length; i++) {
			sbBuilder.append(CommonUtil.fillValueId(arr[i], 2, 25, 3)).append(",");
		}
		return sbBuilder.toString();
	}
	/**
	 * 把新的字典值代码转成原有的码率
	 * @param oldCode
	 * @return
	 */
	public static int convertNewCode2Old(int newCode) {
		
		return newCode-252000;
	}
	
	public static Float formatFloat(Object o) {
    	if (o == null) {
    		return 0F;
    	}
		String s = (String) o;
		if (StringUtils.hasLength(s)) {
			return Float.parseFloat(s);
		}
		return 0F;
	}
	
    public static String formatString(Object o) {
    	if (o == null) {
    		return Constant.BLACK_STRING;
    	}
		String s = (String) o;
		if (StringUtils.hasLength(s)) {
			return s;
		} else {
			return Constant.BLACK_STRING;
		}
	}
	
    public static int formatNum(Object o) {
    	if (o == null) {
    		return Constant.INIT_NUM;
    	} else {
    		Integer num = (Integer) o;
    		return num;
    	}
	}
	
    public static Long formatLong(Object o) {
		if (o == null) {
			return 0L;
		}
		if (o instanceof Long) {
			Long num = (Long) o;
			return num;
		}else {
			Integer num = (Integer) o;
			return num.longValue();
		}
	}
    
    public static Long formatString2Long(Object o) {
		if (o == null) {
			return 0L;
		}
		String s = (String) o;
		if (StringUtils.hasLength(s)) {
			return Long.parseLong(s);
		}
		return 0L;
	}
	
    public static int formatString2Num(Object o) {
    	if (o == null) {
    		return Constant.INIT_NUM;
    	}
		String s = (String) o;
		if (StringUtils.hasLength(s) && !"null".equals(s)) {
			return NumberUtil.parseInt(s);
		}else {
			return Constant.INIT_NUM;
		}
		
	}
	
    public static int formatTime2Num(Object o) {
    	if (o == null) {
    		return Constant.INIT_NUM;
    	}
		String s = (String) o;
		if (StringUtils.hasLength(s) && !"null".equals(s)) {
			String[] array = s.split(":");
			int sum = 0;
			sum = NumberUtil.parseInt(array[0]) * 3600 + NumberUtil.parseInt(array[1]) * 60 + NumberUtil.parseInt(array[2]);
			return sum;
		}else {
			return Constant.INIT_NUM;
		}
		
	}
    
    /**
     * 验证IP格式
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddress(String ipAddr) {
    	Pattern pattern = Pattern.compile(ipRegex);
    	Matcher m = pattern.matcher(ipAddr);
    	return m.matches();
    }
    
    /**
     * 字符串数组转换为int数组
     * 
     * @param str
     * @return
     */
    public static long[] convertStringsToLongs(String[] str) {
    	long[] result = new long[str.length];
    	for (int i = 0; i < str.length; i++) {
    		if (StringUtils.hasLength(str[i])) {
    			result[i] = NumberUtils.toInt(str[i]);
    		}
		}
    	return result;
    }
    
    /**
     * 计算子集subs数组在array数组中元素的位，并转换为十进制输出.
     * 目的位了实现多种状态值的组合，接口中使用一个int类型字段表示最终值
     * 调用端需要根据这个值解析计算出来包含的实际哪些状态值.
     *
     * @param array
     * @param subs
     * @return
     */
    public static int posConvertInt(String[] array, String[] subs){
		if (ArrayUtils.isEmpty(array) || ArrayUtils.isEmpty(subs)) {
			return 0;
		}
		
		List<String> arraylist = Arrays.asList(array);
		BitSet bs = new BitSet(array.length);
		for (String li : subs) {
			int index = arraylist.indexOf(li);
			// index 小于0 不合法
			if (index >= 0) {
				bs.set(index, true);
			}
		}
		
		StringBuffer buf = new StringBuffer(array.length);
		for (int i = array.length - 1; i >= 0; i--){
			buf.append(bs.get(i) ? '1' : '0');
		}
		
		BigInteger bint = new BigInteger(buf.toString(), 2);
		return bint.intValue();
	}

}
