package com.mastery.webapp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mastery.model.Channel;
import com.mastery.service.IChannelService;

@Controller
public class IndexController extends BaseController{

	
	@Resource
	private IChannelService channelService;
	
	/**
	 * 用户登陆媒资后台后根据cas权限进行分配节点功能
	 * 
	 * @param request
	 * @return 返回目录节点列表的结果集到前台页面
	 */
	@RequestMapping("/index/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Channel> channelList = channelService.getChannels();
		request.getSession().setAttribute("channelList", channelList);
		mav.setViewName("/index");
		return mav;
	}
}
