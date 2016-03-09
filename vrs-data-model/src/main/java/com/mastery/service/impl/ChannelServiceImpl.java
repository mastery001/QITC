package com.mastery.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mastery.dao.IChannelDao;
import com.mastery.model.Channel;
import com.mastery.service.IChannelService;

@Service("channelService")
public class ChannelServiceImpl implements IChannelService {

	@Resource
	private IChannelDao channelDao;
	
	@Override
	public List<Channel> getChannels() {
		return channelDao.selectByModel(null);
	}


}
