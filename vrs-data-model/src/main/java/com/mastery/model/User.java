package com.mastery.model;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 2016年3月3日 下午5:24:10
	 */
	private static final long serialVersionUID = -8925565581574009230L;

	private int id = -1;
	private String username = null;

	private String fullName = null;

	private String password;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.id < 0) return false;
        if (!(obj instanceof User)) return false;
        return (((User) obj).getId() == this.id);
    }

}
