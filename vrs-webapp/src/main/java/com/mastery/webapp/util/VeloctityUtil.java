package com.mastery.webapp.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.mastery.common.CalendarUtil;
import com.mastery.common.Constant;

public class VeloctityUtil {

	/**
	 * 从对象中取得给定属性的值
	 * 
	 * @param o
	 * @param propertyName
	 * @return
	 */
	public static Object getValueFromObject(Object o, String propertyName) {
	    if (null == o) {
	        return null;
	    }
		if (!StringUtils.hasLength(propertyName)) {
			return Constant.BLANK_STRING;
		}
		String methodName = "get" + propertyName.substring(0, 1).toUpperCase()
				+ propertyName.substring(1);
		try {
			Method method = o.getClass().getMethod(methodName);
			Object obj = method.invoke(o);
			if(obj instanceof String){
				return WebappUtil.escapeHtml(obj);}
			 return method.invoke(o);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("这个方法有错误呢:" + methodName + "   "
					+ e.getLocalizedMessage());
		}
		return Constant.BLANK_STRING;
	}
	
	/**
	 * xufei<xufei1@letv.com> 判断该字段是否必填
	 * 
	 * @param condition
	 * @return
	 */
	public boolean hasRequired(String condition){
		boolean result = false;
		if(StringUtils.hasLength(condition)&& condition.contains("required")){
			result = true;
		}
		return result;
	}

	/**
	 * 把数字转换成时间格式hh:mm:ss
	 * 
	 * @param num
	 * @return
	 */
	public String convertInt2Time(Integer num) {
		if (num == null) {
			return "00:00:00";
		}

		int hour = num / 3600;
		int minute = num % 3600 / 60;
		int second = num % 36600 % 60;

		StringBuilder sb = new StringBuilder();
		if (hour < 10) {
			sb.append("0");
		}
		sb.append(hour).append(":");
		if (minute < 10) {
			sb.append("0");
		}
		sb.append(minute).append(":");
		if (second < 10) {
			sb.append("0");
		}
		sb.append(second);
		return sb.toString();
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public String formatDate(Date date) {
		return CalendarUtil
				.getDateString(date, CalendarUtil.SIMPLE_DATE_FORMAT);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public String formatDateFormatShort(Date date) {
		return CalendarUtil
				.getDateString(date, CalendarUtil.SHORT_DATE_FORMAT);
	}
	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public String formatDateFormatShortStr(Object o, String propertyName) {
		System.out.println("d");
		return CalendarUtil
				.getDateString((Date)getValueFromObject(o,propertyName) , CalendarUtil.SHORT_DATE_FORMAT);
	}
	/**
	 * 主要用于select下拉列表，根据参数生成当前默认选中项
	 * 
	 * @param selectedValue
	 *            selectedValue
	 * @param currentValue
	 *            currentValue
	 * @return selected
	 */
	public String selected(String selectedValue, String currentValue) {
		if (selectedValue != null && selectedValue.equals(currentValue)) {
			return " selected";
		}
		return "";
	}

	/**
	 * 主要用于radio单选项，根据参数生成当前默认选中项
	 * 
	 * @param checkedValue
	 *            checkedValue
	 * @param currentValue
	 *            currentValue
	 * @return checked
	 */
	public String checked(String checkedValue, String currentValue) {
		if (checkedValue != null && checkedValue.equals(currentValue)) {
			return " checked";
		}
		return "";
	}

	/**
	 * 将以逗号分割的字符串转成数组
	 * 
	 * 
	 * @return
	 */
	public String[] getStrToArray(String str) {

		return WebappUtil.strToArrayWithFlag(str, ",");
	}
	
	/**
	 * 
	 * @param length
	 * @param width
	 * @param prefix
	 * @param url
	 * @return
	 */
	public String getPicUrl(Integer length, Integer width, String prefix, String url) {
		if (StringUtils.hasLength(url)) {
			return url;
		}
		if (StringUtils.hasLength(prefix) && !"/thumb/1".equals(prefix)) {
			return prefix + "_" + length + "_" + width + ".jpg";
		} else {
			return "javascript:;";
		}
	}
	
    
    /**
     *  判断是否含有某字符串
     */
    public boolean contains(String objOrigal, String objTo) {
    	if (objOrigal == null || objTo == null) {
    		return false;
    	}
    	if (objOrigal.indexOf(objTo) != -1) {
    		return true;
    	}
    	return false;
    }
    
    /**
     *  把图片地址替换成国广地址
     */
    public String picToTvUrl(String pic, Integer isTvVrs) {
    	if (pic == null || "".equals(pic.trim())) {
    		return pic;
    	}
    	if (isTvVrs != null && isTvVrs == Constant.TWO) {
    		return picToHsUrl(pic);
    	}
    	if (pic.contains("i0.letvimg.com")) {
    		return pic.replace("i0.letvimg.com", "i0.img.cp21.ott.cibntv.net");
    	} else if (pic.contains("i1.letvimg.com")) {
    		return pic.replace("i1.letvimg.com", "i1.img.cp21.ott.cibntv.net");
    	} else if (pic.contains("i2.letvimg.com")) {
    		return pic.replace("i2.letvimg.com", "i2.img.cp21.ott.cibntv.net");
    	} else if (pic.contains("i3.letvimg.com")) {
    		return pic.replace("i3.letvimg.com", "i3.img.cp21.ott.cibntv.net");
    	} 
    	else {
    		return pic;
    	}
    }
    
    /**
     *  把图片地址替换成华数地址
     */
    public String picToHsUrl(String pic) {
    	if (pic == null || "".equals(pic.trim())) {
    		return pic;
    	}
    	if (pic.contains("i0.letvimg.com")) {
    		return pic.replace("i0.letvimg.com", "i0.img.letv-epg.wasu.tv");
    	} else if (pic.contains("i1.letvimg.com")) {
    		return pic.replace("i1.letvimg.com", "i1.img.letv-epg.wasu.tv");
    	} else if (pic.contains("i2.letvimg.com")) {
    		return pic.replace("i2.letvimg.com", "i2.img.letv-epg.wasu.tv");
    	} else if (pic.contains("i3.letvimg.com")) {
    		return pic.replace("i3.letvimg.com", "i3.img.letv-epg.wasu.tv");
    	} 
    	else {
    		return pic;
    	}
    }
}
