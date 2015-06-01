package edu.jxau.vo;

public class Thesises{
	private String u_id; //用户编号;
	private String u_name; //姓名;
	private String c_id; //班级编号;
	private String c_name; //班级名称;
	private String major; //班级方向;
	private String t_id; //论文编号;
	private String t_name; //论文名称;
	private String t_front; //论文封面;
	private String document;   // 论文
	private String description; // 论文描述
	private Integer verify_status = 0 ; //送审状态;
	private Integer verify_count = 0 ; //送审次数;
	private Integer trial_status = 0 ; //初审状态;
	private Integer reverify_status = 0 ; //复审状态;
	private Integer reverify_count = 0 ; //复审次数;
	private Integer isdelete  = 0 ; //是否删除;

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

	public String getMajor() {
		 return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getT_id() {
		 return this.t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		 return this.t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_front() {
		 return this.t_front;
	}

	public void setT_front(String t_front) {
		this.t_front = t_front;
	}

	public Integer getVerify_status() {
		 return this.verify_status;
	}

	public void setVerify_status(Integer verify_status) {
		this.verify_status = verify_status;
	}

	public Integer getVerify_count() {
		 return this.verify_count;
	}

	public void setVerify_count(Integer verify_count) {
		this.verify_count = verify_count;
	}

	public Integer getTrial_status() {
		 return this.trial_status;
	}

	public void setTrial_status(Integer trial_status) {
		this.trial_status = trial_status;
	}

	public Integer getReverify_status() {
		 return this.reverify_status;
	}

	public void setReverify_status(Integer reverify_status) {
		this.reverify_status = reverify_status;
	}

	public Integer getReverify_count() {
		 return this.reverify_count;
	}

	public void setReverify_count(Integer reverify_count) {
		this.reverify_count = reverify_count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return "Thesises [u_id=" + u_id + ", u_name=" + u_name + ", c_id="
				+ c_id + ", c_name=" + c_name + ", major=" + major + ", t_id="
				+ t_id + ", t_name=" + t_name + ", t_front=" + t_front
				+ ", document=" + document + ", description=" + description
				+ ", verify_status=" + verify_status + ", verify_count="
				+ verify_count + ", trial_status=" + trial_status
				+ ", reverify_status=" + reverify_status + ", reverify_count="
				+ reverify_count + ", isdelete=" + isdelete + "]";
	}

}