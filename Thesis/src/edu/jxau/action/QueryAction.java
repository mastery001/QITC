package edu.jxau.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.web.dao.core.support.Page;
import org.web.exception.ErrorException;
import org.web.framework.action.AutoWire;
import org.web.service.QueryService;
import org.web.servlet.ActionSupport;
import org.web.servlet.HttpServletRequestAware;

import edu.jxau.util.PageUtil;

public class QueryAction extends ActionSupport implements HttpServletRequestAware{

	private HttpServletRequest request;
	
	@AutoWire
	private Object bean;
	
	@Override
	public String execute() throws Exception {
		String viewName = this.action.substring(0, this.action.lastIndexOf("."));
		QueryService service = new QueryService(viewName , true , true);
		Page page = PageUtil.getPage(this.request, PageUtil.SHOW_NUM);
		try {
			List<Object> list = service.getResult(bean, page);
			request.setAttribute("list", list);
			request.setAttribute("page", page);
		} catch (ErrorException e) {
			this.addMessage(e.getMessage());
		}
		if(request.getParameter("show") != null && request.getParameter("show").equals("body")) {
			return "body";
		}
		return SUCCESS;
	}

	@Override
	public void setHttpServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
}
