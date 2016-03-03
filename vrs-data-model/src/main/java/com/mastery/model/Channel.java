package com.mastery.model;

import java.io.Serializable;


/**
 * 频道类
 * @author zouziwen
 *
 */
public class Channel implements Serializable
{
	/**
	 * 2016年3月3日 下午5:12:17
	 */
	private static final long serialVersionUID = 5336382453368052372L;
	private int id = -1;
    private String name;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	private String desc;
    private String dir;
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Channel other = (Channel) obj;
		if (id != other.id)
			return false;
		return true;
	}
    
}
