package com.mastery.webapp;

import javax.servlet.http.HttpServletRequest;

import com.mastery.model.User;

public class SessionUtils {
	
	public static final String USER_KEY = "user";
	
	public static User getUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(USER_KEY);
	}
	
	public static void setUser(HttpServletRequest request , User user) {
		request.getSession().setAttribute(USER_KEY , user);
	}
}
