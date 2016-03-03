package com.mastery.webapp.controller.result;

import java.io.Serializable;

/**
 * 用于返回DWZ固定格式的json对象
 * 
 * @author zouziwen
 *
 *         2016年3月3日 下午4:39:23
 */
public class DwzResultObject implements Serializable {

	// dwz返回的状态码， 200代表成功
	public static final int DWZ_STATUS_CODE_SUCC = 200;
	// dwz返回的状态码， 300代表失败
	public static final int DWZ_STATUS_CODE_FAIL = 300;
//	// dwz 批量视频添加到专辑后返回专辑修改页面标示
//	public static final int DWZ_RETURN_ALBUMEDIT_FLAG = 1;
//	// dwz 批量视频添加到专辑后返回视频列表页面标示
//	public static final int DWZ_RETURN__VIDEOLIST_FLAG = 2;
//	// dwz 专辑视频管理视频维护保存后返回专辑视频管理页面标志
//	public static final int DWZ_RETURN_ALBUM_VIDEOLIST_FLAG = 3;

	private static final long serialVersionUID = 2110197716979093045L;

	private Integer statusCode = 200;// 返回状态吗
	private String message;// 返回信息
	private String navTabId = "";// 跳转tabId
	private String rel = "";
	private String callbackType = "";// 调用类型
	private Object data;// 返回数据
	private String forwardUrl = "";// 跳转url
	private String forwardTitle = "";// 跳转页面标题
	private String queryString;

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNavTabId() {
		return navTabId;
	}

	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	public String getForwardTitle() {
		return forwardTitle;
	}

	public void setForwardTitle(String forwardTitle) {
		this.forwardTitle = forwardTitle;
	}

}
