package com.mastery.webapp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mastery.dao.IChannelDao;
import com.mastery.data.base.IBaseDao;
import com.mastery.data.base.support.BaseOperateService;
import com.mastery.model.Channel;
import com.mastery.webapp.service.IChannelVoService;
import com.mastery.webapp.vo.ChannelVo;

@Service("channelVoService")
public class ChannelVoServiceImpl extends BaseOperateService<ChannelVo, Channel> implements IChannelVoService {

	@Resource
	private IChannelDao channelDao;

	@Override
	public IBaseDao<Channel> getDao() {
		return channelDao;
	}

	@Override
	public Class<Channel> getModelClass() {
		return Channel.class;
	}

	@Override
	public Class<ChannelVo> getVoClass() {
		return ChannelVo.class;
	}

}
