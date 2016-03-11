package com.mastery.webapp.service.impl;

import com.mastery.data.base.IBaseDao;
import com.mastery.data.base.support.BaseOperateService;
import com.mastery.model.AlbumInfoModel;
import com.mastery.webapp.service.IAlbumInfoVoService;
import com.mastery.webapp.vo.AlbumInfoVo;

public class AlbumInfoVoServiceImpl extends BaseOperateService<AlbumInfoVo, AlbumInfoModel> implements IAlbumInfoVoService{

	@Override
	protected IBaseDao<AlbumInfoModel> getDao() {
		return null;
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
