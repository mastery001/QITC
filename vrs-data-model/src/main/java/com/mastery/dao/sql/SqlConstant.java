/**
 * 
 */
package com.mastery.dao.sql;

/**
 * sql语句拼接使用的 常量
 * @author zouziwen
 *
 */
public final class SqlConstant {

    public final static String EQUAL = " = ";
    public final static String NOT_EQUAL = " <> ";
    public final static String GREATER = " > ";
    public final static String LESS = " < ";
    public final static String IS_NULL = " is null ";
    public final static String IS_NOT_NULL = " is not null ";
    public final static String IN = " in ";
    public final static String LIKE = " like ";
    public final static String NOT_LIKE = " not like ";
    public final static String BETWEEN = " between ";
    public final static String AND = " and ";
    public final static String OR = " or ";
    public final static String ASC = " asc ";
    public final static String DESC = " desc ";
    public final static String SINGLE_QUOTES = "'";
    public final static String PERCENT = "%";
    public final static String COMMA = ",";
    public final static String LEFT_BRACKET = " (";
    public final static String RIGHT_BRACKET = ") ";
    public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String COUNT = " count(*) ";
    public static final String DISTINCT = "distinct";
    public static final String ALL_COLUMN = " * ";
    public static final String SET = " set ";
}
