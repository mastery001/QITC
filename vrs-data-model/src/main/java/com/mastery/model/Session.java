package com.mastery.model;

import java.util.ArrayList;
import java.util.List;

/**
 * HttpSession中存取的属性
 * @author zouziwen
 *
 * 2016年3月3日 下午5:40:57
 */
public class Session {
	
	private User user;
	
	private List<Channel> channelList = new ArrayList<Channel>();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Channel> getChannelList() {
		return channelList;
	}

	public void setChannelList(List<Channel> channelList) {
		this.channelList = channelList;
	}
	
	
}
