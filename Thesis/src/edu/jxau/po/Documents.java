package edu.jxau.po;

import java.util.Date;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;


@TableAnnotation("t_docs")
public class Documents {
	
	private Integer id;
	
	private String d_name;
	
	private String document;
	
	private Date up_time;

	public Documents() {
		up_time = new Date();
	}
	
	@PrimaryKeyAnnotation(id="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Date getUp_time() {
		return up_time;
	}

	public void setUp_time(Date up_time) {
		this.up_time = up_time;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	@Override
	public String toString() {
		return "Documents [id=" + id + ", d_name=" + d_name + ", document="
				+ document + ", up_time=" + up_time + "]";
	}
	
	
}
