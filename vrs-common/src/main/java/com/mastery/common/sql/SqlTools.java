package com.mastery.common.sql;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * sql字符串处理
 * 
 */
public class SqlTools {

    /**
     * 将一个数值数组转化成用逗号分隔的字符串
     * 
     * @param sb
     * @param values
     */
    public static <T> void appendArraySplitByComma(StringBuilder sb, T[] values) {
        int length = values.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(SqlConstant.COMMA);
            }
            sb.append(values[i]);
        }
    }
    
    /**
     * 根据传入的对象，得到该对象在sql中应该拼接sql片单
     *
     * @author zhumingyuan
     * @date 2015年2月28日 下午4:13:22 
     * @param object
     * @return
     */
    public static <T> String getDBStringValue(T object) {
        // 数值型直接返回
        if (object instanceof Number) {
            return object.toString();
        } else if (object instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat(SqlConstant.SIMPLE_DATE_FORMAT);
            return SqlConstant.SINGLE_QUOTES + sdf.format(object) + SqlConstant.SINGLE_QUOTES;
        } else if (object instanceof Boolean) {
            return object.toString();
        } else { // 其他拼接为'XXXXX'
            return SqlConstant.SINGLE_QUOTES + String.valueOf(object) + SqlConstant.SINGLE_QUOTES;
        }
    }

}
