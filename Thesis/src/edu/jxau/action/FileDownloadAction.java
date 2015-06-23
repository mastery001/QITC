package edu.jxau.action;

import javax.servlet.http.HttpServletResponse;

import org.web.framework.action.AutoWire;
import org.web.framework.action.support.InitOperations;
import org.web.servlet.ActionSupport;
import org.web.servlet.HttpServletResponseAware;

import edu.jxau.service.FileDownload;
import edu.jxau.vo.Thesises;

public class FileDownloadAction extends ActionSupport implements HttpServletResponseAware{

	private HttpServletResponse response;
	
	@AutoWire
	private Thesises t;
	
	@Override
	public String execute() throws Exception {
		t.setDocument(InitOperations.ServicesPath + t.getDocument());
		try {
			new FileDownload().downLoad(t, response, true); 
		} catch (Exception e) {
			this.addMessage(e.getMessage());
		}
		return NONE;
	}

	@Override
	public void setHttpServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	
}	
