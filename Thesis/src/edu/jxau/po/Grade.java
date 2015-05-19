package edu.jxau.po;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation("t_class")
public class Grade{
	private String c_id; //班级编号;
	private String c_name; //班级名称;
	private String major;	//班级方向

	@PrimaryKeyAnnotation(id="c_id")
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
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Grade [c_id=" + c_id + ", c_name=" + c_name + ", major="
				+ major + "]";
	}

}