package com.mastery.webapp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mastery.dao.IVideoInfoDao;
import com.mastery.data.base.IBaseDao;
import com.mastery.data.base.support.BaseOperateService;
import com.mastery.model.VideoInfoModel;
import com.mastery.webapp.service.IVideoInfoVoService;
import com.mastery.webapp.vo.VideoInfoVo;
	
@Service("videoInfoVoServivce")
public class VideoInfoVoServiceImpl extends BaseOperateService<VideoInfoVo, VideoInfoModel> implements IVideoInfoVoService {

	@Resource
	private IVideoInfoDao videoInfoDao;
	
	@Override
	protected IBaseDao<VideoInfoModel> getDao() {
		return videoInfoDao;
	}

	@Override
	public Class<VideoInfoModel> getModelClass() {
		return VideoInfoModel.class;
	}

	@Override
	public Class<VideoInfoVo> getVoClass() {
		return VideoInfoVo.class;
	}

}
