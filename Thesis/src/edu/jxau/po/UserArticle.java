package edu.jxau.po;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation("t_userarticle")
public class UserArticle{
	private Integer a_id; //帖子编号;
	private String u_id; //标题;

	@PrimaryKeyAnnotation(id="a_id")
	@ForeignKeyAnnotation("a_id")
	public Integer getA_id() {
		 return this.a_id;
	}

	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}
	@PrimaryKeyAnnotation(id="u_id")
	@ForeignKeyAnnotation("u_id")
	public String getU_id() {
		 return this.u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	@Override
	public String toString() {
		return "UserArticle [a_id=" + a_id + ", u_id=" + u_id + "]";
	}

}