package com.mastery.data.base;

import java.io.Serializable;

import com.mastery.dao.ISoftDelete;

public class BaseModel implements ISoftDelete,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5822755615614280336L;
	
	private Long id;
	
	private Boolean deleted=false;
	// 分页时开始记录
	private Integer baseStart ;
	// 分页时每页记录数
	private Integer baseSize ;
	private Integer orderBy; // 0升序 1降序
	private String userId;//   
	private String updateUid;//   
	private java.util.Date createTime; // 开始时间
	private java.util.Date updateTime; // 更新时间
	
	// model对应的表，有默认实现，如果要特殊处理请 override getTable方法
	private String tableName;
	

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBaseStart() {
		return baseStart;
	}

	public void setBaseStart(Integer baseStart) {
		this.baseStart = baseStart;
	}

	public Integer getBaseSize() {
		return baseSize;
	}

	public void setBaseSize(Integer baseSize) {
		this.baseSize = baseSize;
	}
	

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
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

	/**
	 * 默认方法，对象名去掉model,每个大写字母断开用下划线区分
	 *
	 * @author zouziwen
	 * @date Mar 16, 2015 5:24:47 PM 
	 * @return
	 */
    public String getTableName() {
        if (tableName != null && tableName.length() > 0) {
            return tableName;
        } else {
            String className = this.getClass().getSimpleName();
            // 阶段到model前面
            String subClassName = className.substring(0, className.length() - 5);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < subClassName.length(); i++) {
                char c = subClassName.charAt(i);
                // 大写断开
                if (Character.isUpperCase(c)) {
                    if (i != 0) {
                        // 表分隔符
                        sb.append("_");
                    }
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

	@Override
	public Boolean getDeleted() {
		return deleted;
	}

	@Override
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "BaseModel [id=" + id + ", deleted=" + deleted + ", baseStart=" + baseStart + ", baseSize=" + baseSize
				+ ", orderBy=" + orderBy + ", userId=" + userId + ", updateUid=" + updateUid + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", tableName=" + tableName + "]";
	}
	
}
