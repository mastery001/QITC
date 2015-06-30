package edu.jxau.action.back;

import org.web.access.factory.OperateServiceExecuteAdviceFactory;
import org.web.exception.ErrorException;
import org.web.framework.action.AutoWire;
import org.web.service.OperateServiceExecuteAdvice;
import org.web.servlet.ActionSupport;

import edu.jxau.po.Documents;

public class UploadDocuments extends ActionSupport{

	@AutoWire
	private Documents docs;
	
	@Override
	public String execute() throws Exception {
		OperateServiceExecuteAdvice service = OperateServiceExecuteAdviceFactory
				.getService("Documents");
		try {
			service.execute(docs, "add");
		} catch (ErrorException e) {
			this.addMessage(e.getMessage());
		}
		if (this.getResponseMessage().size() == 0) {
			this.addMessage("恭喜您上传成功！");
		}
		return SUCCESS;
	}

}
