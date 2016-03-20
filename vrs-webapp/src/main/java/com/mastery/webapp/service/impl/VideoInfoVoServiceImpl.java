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
		videoCount.put(Constant.ONE, videoCount.get(Constant.ONE).countIncrement());
		build();
	}

	
	@Override
	public void update(VideoInfoVo t) {
		VideoInfoModel oldModel = null;
		if(t.getId() != null) {
			oldModel = getDao().selectById(t.getId());
		}
		super.update(t);
		
		if(oldModel != null && t.getType() != null) {
			if(!t.getType().equals(oldModel.getType())) {
				videoCount.put(t.getType(), videoCount.get(t.getType()).countIncrement());
				videoCount.put(oldModel.getType(), videoCount.get(oldModel.getType()).countDecrement());
				build();
			}
		}
	}

	@Override
	public void delete(VideoInfoVo t) {
		super.delete(t);
		videoCount.put(t.getType(), videoCount.get(t.getType()).countDecrement());
		videoCount.put(Constant.ONE, videoCount.get(Constant.ONE).countDecrement());
		build();
	}

	@Override
	public List<VideoInfoVo> selectByModel(VideoInfoVo t) {
		List<VideoInfoVo> list = super.selectByModel(t);
		int all = list == null ? 0 : list.size();
		// 初始化
		if(videoCount.isEmpty()) {
			for(Iterator<Integer> it = Constant.VIDEO_TYPE.keySet().iterator() ; it.hasNext();) {
				Integer type = it.next();
				videoCount.put(type, new VideoCount(Constant.VIDEO_TYPE.get(type), 0));
			}
		}
		if(!isBuild && all !=0) {
			
			for(Iterator<Integer> it = Constant.VIDEO_TYPE.keySet().iterator() ; it.hasNext();) {
				Integer type = it.next();
				if(type == 1) {
					videoCount.get(type).setCount(all);
				}else {
					VideoInfoModel model = new VideoInfoModel();
					model.setType(type);
					videoCount.get(type).setCount(getDao().selectByModelCount(model));
				}
			}
		}
		build();
		return list;
	}

	@Override
	public List<VideoInfoVo> selectVagueByModel(VideoInfoVo t) {
		List<VideoInfoVo> list = super.selectVagueByModel(t);
		int all = list == null ? 0 : list.size();
		for(Iterator<Integer> it = videoCount.keySet().iterator() ; it.hasNext();) {
			videoCount.get(it.next()).setCount(0);
		}
		if(all !=0 ) {
			for(VideoInfoVo vo : list) {
				videoCount.get(vo.getType()).countIncrement();
			}
			videoCount.get(Constant.ONE).setCount(all);
		}
		build();
		isBuild = false;
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
			return this;
		}
		
		public VideoCount countDecrement() {
			this.count--;
			return this;
		}
		
		public VideoCount setCount(int count ) {
			this.count = count;
			return this;
		}
	}
	

	private void build() {
		for(Iterator<Integer> it = videoCount.keySet().iterator() ; it.hasNext();) {
			Integer type = it.next();
			VideoCount obj = videoCount.get(type);
			videoCountStr.put(type, obj.video_tye + obj.count);
		}
		isBuild = true;
	}
	
	private boolean isBuild = false;
	
	private final Map<Integer, String> videoCountStr = new TreeMap<Integer, String>();
}
