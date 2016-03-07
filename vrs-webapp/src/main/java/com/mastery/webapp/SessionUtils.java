package com.mastery.webapp;

import javax.servlet.http.HttpServletRequest;

import com.mastery.common.Constant;
import com.mastery.model.Session;

public class SessionUtils {
	
	public static Session getSession(HttpServletRequest request) {
		return (Session) request.getSession().getAttribute(Constant.SESSION_KEY);
	}
	
	
}
