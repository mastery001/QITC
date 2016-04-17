package com.mastery.model;

import com.mastery.data.base.BaseModel;

public class User extends BaseModel{

	/**
	 * 2016年3月3日 下午5:24:10
	 */
	private static final long serialVersionUID = -8925565581574009230L;

	private String username = null;

	private String fullname = null;

	private String password = null;
	
	public User() {
		setTableName("con_user");
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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
        if (getId() < 0) return false;
        if (!(obj instanceof User)) return false;
        return (((User) obj).getId() == getId());
    }

	@Override
	public String toString() {
		return "User [username=" + username + ", fullname=" + fullname + ", password=" + password + "]";
	}

}
