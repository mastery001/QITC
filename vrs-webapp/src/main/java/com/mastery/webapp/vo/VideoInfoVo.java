package com.mastery.webapp.vo;

import com.mastery.data.base.BaseVo;

/**
 * 视频信息
 * @author zouziwen
 *
 * 2016年3月11日 下午3:10:33
 */
public class VideoInfoVo extends BaseVo{

	/**
	 * 2016年3月11日 下午3:02:57
	 */
	private static final long serialVersionUID = -6402897008920573710L;

	private Long pid;		//所属专辑id
	private String pname;	// 专辑名称
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
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
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
		return "VideoInfoVo [pid=" + pid + ", pname=" + pname + ", name=" + name + ", alias=" + alias + ", description="
				+ description + ", type=" + type + ", img=" + img + ", link=" + link + ", duration=" + duration
				+ ", isHeight=" + isHeight + "]";
	}

}
