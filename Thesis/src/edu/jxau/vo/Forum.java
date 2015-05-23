package edu.jxau.vo;

public class Forum{
	private String u_id; //用户编号;
	private String u_name; //姓名;
	private String sex; //性别;
	private String c_id; //班级编号;
	private String c_name; //班级名称;
	private Integer a_id; //帖子编号;
	private String title; //标题;
	private String subject; //主题;
	private String content; //内容;
	private String image; //帖子头像;

	public String getU_id() {
		 return this.u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		 return this.u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getSex() {
		 return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getC_id() {
		 return this.c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		 return this.c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

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
		return "Forum [u_id=" + u_id + ", u_name=" + u_name + ", sex=" + sex
				+ ", c_id=" + c_id + ", c_name=" + c_name + ", a_id=" + a_id
				+ ", title=" + title + ", subject=" + subject + ", content="
				+ content + ", image=" + image + "]";
	}

}