package edu.jxau.po;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation("t_article")
public class Article{
	private Integer a_id; //帖子编号;
	private String title; //标题;
	private String subject; //主题;
	private String content; //内容;
	private String image; //帖子头像;

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

	@Override
	public String toString() {
		return "Article [a_id=" + a_id + ", title=" + title + ", subject="
				+ subject + ", content=" + content + ", image=" + image + "]";
	}

}