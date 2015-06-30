package edu.jxau.action.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import edu.jxau.vo.UserInfo;

public class LoginUser {

	// 存储登录用户，
	private static Map<UserInfo, HttpSession> sessionUser = new HashMap<UserInfo, HttpSession>();

	/**
	 * 添加登录用户
	 * 
	 * @param user
	 */
	public static void addLoginUser(UserInfo username , HttpSession session) {
		if (username == null) {
			throw new NullPointerException("username参数不能为空!");
		}
		// 判断此用户是否已经登录，如果未登录则进入登录状态
		if (!sessionUser.containsKey(username)) {
			sessionUser.put(username , session);
		}
	}

	/**
	 * 移除登录用户
	 * 
	 * @param user
	 */
	public static void removeLoginUser(UserInfo username) {
		if (username == null) {
			throw new NullPointerException("username参数不能为空!");
		}
		// 判断此用户是否已经登录，如果登录则移除
		if (sessionUser.containsKey(username)) {
			sessionUser.remove(username);
		}
	}
	
	public static HttpSession getSession(UserInfo username) {
		return sessionUser.get(username);
	}

	public static Set<UserInfo> getLoginUser() {
		return sessionUser.keySet();
	}
	
	public static int getCount() {
		return sessionUser.size();
	}
}
