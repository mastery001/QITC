package com.mastery.webapp.controller.album;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mastery.webapp.controller.BaseContorller;
import com.mastery.webapp.vo.AlbumInfoVo;

@Controller
@RequestMapping("/album/*")
public class AlbumInfoController extends BaseContorller{

	@RequestMapping("/view")
	public String view(AlbumInfoVo vo , ModelMap map, HttpServletRequest request ) {
		List<AlbumInfoVo> list = new ArrayList<AlbumInfoVo>();
		vo.setId(1L);
		vo.setIsEnd(1);
		list.add(vo);
		map.put("list", list);
		return "/album/list";
		
	}
	

	@RequestMapping("/toEdit")
	public String toEdit(AlbumInfoVo vo , ModelMap map , HttpServletRequest request) {
		vo.setCname(getChannel(request, vo.getCid()).getName());
		map.put("vo", vo);
		return "/album/edit";
	}
}
