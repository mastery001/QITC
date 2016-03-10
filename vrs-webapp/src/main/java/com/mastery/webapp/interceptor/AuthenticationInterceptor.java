package com.mastery.webapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mastery.model.User;
import com.mastery.webapp.SessionUtils;

/**
 * 用户登录拦截器
 * @author zouziwen
 *
 * 2016年3月7日 下午3:57:51
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = SessionUtils.getUser(request);
		if(user == null && !request.getRequestURI().contains("login")) {
			logger.info("current url is {}" , request.getRequestURI());
			response.sendRedirect("/login/login.action");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		return ;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
