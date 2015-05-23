package edu.jxau.action;

import javax.servlet.http.HttpServletRequest;

import org.web.exception.ErrorException;
import org.web.framework.action.AutoWire;
import org.web.servlet.ActionSupport;
import org.web.servlet.HttpServletRequestAware;

import edu.jxau.po.User;
import edu.jxau.service.LoginService;
import edu.jxau.vo.UserInfo;

public class LoginAction extends ActionSupport implements
		HttpServletRequestAware {

	private HttpServletRequest request;
	
	@AutoWire
	private User user;
	
	@Override
	public String execute() throws Exception {
		LoginService service = new LoginService(user);
		try {
			UserInfo userInfo = service.login();
			request.getSession().setAttribute("user", userInfo);
		} catch (ErrorException e) {
			this.addMessage(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	@Override
	public void setHttpServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
