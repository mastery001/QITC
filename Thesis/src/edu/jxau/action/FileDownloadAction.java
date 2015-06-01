package edu.jxau.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.framework.action.AutoWire;
import org.web.servlet.ActionSupport;
import org.web.servlet.HttpServletRequestAware;
import org.web.servlet.HttpServletResponseAware;

import edu.jxau.service.FileDownload;
import edu.jxau.vo.Thesises;

public class FileDownloadAction extends ActionSupport implements HttpServletRequestAware , HttpServletResponseAware{

	private HttpServletResponse response;
	
	private HttpServletRequest request;
	
	@AutoWire
	private Thesises t;
	
	@Override
	public String execute() throws Exception {
		String document = t.getDocument();
		if(document == null) {
			throw new NullPointerException("document参数不能为空！");
		}
		String filePath = request.getServletContext().getRealPath("/") + document;	
		try {
			new FileDownload().downLoad(filePath, response, true); 
		} catch (Exception e) {
			this.addMessage(e.getMessage());
		}
		return NONE;
	}

	@Override
	public void setHttpServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setHttpServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
}	
