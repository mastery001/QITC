package com.mastery.webapp.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mastery.common.Constant;
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
	
	private final Map<Integer, VideoCount> videoCount = new TreeMap<Integer, VideoCount>();
	
	public VideoInfoVoServiceImpl() {
		
	}
	
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

	@Override
	public void insert(VideoInfoVo t) {
		super.insert(t);
		videoCount.put(t.getType(), videoCount.get(t.getType()).countIncrement());
	}

	
	
	@Override
	public void update(VideoInfoVo t) {
		VideoInfoModel oldModel = getDao().selectById(t.getId());
		super.update(t);
		if(t.getType() != null) {
			videoCount.put(t.getType(), videoCount.get(t.getType()).countIncrement());
			videoCount.put(oldModel.getType(), videoCount.get(oldModel.getType()).countDecrement());
		}
	}

	@Override
	public void delete(VideoInfoVo t) {
		super.delete(t);
		videoCount.put(t.getType(), videoCount.get(t.getType()).countDecrement());
	}

	@Override
	public List<VideoInfoVo> selectByModel(VideoInfoVo t) {
		List<VideoInfoVo> list = super.selectByModel(t);
		if(videoCount.isEmpty()) {
			
			for(Iterator<Integer> it = Constant.VIDEO_TYPE.keySet().iterator() ; it.hasNext();) {
				Integer type = it.next();
				String video_type = Constant.VIDEO_TYPE.get(type);
				VideoCount v = null;
				if(type == 1) {
					v = new VideoCount(video_type, list.size());
				}else {
					VideoInfoModel model = new VideoInfoModel();
					model.setType(type);
					v = new VideoCount(video_type , getDao().selectByModelCount(model));
				}
				videoCount.put(type,v);
			}
			build();
		}
		return list;
	}

	@Override
	public Map<Integer, String> getVideoCount() {
		return videoCountStr;
	}

	private class VideoCount {
		
		/**
		 * 对应的类型的个数
		 * 2016年3月18日 下午4:22:06
		 */
		int count;
		
		String video_tye;
		
		VideoCount(String video_tye , int count) {
			this.video_tye = video_tye;
			this.count = count;
		}
		
		public VideoCount countIncrement() {
			this.count ++;
			build();
			return this;
		}
		
		public VideoCount countDecrement() {
			this.count--;
			build();
			return this;
		}
	}
	

	private void build() {
		for(Iterator<Integer> it = videoCount.keySet().iterator() ; it.hasNext();) {
			Integer type = it.next();
			VideoCount obj = videoCount.get(type);
			videoCountStr.put(type, obj.video_tye + obj.count);
		}
	}
	
	private final Map<Integer, String> videoCountStr = new TreeMap<Integer, String>();
}
