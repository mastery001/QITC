package com.mastery.model;

import com.mastery.data.base.BaseModel;

public class VideoInfoModel extends BaseModel{

	/**
	 * 2016年3月11日 下午3:18:46
	 */
	private static final long serialVersionUID = 616515641941847713L;

	private Long pid;		//所属专辑id
	private String name;	//视频名称
	private String alias;	//别名
	private String description;	//描述
	private Integer type;		//视频类型
	private String img;			//视频封面图片
	private String link;		//视频链接
	private Integer duration;	//时长
	private Integer isHeight;	//是否高清（1 是高清 0 不是）
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getIsHeight() {
		return isHeight;
	}
	public void setIsHeight(Integer isHeight) {
		this.isHeight = isHeight;
	}
	@Override
	public String toString() {
		return "VideoInfoModel [pid=" + pid + ", name=" + name + ", alias=" + alias + ", description=" + description
				+ ", type=" + type + ", img=" + img + ", duration=" + duration + ", isHeight=" + isHeight + "]";
	}
	
}
