package com.mastery.webapp.controller.video;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mastery.webapp.controller.BaseController;
import com.mastery.webapp.service.IVideoInfoVoService;
import com.mastery.webapp.vo.VideoInfoVo;

@Controller
@RequestMapping("/video/*")
public class VideoController extends BaseController{


	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private IVideoInfoVoService service;
	
	@RequestMapping("/list")
	public String list(VideoInfoVo vo, ModelMap map) {
		List<VideoInfoVo> list = service.selectByModel(vo);
		map.put("list", list);
		setPage(vo, map);
		return "/video/list";
	}
	
}
