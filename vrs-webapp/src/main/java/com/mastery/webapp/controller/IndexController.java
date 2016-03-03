package com.mastery.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends BaseContorller{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 用户登陆媒资后台后根据cas权限进行分配节点功能
	 * 
	 * @param request
	 * @return 返回目录节点列表的结果集到前台页面
	 * @throws AuthenticationException
	 */
	@RequestMapping("/index/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
//		mav.addObject("user", getSession(request).getUser().getUsername());
		mav.setViewName("/index");
		return mav;
	}
}
