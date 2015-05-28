package edu.jxau.action;

import org.web.access.factory.OperateServiceExecuteAdviceFactory;
import org.web.exception.ErrorException;
import org.web.framework.action.AutoWire;
import org.web.service.OperateServiceExecuteAdvice;
import org.web.servlet.ActionSupport;

public class OperateAction extends ActionSupport {

	@AutoWire
	private Object entity;

	@Override
	public String execute() throws Exception {
		return null;
	}

	public String add() throws Exception {
		this.executeMethod("add");
		if (this.getResponseMessage().size() == 0) {
			this.addMessage("恭喜您添加成功！");
		}
		return "add";
	}

	private void executeMethod(String operate) {
		System.out.println(entity);
		OperateServiceExecuteAdvice service = OperateServiceExecuteAdviceFactory
				.getService(entity.getClass().getSimpleName());
		try {
			service.execute(entity, operate);
		} catch (ErrorException e) {
			this.addMessage(e.getMessage());
		}
	}

}
