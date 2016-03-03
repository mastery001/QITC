package com.mastery.common;

public class Constant {

	public static final String SESSION_KEY = "vrs.session";
	
	public static final String SINGLE_QUOTES = "'";
	public static final String NULL_STRING = "null";
	public static final String IMAGE_BAK = "_bak";
	public static final String IMAGE_TYPE_HD = "hd";
	public static final String IMAGE_TYPE_BG = "bg";
	// html单引号转译
	public static final String QUOTES_TRANSLATION = "&quot;";

	// 空格
	public static final String SPACE_STRING = " ";
	// 空串
	public static final String BLACK_STRING = "";
	// 数值正则表达式定义
	public static final String REGEX_VERITY_COMMA_NUM = "[0-9,]+";
	public static final String REGEX_VERITY_COMMA_LINE_NUM = "[0-9,-]+";
	public static final String REGEX_VERITY_LINE_NUM = "^\\d+(-\\d+)*$";
	public static final String REGEX_VERITY_NUM = "[0-9]+";
	// http前缀
	public static final String HTTP = "http";
	public final static String DEFAULT_DELIMITER = ",";
	public final static String DEFAULT_END = "\r\n";
	public static final String JSON_PREFIX = "pre";
	public static final String BLANK_STRING = "";
	public static final String SPLIT_STRING = ",";
	public static final String DOT_STRING = ".";
	public static final String SPLIT_SEMICOLON = ";";
	public static final String HORIZONTAL_STRING = "-";
	public static final String SEPARATE_UNDERLINE = "_";
	public static final String SEPARATE_VERTICAL = "|";
	public static final String SEPARATE_XIE = "/";
	public static final String SEPARATE_COLON = ":";
	public static final String LEFT_BRACE = "(";
	public static final String RIGHT_BRACE = ")";
	public static final String TIMES_SIGN = "[*]";
	public static final String BIG_BRACE = "{}";
	public static final String STAR = "\\*";
	public static final String UTF8 = "UTF-8";

	// 初始化数字
	public static final String ALL = "-1";
	public static final int ALL_NUM = -1;
	public static final int INIT_NUM = 0;
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int HOUR_SECONDNUM = 3600; // 一小时对应的秒数
	public static final int MIN_SECONDNUM = 60; // 一分钟对应的秒数
	public static final long NEW_VID_START = 2000 * 10000;// 新的vid，从2000万开始
	public final static int DAY_DEFAULT = 31;
}
