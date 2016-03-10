package com.mastery.webapp.vo;

import java.util.Date;

import com.mastery.data.base.BaseVo;

/**
 * 专辑信息vo
 * @author zouziwen
 *
 * 2016年3月10日 下午5:20:39
 */
public class AlbumInfoVo extends BaseVo{
	
	/**
	 * 2016年3月10日 下午5:20:26
	 */
	private static final long serialVersionUID = 4908588636579941704L;
	private Long cid;
	private String cname;	// 频道名称
	private String name;
	private String subTitle;
	private String tag;
	private String description;
	private String shortDesc;
	private Integer isEnd;
	private String img;
	private Date releaseDate;
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
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
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
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "AlbumInfoVo [cid=" + cid + ", cname=" + cname + ", name=" + name + ", subTitle=" + subTitle + ", tag="
				+ tag + ", description=" + description + ", shortDesc=" + shortDesc + ", isEnd=" + isEnd + ", img="
				+ img + ", releaseDate=" + releaseDate + "]";
	}
	
}
