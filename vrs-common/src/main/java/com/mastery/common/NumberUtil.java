package com.mastery.common;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 处理数字格式化
 * 
 * @author Ben Liu
 */
public final class NumberUtil {

    /**
     * Constructor
     */
    private NumberUtil() {
    }

    /**
     * 格式化输出，保留两位小数<br />
     * 例如：输入1.23456789输出1.23，输入1.2356789输出1.24
     * 
     * @param num number
     * @return formatted string
     */
    public static String round(float num) {
        DecimalFormat format = new DecimalFormat("#.00");
        return format.format(num);
    }

    /**
     * 将字符串数组转换为整形List
     * 
     * @param strs 字符串数组
     * @return list<Integer>
     */
    public static List<Integer> convertStrsToInts(String[] strs) {
        List<Integer> list = new LinkedList<Integer>();

        if (strs == null || strs.length == 0) {
            return list;
        }

        for (String str : strs) {
            if (!StringUtils.isEmpty(str)) {
                list.add(new Integer(str));
            }
        }
        return list;
    }

    /**
     * 将字符串List转换为整形List
     * 
     * @param strs 字符串列表
     * @return list<Integer>
     */
    public static List<Integer> convertStrsToInts(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return new LinkedList<Integer>();
        }
        return convertStrsToInts(strs.toArray(new String[strs.size()]));
    }

    /**
     * 将字符串数组转换为长整型List
     * 
     * @param strs 字符串数组
     * @return list<Long>
     */
    public static List<Long> convertStrsToLongs(String[] strs) {
        List<Long> list = new LinkedList<Long>();

        if (strs == null || strs.length == 0) {
            return list;
        }

        for (String str : strs) {
        	if (str != null && str.length() > 0) {
        		list.add(new Long(str));
            }
        }
        return list;
    }

    /**
     * 将字符串List转换为长整型List
     * 
     * @param strs 字符串列表
     * @return list<Long>
     */
    public static List<Long> convertStrsToLongs(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return new LinkedList<Long>();
        }
        return convertStrsToLongs(strs.toArray(new String[strs.size()]));
    }

    /**
     * 根据总共记录数和每页的记录数，计算总共的页数
     * 
     * @param totalSize total record size
     * @param pageSize page size
     * @return page count
     */
    public static int calcPage(int totalSize, int pageSize) {
        return calcPage((long) totalSize, pageSize);
    }

    /**
     * 根据总共记录数和每页的记录数，计算总共的页数
     * 
     * @param totalSize total record size
     * @param pageSize page size
     * @return page count
     */
    public static int calcPage(long totalSize, int pageSize) {
        return (int) Math.ceil(((double) totalSize) / pageSize);
    }

    /**
     * 将字符串里面的字符转换为整数，如果字符串不是整数，返回null
     * 
     * @param num number
     * @return integer value
     */
    public static Integer parseInt(String num) {
        try {
            Integer result = Integer.parseInt(num);
            return result;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * 将字符串里面的字符转换为整数，如果字符串不是整数，返回null
     * 
     * @param num number
     * @return Long value
     */
    public static Long parseLong(String num) {
        try {
            return Long.parseLong(num);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * 将0-9的数字前端补零
     * 
     * @param number number
     * @return formatted number
     */
    public static String addZeroPrefix(int number) {
        if (number >= 0 && number <= 9) {
            return ("0" + number);
        }
        return String.valueOf(number);
    }
    
    /**
     * 向上取整的方法
     * 
     * @param a:除数  b:被除数
     * @return 
     */
    public static int getInt(int a,int b) {
    	
    	if(b==0)
    		b=10;
    	return(((double)a/(double)b)>(a/b)?a/b+1:a/b);
		
    }

}
