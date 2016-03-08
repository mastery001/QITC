package com.mastery.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mastery.dao.IChannelDao;
import com.mastery.data.base.IBaseDao;
import com.mastery.model.Channel;
import com.mastery.service.AbstractBaseService;
import com.mastery.service.IChannelService;

@Service("channelService")
public class ChannelServiceImpl extends AbstractBaseService<Channel> implements IChannelService {

	public ChannelServiceImpl() {
		super(Channel.class);
	}

	@Resource
	private IChannelDao channelDao;
	
	@Override
	public List<Channel> getChannels() {
		return this.selectByModel(null);
	}

	@Override
	public IBaseDao<Channel> getDao() {
		return channelDao;
	}

}
