package com.mastery.webapp.controller.album;

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
import com.mastery.webapp.CallbackType;
import com.mastery.webapp.SessionUtils;
import com.mastery.webapp.UploadComponent;
import com.mastery.webapp.controller.BaseController;
import com.mastery.webapp.controller.result.DwzResultObject;
import com.mastery.webapp.service.IAlbumInfoVoService;
import com.mastery.webapp.util.WebappUtil;
import com.mastery.webapp.vo.AlbumInfoVo;

@Controller
@RequestMapping("/album/*")
public class AlbumInfoController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private IAlbumInfoVoService service;

	@Resource
	private UploadComponent upload;

	@RequestMapping("/view")
	public String view(AlbumInfoVo vo, ModelMap map, HttpServletRequest request) {
		List<AlbumInfoVo> list = service.selectByModel(vo);
		map.put("list", list);
		setPage(vo, map);
		return "/album/list";
	}

	@RequestMapping("/toEdit")
	public String toEdit(AlbumInfoVo vo, ModelMap map, HttpServletRequest request) {
		if (WebappUtil.objectAndIdNotNull(vo)) {
			vo = service.selectById(vo.getId());
		}
		vo.setCname(getChannel(request, vo.getCid()).getName());
		map.put("vo", vo);
		return "/album/edit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public DwzResultObject doEdit(AlbumInfoVo vo, HttpServletRequest request) {
		vo.setUpdateUid(SessionUtils.getUser(request).getUsername());
		vo.setImg(upload.upload(request));
		service.update(vo);
		DwzResultObject dwz = new DwzResultObject();
		dwz.setNavTabId("albumList" + vo.getCid());
		dwz.setForwardUrl("../album/view.action?cid=" + vo.getCid());
		dwz.setForwardTitle(getChannel(request, vo.getCid()).getName() + "专辑管理");
		dwz.setCallbackType(CallbackType.REDIRECT.getValue());
		dwz.setMessage(Constant.SUCCESS);
		return dwz;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public DwzResultObject doRemove(AlbumInfoVo vo, HttpServletRequest request) {
		DwzResultObject dwz = new DwzResultObject();
		String result = Constant.SUCCESS;
		if (vo.getId() == null) {
			logger.error("属性id为空!");
			result = "请选择删除内容！";
		} else {
			vo.setUpdateUid(SessionUtils.getUser(request).getUsername());
			service.delete(vo);
		}
		dwz.setNavTabId("albumList" + vo.getCid());
		dwz.setForwardUrl("../album/view.action?cid=" + vo.getCid());
		dwz.setForwardTitle(getChannel(request, vo.getCid()).getName() + "专辑管理");
		dwz.setCallbackType(CallbackType.REDIRECT.getValue());
		dwz.setMessage(result);
		return dwz;
	}
}
