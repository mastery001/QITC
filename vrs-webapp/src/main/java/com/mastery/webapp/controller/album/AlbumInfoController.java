package com.mastery.webapp.controller.album;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class AlbumInfoController extends BaseController{

	@Resource
	private IAlbumInfoVoService service;
	
	@Resource
	private UploadComponent upload;
	
	@RequestMapping("/view")
	public String view(AlbumInfoVo vo , ModelMap map, HttpServletRequest request ) {
		List<AlbumInfoVo> list = service.selectByModel(vo);
		map.put("list", list);
		setPage(vo, map);
		return "/album/list";
	}

	@RequestMapping("/toEdit")
	public String toEdit(AlbumInfoVo vo , ModelMap map , HttpServletRequest request) {
		if(WebappUtil.objectAndIdNotNull(vo)) {
			vo = service.selectById(vo.getId());
		}
		vo.setCname(getChannel(request, vo.getCid()).getName());
		map.put("vo", vo);
		return "/album/edit";
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public DwzResultObject doEdit(AlbumInfoVo vo  , HttpServletRequest request ) {
		vo.setUpdateUid(SessionUtils.getUser(request).getUsername());
		vo.setImg(upload.upload(request));
		service.update(vo);
		String cname = getChannel(request, vo.getCid()).getName();
		DwzResultObject dwz = new DwzResultObject();
		dwz.setForwardUrl("../album/view.action");
		dwz.setCallbackType(CallbackType.REDIRECT.getValue());
		dwz.setForwardTitle(cname + "专辑列表");
		return dwz;
	}
}
