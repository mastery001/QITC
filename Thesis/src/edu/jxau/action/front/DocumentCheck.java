package edu.jxau.action.front;

import javax.servlet.http.HttpServletRequest;

import org.web.framework.action.support.InitOperations;
import org.web.servlet.ActionSupport;
import org.web.servlet.HttpServletRequestAware;

import tool.mastery.core.StringUtil;
import edu.jxau.service.CheckThesisService;
import edu.jxau.service.match.support.MatchResult;

public class DocumentCheck extends ActionSupport implements HttpServletRequestAware{

	private HttpServletRequest request;
	
	private static boolean isExe;
	
	@Override
	public String execute() throws Exception {
		String document = request.getParameter("document");
		if(StringUtil.StringIsNull(document)) { 
			throw new NullPointerException("document参数不能为空");
		}
		MatchResult mr = null;
		if(!isExe) {
			isExe = true;
			new CheckThesisService(InitOperations.ServicesPath).check(document);
		}else {
			mr = CheckThesisService.result();
		}
		if(mr != null) {
			isExe = false;
			request.setAttribute("rate", mr.result());
		}
		return SUCCESS;
	}

	@Override
	public void setHttpServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
