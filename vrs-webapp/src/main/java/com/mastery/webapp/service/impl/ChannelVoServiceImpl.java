package com.mastery.webapp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mastery.model.Channel;
import com.mastery.service.IChannelService;
import com.mastery.webapp.service.IChannelVoService;
import com.mastery.webapp.vo.ChannelVo;

@Service("channelVoService")
public class ChannelVoServiceImpl implements IChannelVoService {

	@Resource
	private IChannelService channelService;

	@Override
	public void insert(ChannelVo t) {
		channelService.insert(channelService.convert(t, channelService.getEntityClass()));
	}

	@Override
	public void update(ChannelVo t) {
		channelService.updateBySelective(channelService.convert(t, channelService.getEntityClass()));
	}

	@Override
	public void delete(ChannelVo t) {
		channelService.delete(channelService.convert(t, channelService.getEntityClass()));
	}

	@Override
	public ChannelVo selectById(Long id) {
		if (id != null) {
			Channel channel = channelService.selectById(id);
			return channelService.convert(channel, getEntityClass());
		}
		return null;
	}

	@Override
	public List<ChannelVo> selectByModel(ChannelVo t) {
		return channelService.convert(
				channelService.selectByModel(channelService.convert(t, channelService.getEntityClass())),
				getEntityClass());
	}

	@Override
	public Class<ChannelVo> getEntityClass() {
		return ChannelVo.class;
	}

}
