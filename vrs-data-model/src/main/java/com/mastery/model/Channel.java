package com.mastery.model;

import java.io.Serializable;


/**
 * 频道类
 * @author zouziwen
 *
 */
public class Channel extends BaseModel  implements Serializable{
	/**
	 * 2016年3月3日 下午5:12:17
	 */
	private static final long serialVersionUID = 5336382453368052372L;
    private String name;
    
	public Channel() {
		this.setTableName("con_channel");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "Channel [name=" + name + "]";
	}
    
}
