package com.mastery.data.base;

import java.io.Serializable;

import com.mastery.common.PagingUtil.PagingVO;

public class BaseVo implements Serializable {
	private static final long serialVersionUID = 7398677465236916009L;
	private int pageNum = 1; // 当前页
	private int numPerPage = 30;// 页面数据数量
	private Long id;
	private Boolean deleted = false;
	private String createTimeStr;// 创建时间
	private String updateTimeStr;// 修改时间
	private String userId;// 创建人
	private String updateUid;// 修改人
	private PagingVO pageVo;

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUpdateUid() {
		return updateUid;
	}

	public void setUpdateUid(String updateUid) {
		this.updateUid = updateUid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public PagingVO getPageVo() {
		return pageVo;
	}

	public void setPageVo(PagingVO pageVo) {
		this.pageVo = pageVo;
	}

	@Override
	public String toString() {
		return "BaseVo [pageNum=" + pageNum + ", numPerPage=" + numPerPage + ", id=" + id + ", deleted=" + deleted
				+ ", createTimeStr=" + createTimeStr + ", updateTimeStr=" + updateTimeStr + ", userId=" + userId
				+ ", updateUid=" + updateUid + ", pageVo=" + pageVo + "]";
	}
	
}
