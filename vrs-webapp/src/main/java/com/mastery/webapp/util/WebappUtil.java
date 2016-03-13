/*
 * @Title: WebappUtil.java
 * 
 * @Package com.letv.mms.util
 * 
 * @Description: TODO
 * 
 * @author xufei1 <xufei1@letv.com>
 * 
 * @date 2013-1-24 下午10:14:34
 * 
 * @version V1.0
 * 
 * Modification History: Date Author Version Description
 * -------------------------------------------------------------- 2013-1-24
 */
package com.mastery.webapp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.mastery.data.base.BaseVo;

/**
 * <p>
 * </p>
 * 
 * @author zouziwen Create at:2013-1-24 下午10:14:34
 */
public class WebappUtil {

	/**
	 * 对象为空且id都不为空
	 * @time 2016年3月12日下午8:34:32
	 * @param vo
	 * @return
	 */
	public static boolean objectAndIdNotNull(BaseVo vo) {
		if(vo == null || vo.getId() == null) {
			return false;
		}
		return true;
	}
	 
	/**
     * 去除首位flag
     * 
     * @param str
     * @return
     */
	public static String removeFirstAndEndFlag(String str, String flag) {
		if (null == str) {
			return "";
		}
		if (str.startsWith(flag)) {
			str = str.replaceFirst(flag, "");
        }
        if (str.endsWith(flag)) {
            str = str.substring(0, str.lastIndexOf(flag));
        }
		return str;

	}

	                        /**
     * @author xufei<xufei1@letv.com> 数组转换为字符串以flag分割
     * @param array
     * @param flag
     * @return
     */
	public static String arrayToStringWithFLag(String[] array, String flag) {
        if (array == null || array.length == 0
                        || (!StringUtils.hasLength(array[0]) && array.length == 1)) {// 排除数组值大小为1且值为空的数据
			return null;
		}

		StringBuilder result = new StringBuilder(flag);
		for (int i = 0, size = (array == null ? 0 : array.length); i < size; i++) {
			result.append(array[i]);
			if (i != (size - 1)) {
				result.append(flag);
			}
		}
		result.append(flag);
		return result.toString();
	}
	
	                        /**
     * 把list中的元素组成 ,a,a,a,a,
     * 
     * @param list
     * @param flag
     * @return
     */
	public static String listToStringWithFlag(List<String> list, String flag) {
		if (CollectionUtils.isEmpty(list)) {
			return null;
		} 
		StringBuilder result = new StringBuilder(flag);
		for (String item : list) {
			if (StringUtils.hasLength(item)) {				
				result.append(item).append(flag);
			}
		}
		
		return result.toString();
	}

	/**
	 * @param str
	 * @param flag
	 * @return
	 */
	public static String stringToStringWithFLag(String str, String flag) {
		return flag + str + flag;
	}

	                        /**
     * @author xufei<xufei1@letv.com> 将以flag分割的字符串转换为数组
     * @param str
     * @return
     */
	public static String[] strToArrayWithFlag(String str, String flag) {
		List<String> list = new ArrayList<String>();
		if (!StringUtils.hasLength(str))
			return null;
		str = removeFirstAndEndFlag(str, flag);
		String[] strs = str.split(flag);
		for (String string : strs) {
			list.add(string);
		}
		String[] array = new String[list.size()];
		return list.toArray(array);
	}
	
	                        /**
     * @author xufei<xufei1@letv.com> 将以flag分割的字符串转换为List
     * @param str
     * @return
     */
	
	public static List<String> strToListWithFlag(String str, String flag) {
		List<String> list = new ArrayList<String>();
		if (!StringUtils.hasLength(str))
			return list;
		str = removeFirstAndEndFlag(str, flag);
		String[] strs = str.split(flag);
		for (String string : strs) {
			list.add(string);
		}
		
		return list;
	}
	
	                        /**
     * @author xufei<xufei1@letv.com> 将以flag分割的字符串转换为数组 num保持与主演一致显示数量，解决velocity前端报错
     * @param str
     * @param num
     * @return
     */
	public static String[] strToArrayWithFlag(String str, String flag, int num) {
		List<String> list = new ArrayList<String>();
		if (!StringUtils.hasLength(str))
			return null;
		str = removeFirstAndEndFlag(str, flag);
		String[] strs = str.split(flag);
		for (String string : strs) {
			list.add(string);
		}
		int length = list.size();
		if (num > length) {
			int temp = num - length;
			for (int i = 0; i < temp; i++) {
			list.add("");
			}
			length = num;
		}
		String[] array = new String[length];
		return list.toArray(array);
	}

	                        /**
     * @author xufei<xufei1@letv.com> 将以flag分割的字符串转换为Long数组
     * @param str
     * @return
     */
	public static List<Long> strToLongListWithFlag(String str, String flag) {
		List<Long> list = new ArrayList<Long>();
		if (null == str)
			return null;
		str = removeFirstAndEndFlag(str, flag);
		String[] strs = str.split(flag);
		for (String string : strs) {
			list.add(Long.valueOf(string));
		}
		return list;
	}

	                        /**
     * @author xufei<xufei1@letv.com> 将字符串转换为数组
     * @param str
     * @param flag
     * @return
     */
	public static String[] jsonStrToArray(String str) {
		if (!StringUtils.hasLength(str)) {
			return null;
		}
		JSONArray ja = JSONArray.parseArray(str);
		String[] array = new String[ja.size()];
		return ja.toArray(array);
	}
	
    /**
     * @author xufei<xufei1@letv.com> 将字符串转换为数组
     * @param str
     * @param flag
     * @return
     */
	public static String[] jsonStrToArray(String str,int num) {
		if (!StringUtils.hasLength(str)) {
			return null;
		}
		JSONArray ja = JSONArray.parseArray(str);
		int temp = ja.size();
		if(temp<num){
			int flag = num-temp;
			for(int i=0;i<flag;i++){
				ja.add("");
			}
			temp = num;
		}
		String[] array = new String[temp];
		return ja.toArray(array);
	}

	

	public static String escapeHtml(Object value) {
		if (value == null)
			return null;
		if (value instanceof String) {
			String result = value.toString();
			// "'<>&
			result = result.replaceAll("&", "&amp;").replaceAll(">", "&gt;")
					.replaceAll("<", "&lt;").replaceAll("\"", "&quot;")
					.replaceAll("\'", "&acute;");
			return result;
		} else {
			return value.toString();
		}
	}

	public static String FomartStr(String str) {
		if (!StringUtils.hasLength(str))
			return null;
        str = new StringBuilder(str).reverse().toString(); // 先将字符串颠倒顺序
		String fomartStr = "";
		for (int i = 0; i < fomartStr.length(); i++) {
			if (i * 3 + 3 > fomartStr.length()) {
				fomartStr += str.substring(i * 3, str.length());
				break;
			}
			fomartStr += str.substring(i * 3, i * 3 + 3) + ",";
		}
		if (fomartStr.endsWith(",")) {
			fomartStr = fomartStr.substring(0, fomartStr.length() - 1);
		}
        // 最后再将顺序反转过来
		return new StringBuilder(fomartStr).reverse().toString();

	}

	                        /**
     * 将传入的数字转换成以逗号分隔的形式，如传入123456789，转换成123,456,789
     * 
     * @author qifeng
     * @param number
     * @return
     */
	public static String getShowNumber(Integer number) {
        // 如果是负数，取正
		boolean bellowzero = false;
		if (number < 0) {
			bellowzero = true;
			number = -number;
		}
		StringBuilder sb = new StringBuilder(number + "");
        // 根据数字的大小决定循环几次
		int count = (sb.length() - 1) / 3;
		int mod = sb.length() % 3 == 0 ? 3 : sb.length() % 3;
		for (int i = 1; i <= count; i++) {
			sb.insert(mod + 3 * (count - i), ",");
		}
		if (bellowzero) {
			sb.insert(0, "-");
		}
		return sb.toString();
	}
	
	  
	
	
	                        /**
     * 
     * 获取两个List的不同元素
     * 
     * @param list1
     * 
     * @param list2
     * 
     * @return
     */
	    
	public static List<String> getDiffrent(List<String> list1,
			List<String> list2) {

		Map<String, Integer> map = new HashMap<String, Integer>(list1.size()
				+ list2.size());
		List<String> diff = new ArrayList<String>();
		List<String> maxList = list1;
		List<String> minList = list2;
		if (list2.size() > list1.size()) {
			maxList = list2;
			minList = list1;
		}
		for (String string : maxList) {
			map.put(string, 1);
		}
		for (String string : minList) {
			Integer count = map.get(string);
			if (count != null) {
				map.put(string, ++count);
				continue;
			}
			map.put(string, 1);
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()){
			if (entry.getValue() == 1) {
				diff.add(entry.getKey());
			}
		}
		return diff;
	}
	
	public static String revertEscapeHtml(Object value) {
		if (value == null)
			return null;
		if (value instanceof String) {
			String result = value.toString();
			// "'<>&
			result = result.replaceAll("&amp;", "&").replaceAll("&gt;", ">")
					.replaceAll("&lt;", "<").replaceAll("&quot;", "\"")
					.replaceAll("&acute;", "\'");
			return result;
		} else {
			return value.toString();
		}
	}

}
