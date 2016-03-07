package com.mastery.webapp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mastery.common.Constant;
import com.mastery.model.Session;
import com.mastery.model.User;
import com.mastery.service.IChannelService;
import com.mastery.service.IUserService;

@Controller
public class LoginController extends BaseContorller{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IChannelService channelService;
	
	@RequestMapping("/login")
	public String show() {
		return "/login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(User user , HttpServletRequest request , ModelMap map) {
		User newUser = userService.login(user);
		logger.info("user is {} , new User is {}" , user , newUser);
		if(newUser == null) {
			logger.info("error用户名或密码错误");
			map.put("error", "用户名或密码错误");
			return "/login";
		}
		Session session = new Session(newUser , channelService.getChannels());
		request.getSession().setAttribute(Constant.SESSION_KEY, session);
		return "/";
	}
}
