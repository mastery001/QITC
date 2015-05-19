package edu.jxau.po;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation("t_userthesis")
public class UserThesis{
	private String t_id; //论文编号;
	private String u_id; //用户编号;
	private Integer verify_status; //送审状态;
	private Integer verify_count; //送审次数;
	private Integer trial_status; //初审状态;
	private Integer reverify_status; //复审状态;
	private Integer reverify_count; //复审次数;

	@PrimaryKeyAnnotation(id="t_id")
	@ForeignKeyAnnotation("t_id")
	public String getT_id() {
		 return this.t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	@PrimaryKeyAnnotation(id="u_id")
	@ForeignKeyAnnotation("u_id")
	public String getU_id() {
		 return this.u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
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

	@Override
	public String toString() {
		return "UserThesis [t_id=" + t_id + ", u_id=" + u_id
				+ ", verify_status=" + verify_status + ", verify_count="
				+ verify_count + ", trial_status=" + trial_status
				+ ", reverify_status=" + reverify_status + ", reverify_count="
				+ reverify_count + "]";
	}

}