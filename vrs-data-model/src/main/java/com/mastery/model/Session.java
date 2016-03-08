package com.mastery.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.mastery.common.Constant;

/**
 * HttpSession中存取的属性
 * 
 * @author zouziwen
 *
 *         2016年3月3日 下午5:40:57
 */
@SuppressWarnings("deprecation")
public class Session implements HttpSession, Serializable {

	/**
	 * 2016年3月4日 下午4:40:46
	 */
	private static final long serialVersionUID = -223239002589619050L;

	private User user;

	private List<Channel> channelList = new ArrayList<Channel>();

	private HttpSession session;

	public static Session newSession(HttpSession session) {
		return new Session(session);
	}
	
	public static Session newSession(HttpSession session, User user, List<Channel> channelList) {
		return new Session(session , user , channelList);
	}
	
	private Session(HttpSession session) {
		this(session, null, null);
	}

	private Session(HttpSession session, User user, List<Channel> channelList) {
		Objects.requireNonNull(session, "HttpSession is null");
		this.session = session;
		session.setAttribute(Constant.SESSION_KEY, this);
		setUser(user);
		setChannelList(channelList);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		if (user != null) {
			this.user = user;
			session.setAttribute("user", user);
		}

	}

	public List<Channel> getChannelList() {
		return channelList;
	}

	public void setChannelList(List<Channel> channelList) {
		if (channelList != null) {
			this.channelList = channelList;
			session.setAttribute("channelList", channelList);
		}
	}

	@Override
	public long getCreationTime() {
		return session.getCreationTime();
	}

	@Override
	public String getId() {
		return session.getId();
	}

	@Override
	public long getLastAccessedTime() {
		return session.getLastAccessedTime();
	}

	@Override
	public ServletContext getServletContext() {
		return session.getServletContext();
	}

	@Override
	public void setMaxInactiveInterval(int interval) {
		session.setMaxInactiveInterval(interval);
	}

	@Override
	public int getMaxInactiveInterval() {
		return session.getMaxInactiveInterval();
	}

	@Override
	public HttpSessionContext getSessionContext() {
		return session.getSessionContext();
	}

	@Override
	public Object getAttribute(String name) {
		return session.getAttribute(name);
	}

	@Override
	public Object getValue(String name) {
		return session.getValue(name);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Enumeration getAttributeNames() {
		return session.getAttributeNames();
	}

	@Override
	public String[] getValueNames() {
		return session.getValueNames();
	}

	@Override
	public void setAttribute(String name, Object value) {
		session.setAttribute(name, value);
	}

	@Override
	public void putValue(String name, Object value) {
		session.putValue(name, value);
	}

	@Override
	public void removeAttribute(String name) {
		session.removeAttribute(name);
	}

	@Override
	public void removeValue(String name) {
		session.removeValue(name);
	}

	@Override
	public void invalidate() {
		session.invalidate();
	}

	@Override
	public boolean isNew() {
		return session.isNew();
	}

}
