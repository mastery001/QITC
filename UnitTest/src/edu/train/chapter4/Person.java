package edu.train.chapter4;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7418542682616740746L;
	
	private String id;
	
	private String name;

	public Person() {
		super();
	}

	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ñ§ºÅ=" + id + ", ÐÕÃû=" + name;
	}
	
}
