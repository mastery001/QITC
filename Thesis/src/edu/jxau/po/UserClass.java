package edu.jxau.po;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation("t_userclass")
public class UserClass {
	private String u_id;
	private String c_id;
	
	@PrimaryKeyAnnotation(id="u_id")
	@ForeignKeyAnnotation("u_id")
	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	@PrimaryKeyAnnotation(id="c_id")
	@ForeignKeyAnnotation("c_id")
	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	@Override
	public String toString() {
		return "UserClass [u_id=" + u_id + ", c_id=" + c_id + "]";
	}
	
	
}
