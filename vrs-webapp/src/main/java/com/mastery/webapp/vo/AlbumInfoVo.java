package com.mastery.webapp.vo;

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
	private Long cid;		//频道id
	private String cname;	// 频道名称
	private String name;	//专辑名称
	private String subTitle;	//副标题
	private String tag;			//标签
	private String description;	//详细介绍
	private String shortDesc;	//简略介绍
	private Integer isEnd;		//是否完结（1 是完结 0 不是）
	private String img;			//专辑封面图片
	private String link;		//专辑链接
	private String releaseDate;	//上映时间
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "AlbumInfoVo [cid=" + cid + ", cname=" + cname + ", name=" + name + ", subTitle=" + subTitle + ", tag="
				+ tag + ", description=" + description + ", shortDesc=" + shortDesc + ", isEnd=" + isEnd + ", img="
				+ img + ", link=" + link + ", releaseDate=" + releaseDate + "]";
	}

}
