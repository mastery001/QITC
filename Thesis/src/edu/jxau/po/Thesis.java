package edu.jxau.po;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation("t_thesis")
public class Thesis{
	private String t_id; //论文编号;
	private String t_name; //论文名称;
	private String t_front; //论文封面;
	private Integer isdelete; //是否删除;

	@PrimaryKeyAnnotation(id="t_id")
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

	public Integer getIsdelete() {
		 return this.isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	@Override
	public String toString() {
		return "Thesis [t_id=" + t_id + ", t_name=" + t_name + ", t_front="
				+ t_front + ", isdelete=" + isdelete + "]";
	}

}