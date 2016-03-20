package com.mastery.webapp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mastery.dao.IAlbumInfoDao;
import com.mastery.data.base.IBaseDao;
import com.mastery.data.base.support.BaseOperateService;
import com.mastery.model.AlbumInfoModel;
import com.mastery.webapp.service.IAlbumInfoVoService;
import com.mastery.webapp.vo.AlbumInfoVo;

@Service("albumInfoVoServivce")
public class AlbumInfoVoServiceImpl extends BaseOperateService<AlbumInfoVo, AlbumInfoModel> implements IAlbumInfoVoService{

	@Resource
	private IAlbumInfoDao albumInfoDao;
	
	@Override
	protected IBaseDao<AlbumInfoModel> getDao() {
		return albumInfoDao;
	}

	@Override
	public Class<AlbumInfoModel> getModelClass() {
		return AlbumInfoModel.class;
	}

	@Override
	public Class<AlbumInfoVo> getVoClass() {
		return AlbumInfoVo.class;
	}
	
}
