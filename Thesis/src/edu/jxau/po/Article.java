package edu.jxau.po;

import java.util.Date;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation("t_article")
public class Article{
	private Integer a_id; //帖子编号;
	private String title; //标题;
	private String subject; //主题;
	private String content; //内容;
	private Date time;	//时间
	private String image; //帖子头像;
	private Integer p_id;	// 主题帖id
	private Integer isleaf;	// 是否是叶子节点
	
	@PrimaryKeyAnnotation(id="a_id")
	public Integer getA_id() {
		 return this.a_id;
	}

	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}

	public String getTitle() {
		 return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		 return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		 return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		 return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(Integer isleaf) {
		this.isleaf = isleaf;
	}
	
	@Override
	public String toString() {
		return "Article [a_id=" + a_id + ", title=" + title + ", subject="
				+ subject + ", content=" + content + ", time=" + time
				+ ", image=" + image + ", p_id=" + p_id + ", isleaf=" + isleaf
				+ "]";
	}

}