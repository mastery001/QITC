package com.mastery.webapp.vo;

import com.mastery.data.base.BaseVo;

public class ChannelVo extends BaseVo{

	/**
	 * 2016年3月8日 下午2:19:44
	 */
	private static final long serialVersionUID = 2351820372531163367L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ChannelVo [name=" + name + "]" + super.toString();
	}
	
}
