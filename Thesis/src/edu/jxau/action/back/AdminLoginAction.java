package edu.jxau.action.back;

import javax.servlet.http.HttpServletRequest;

import org.web.exception.ErrorException;
import org.web.framework.action.AutoWire;
import org.web.servlet.ActionSupport;
import org.web.servlet.HttpServletRequestAware;

import edu.jxau.service.AdminService;
import edu.jxau.vo.Admin;

public class AdminLoginAction extends ActionSupport implements HttpServletRequestAware{

	@AutoWire
	private Admin admin;
	
	private HttpServletRequest request;
	
	@Override
	public String execute() throws Exception {
		try {
			new AdminService().loginAdmin(admin);
			this.request.getSession().setAttribute("admin", admin);
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
