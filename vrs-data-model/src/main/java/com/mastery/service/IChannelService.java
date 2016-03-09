package com.mastery.service;

import java.util.List;

import com.mastery.model.Channel;

/**
 * Channel的逻辑接口
 * @author zouziwen
 *
 * 2016年3月7日 下午6:08:40
 */
public interface IChannelService{

	/**
	 * 获取所有的频道
	 * @return
	 * 2016年3月7日 下午6:09:06
	 */
	List<Channel> getChannels();
	
}
