package edu.jxau.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.web.access.factory.OperateServiceExecuteAdviceFactory;
import org.web.exception.ErrorException;
import org.web.framework.Constant;
import org.web.framework.action.AutoWire;
import org.web.service.OperateServiceExecuteAdvice;
import org.web.servlet.ActionSupport;
import org.web.servlet.HttpServletRequestAware;

import edu.jxau.vo.UserInfo;

public class OperateAction extends ActionSupport implements
		HttpServletRequestAware {

	@AutoWire
	private List<Object> list;

	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		String[] splitAction = this.action.split("_");
		String operate = splitAction[1];
		OperateServiceExecuteAdvice service = OperateServiceExecuteAdviceFactory
				.getService(splitAction[0]);
		System.out.println(list);
		try {
			service.execute(list, operate);
		} catch (ErrorException e) {
			this.addMessage(e.getMessage());
		}
		if (this.getResponseMessage().size() == 0) {
			this.addMessage("恭喜您" + Constant.changeOperateToChinese(operate)
					+ "成功！");
		}
		String gotoPage = request.getParameter("wd");
		if (gotoPage != null) {
			// 如果是后台操作
			if("back".equals(gotoPage)) {
				if(Constant.ADD.equals(operate)) {
					return "add";
				}
				this.allowRemoveRequestParam();
				this.setProperties("x", "back");
				return "back";
			}
			return getThesisesRetPath(gotoPage);

		}
		return SUCCESS;
	}

	private String getThesisesRetPath(String gotoPage) {
		this.allowRemoveRequestParam();
		UserInfo ui = (UserInfo) request.getSession().getAttribute("user");
		// 如果是回收站
		if ("body".equals(gotoPage)) {
			this.setProperties("isdelete", "1");
			this.setProperties("x", "ot");
			this.setProperties("u_id", ui.getU_id());
		} else if ("commit".equals(gotoPage)) {
			this.setProperties("isdelete", "0");
			this.setProperties("x", "cm");
			// 如果是论文提交
			this.setProperties("u_id", ui.getU_id());
		}else if("j".equals(gotoPage)) {
			// 如果是论文审核
			this.setProperties("isdelete", "0");
			this.setProperties("x", "info");
			this.setProperties("c_id", ui.getC_id());
			this.setProperties("commit_status", "1");
		}else {
			// 如果是论文删除
			this.setProperties("x", "rm");
			this.setProperties("isdelete", "0");
			// 如果是学生
			if(ui.getStatus() == 0) {
				this.setProperties("u_id", ui.getU_id());
			}else {
				this.setProperties("c_id", ui.getC_id());
				this.setProperties("commit_status", "1");
			}
		}
		return "operate";
	}

	@Override
	public void setHttpServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
