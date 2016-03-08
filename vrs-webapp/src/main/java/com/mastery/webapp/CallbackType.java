package com.mastery.webapp;
/*
 * @Title: CallbackType.java
 * @Package 
 * @Description: TODO
 * @author xufei1 <xufei1@letv.com>
 * @date 2013-1-21 下午5:44:59
 * @version V1.0
 *
 * Modification History:  
 * Date         Author      Version     Description  
 * -------------------------------------------------------------- 
 * 2013-1-21                          
 */

/** 
 * <p>ajax返回类型</p>
 * 
 * @author xufei1 <xufei1@letv.com>
 * Create at:2013-1-21 下午5:44:59
 */
public enum CallbackType {
	/** 关闭当前页面 */
	CLOSE_CURRENT("closeCurrent"),
	/** 转发 并更新标题 */
	REDIRECT("redirect"),
	/** 转发 */
	FORWARD("forward");

	private String value;

	private CallbackType(String value) {
		this.value = (String)value;
	}
	public String getValue() {
		 return value;
	}
}
