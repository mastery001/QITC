package edu.jxau.action.back;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.web.service.QueryService;
import org.web.servlet.ActionSupport;
import org.web.servlet.HttpServletRequestAware;

public class AjaxGetValueAction extends ActionSupport implements
		HttpServletRequestAware {

	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		String viewName = this.action.substring(
				this.action.lastIndexOf(".")+1);
		QueryService service = new QueryService(viewName, false);
		List<Object> list = service.getResult(null, null);
		request.setAttribute("list", list);
		return viewName;
	}

	@Override
	public void setHttpServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
