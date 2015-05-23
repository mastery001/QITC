package edu.jxau.vo;


public class UserInfo{
	private String u_id; //用户编号;
	private String u_name; //姓名;
	private String teacher; //老师;
	private String c_id; //班级编号;
	private Integer status; //用户身份;
	private String c_name; //班级名称;
	private String statusName;	//身份名称

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

	public String getTeacher() {
		 return this.teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getC_id() {
		 return this.c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public Integer getStatus() {
		 return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
		if(status == null) {
			statusName = null;
		}else if(status == 0) {
			statusName = "学生";
		}else if(status == 1) {
			statusName = "老师";
		}else {
			statusName = "专家";
		}
		System.out.println("statusName is " + statusName);
	}

	public String getC_name() {
		 return this.c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "UserInfo [u_id=" + u_id + ", u_name=" + u_name + ", teacher="
				+ teacher + ", c_id=" + c_id + ", status=" + status
				+ ", c_name=" + c_name + "]";
	}

}