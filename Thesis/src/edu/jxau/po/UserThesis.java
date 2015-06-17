package edu.jxau.po;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation("t_userthesis")
public class UserThesis{
	private String t_id; //论文编号;
	private String u_id; //用户编号;
	private Integer commit_status; //送审状态;
	private Integer verify_status; //评审状态;
	private Integer verify_count; //送审次数;
	private String comment;	// 教师评语

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


	public Integer getCommit_status() {
		return commit_status;
	}

	public void setCommit_status(Integer commit_status) {
		this.commit_status = commit_status;
	}

	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "UserThesis [t_id=" + t_id + ", u_id=" + u_id
				+ ", commit_status=" + commit_status + ", verify_status="
				+ verify_status + ", verify_count=" + verify_count
				+ ", comment=" + comment + "]";
	}

}