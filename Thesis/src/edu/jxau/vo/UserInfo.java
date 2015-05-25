package edu.jxau.vo;

import edu.jxau.dao.UserDao;
import edu.jxau.po.User;


public class UserInfo{
	private String u_id; //用户编号;
	private String u_name; //姓名;
	private String teacher; //老师;
	private String c_id; //班级编号;
	private Integer status; //用户身份;
	private String c_name; //班级名称;
	private String statusName;	//身份名称
	private String teacher_name; // 老师姓名
	private String entrance_date; //入学年份
	private String phone; //用户电话;
	private String sex;	// 用户性别

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
		User user = new UserDao().getUser(teacher);
		if(user != null) {
			this.teacher_name = user.getU_name();
		}
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
		if(status == null || status == 0) {
			statusName = "学生";
		}else if(status == 1) {
			statusName = "老师";
		}else {
			statusName = "专家";
		}
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

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getEntrance_date() {
		return entrance_date;
	}

	public void setEntrance_date(String entrance_date) {
		this.entrance_date = entrance_date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "UserInfo [u_id=" + u_id + ", u_name=" + u_name + ", teacher="
				+ teacher + ", c_id=" + c_id + ", status=" + status
				+ ", c_name=" + c_name + ", statusName=" + statusName
				+ ", teacher_name=" + teacher_name + ", entrance_date="
				+ entrance_date + ", phone=" + phone + ", sex=" + sex + "]";
	}


}