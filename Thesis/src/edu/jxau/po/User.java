package edu.jxau.po;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation("t_user")
public class User{
	private String u_id; //用户编号;
	private String u_name; //姓名;
	private String sex; //性别;
	private String password; //密码;
	private String email; //邮箱;
	private String phone; //用户电话;
	private String teacher; //老师;
	private String entrance_date; //入学年份
	private Integer status; //用户身份;
	private String pspb1; //密保问题;
	private String pspb2; //密保问题;
	private String pspb3; //密保问题;
	private String answer1; //答案一;
	private String answer2; //答案二;
	private String answer3; //答案三;
	
	@PrimaryKeyAnnotation(id="u_id")
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

	public String getPassword() {
		 return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		 return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		 return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTeacher() {
		 return this.teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getEntrance_date() {
		return entrance_date;
	}

	public void setEntrance_data(String entrance_date) {
		this.entrance_date = entrance_date;
	}

	public Integer getStatus() {
		 return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPspb3() {
		return pspb3;
	}

	public void setPspb3(String pspb3) {
		this.pspb3 = pspb3;
	}

	public String getPspb1() {
		return pspb1;
	}

	public void setPspb1(String pspb1) {
		this.pspb1 = pspb1;
	}

	public String getPspb2() {
		return pspb2;
	}

	public void setPspb2(String pspb2) {
		this.pspb2 = pspb2;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", sex=" + sex
				+ ", password=" + password + ", email=" + email + ", phone="
				+ phone + ", teacher=" + teacher + ", entrance_data="
				+ entrance_date  + ", status=" + status
				+ ", pspb1=" + pspb1 + ", pspb2=" + pspb2 + ", pspb3=" + pspb3
				+ ", answer1=" + answer1 + ", answer2=" + answer2
				+ ", answer3=" + answer3 + "]";
	}

}