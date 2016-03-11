package com.mastery.model;

import java.util.Date;

import com.mastery.data.base.BaseModel;

public class AlbumInfoModel extends BaseModel{

	/**
	 * 2016年3月11日 下午3:17:56
	 */
	private static final long serialVersionUID = -3525645239173283597L;

	private Long cid;		//频道id
	private String name;	//专辑名称
	private String subTitle;	//副标题
	private String tag;			//标签
	private String description;	//详细介绍
	private String shortDesc;	//简略介绍
	private Integer isEnd;		//是否完结（1 是完结 0 不是）
	private String img;			//专辑封面图片
	private String link;		//专辑链接
	private Date releaseDate;	//上映时间
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public Integer getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(Integer isEnd) {
		this.isEnd = isEnd;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "AlbumInfoModel [cid=" + cid + ", name=" + name + ", subTitle=" + subTitle + ", tag=" + tag
				+ ", description=" + description + ", shortDesc=" + shortDesc + ", isEnd=" + isEnd + ", img=" + img
				+ ", releaseDate=" + releaseDate + "]";
	}
	
	
}
