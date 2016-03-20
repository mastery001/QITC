package com.mastery.webapp.service;

import java.util.Map;

import com.mastery.data.base.IBaseVagueSelector;
import com.mastery.data.base.IOperateService;
import com.mastery.webapp.vo.VideoInfoVo;

/**
 * 视频信息对应的逻辑
 * @author mastery
 * @time 2016年3月12日下午8:02:18
 */
public interface IVideoInfoVoService extends IOperateService<VideoInfoVo>, IBaseVagueSelector<VideoInfoVo>{

	/**
	 * 获得对应视频类型的个数
	 * @return
	 * 2016年3月18日 下午4:18:23
	 */
	public Map<Integer , String> getVideoCount();
	
}
