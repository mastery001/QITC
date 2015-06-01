package edu.jxau.action;

import java.util.List;

import org.web.access.factory.OperateServiceExecuteAdviceFactory;
import org.web.exception.ErrorException;
import org.web.framework.Constant;
import org.web.framework.action.AutoWire;
import org.web.service.OperateServiceExecuteAdvice;
import org.web.servlet.ActionSupport;

public class OperateAction extends ActionSupport {

	@AutoWire
	private List<Object> list;

	@Override
	public String execute() throws Exception {
		String[] splitAction = this.action.split("_");
		String operate = splitAction[1];
		OperateServiceExecuteAdvice service = OperateServiceExecuteAdviceFactory
				.getService(splitAction[0]);
		try {
			service.execute(list, operate);
		} catch (ErrorException e) {
			this.addMessage(e.getMessage());
		}
		if (this.getResponseMessage().size() == 0) {
			this.addMessage("恭喜您" + Constant.changeOperateToChinese(operate)
					+ "成功！");
		}
		return operate;
	}

	public String add() throws Exception {
		this.executeMethod("add");
		if (this.getResponseMessage().size() == 0) {
			this.addMessage("恭喜您添加成功！");
		}
		return "add";
	}

	private void executeMethod(String operate) {
		System.out.println(list);
		String viewName = this.action
				.substring(0, this.action.lastIndexOf("_"));
		OperateServiceExecuteAdvice service = OperateServiceExecuteAdviceFactory
				.getService(viewName);
		try {
			service.execute(list, operate);
		} catch (ErrorException e) {
			this.addMessage(e.getMessage());
		}
	}

}
