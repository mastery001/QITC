package com.mastery.webapp.controller.video;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mastery.common.Constant;
import com.mastery.common.exception.BusinessException;
import com.mastery.webapp.CallbackType;
import com.mastery.webapp.SessionUtils;
import com.mastery.webapp.UploadComponent;
import com.mastery.webapp.controller.BaseController;
import com.mastery.webapp.controller.result.DwzResultObject;
import com.mastery.webapp.service.IVideoInfoVoService;
import com.mastery.webapp.util.WebappUtil;
import com.mastery.webapp.vo.VideoInfoVo;

@Controller
@RequestMapping("/video/*")
public class VideoController extends BaseController{


	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private IVideoInfoVoService service;
	
	@Resource
	private UploadComponent upload;
	
	@RequestMapping("/list")
	public String list(VideoInfoVo vo, ModelMap map) {
		List<VideoInfoVo> list = service.selectByModel(vo);
		map.put("list", list);
		map.put("videoCount", service.getVideoCount());
		map.put("pid", vo.getPid());
		map.put("pName", vo.getPname());
		map.put("videoType", Constant.VIDEO_TYPE);
		setPage(vo, map);
		return "/video/list";
	}
	
	@RequestMapping("/search")
	public String search(String searchName , Integer nameType , VideoInfoVo vo, ModelMap map, HttpServletRequest request) {
		if(nameType == 0) {
			vo.setName(searchName);
		}else {
			try {
				Long id = Long.parseLong(searchName);
				vo.setId(id);
			} catch (NumberFormatException e) {
				throw new BusinessException("按id搜索时，只能输入数字");
			}
		}
		List<VideoInfoVo> list = service.selectVagueByModel(vo);
		map.put("videoCount", service.getVideoCount());
		map.put("list", list);
		map.put("pid", vo.getPid());
		map.put("pName", vo.getPname());
		map.put("videoType", Constant.VIDEO_TYPE);
		setPage(vo, map);
		return "/video/list";
	}
	
	@RequestMapping("/toEdit")
	public String toEdit(VideoInfoVo vo, ModelMap map, HttpServletRequest request) {
		String pname = vo.getPname();
		if (WebappUtil.objectAndIdNotNull(vo)) {
			vo = service.selectById(vo.getId());
			vo.setPname(pname);
		}
		map.put("pName", pname);
		map.put("vo", vo);
		map.put("videoType", Constant.VIDEO_TYPE);
		return "/video/edit";
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public DwzResultObject doEdit(VideoInfoVo vo, HttpServletRequest request) {
		vo.setUpdateUid(SessionUtils.getUser(request).getUsername());
		vo.setImg(upload.upload(request));
		service.update(vo);
		DwzResultObject dwz = new DwzResultObject();
		dwz.setNavTabId("albumVideoList" + vo.getPid());
		dwz.setForwardUrl(getForwardUrl(vo));
		dwz.setForwardTitle(vo.getPname() + "- 视频管理");
		dwz.setCallbackType(CallbackType.REDIRECT.getValue());
		dwz.setMessage(Constant.SUCCESS);
		return dwz;
	}

	private String getForwardUrl(VideoInfoVo vo) {
		StringBuilder url = new StringBuilder("../video/list.action?pid=");
		url.append(vo.getPid()).append("&pname=").append(vo.getPname());
		if(vo.getType() != null) {
			url.append("&type").append(vo.getType());
		}
		return url.toString();
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public DwzResultObject doRemove(VideoInfoVo vo, HttpServletRequest request) {
		DwzResultObject dwz = new DwzResultObject();
		String result = Constant.SUCCESS;
		if (vo.getId() == null) {
			logger.error("属性id为空!");
			result = "请选择删除内容！";
		} else {
			vo.setUpdateUid(SessionUtils.getUser(request).getUsername());
			service.delete(vo);
		}
		dwz.setNavTabId("albumVideoList" + vo.getPid());
		dwz.setForwardUrl(getForwardUrl(vo));
		dwz.setForwardTitle(vo.getPname() + "- 视频管理");
		dwz.setCallbackType(CallbackType.REDIRECT.getValue());
		dwz.setMessage(result);
		return dwz;
	}
	
}
