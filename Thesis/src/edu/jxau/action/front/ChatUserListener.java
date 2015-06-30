package edu.jxau.action.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.web.servlet.ActionSupport;
import org.web.servlet.HttpServletRequestAware;

import edu.jxau.action.filter.LoginUser;
import edu.jxau.service.chat.MessageBoard;
import edu.jxau.vo.UserInfo;
import edu.jxau.vo.UserMessage;

public class ChatUserListener extends ActionSupport implements
		HttpServletRequestAware {

	private HttpServletRequest request;
	
	private static boolean isCome = false;

	@Override
	public String execute() throws Exception {
		String operate = request.getParameter("oper");
		HttpSession session = request.getSession();
		UserInfo ui = (UserInfo) session.getAttribute("user");
		// 用户进入聊天室
		if ("come".equals(operate) && !isCome) {
			isCome = true;
			// 添加登陆用户
			LoginUser.addLoginUser(ui, session);
			UserMessage userMessage = new UserMessage();
			userMessage.setWelcome("系统公告：<font color='gray'>" + ui.getC_name()
					+ "的" + ui.getU_name() + "走进了聊天室！</font><br>");
			if(UserMessage.comeCount == 0) {
				UserMessage.comeCount = 1;
				MessageBoard.sendMessage(userMessage);
			}
		} else if("exit".equals(operate) && isCome){
			isCome = false;
			LoginUser.removeLoginUser(ui);
			session.removeAttribute("message");
			UserMessage userMessage = new UserMessage();
			userMessage.setWelcome("系统公告：<font color='gray'>" + ui.getC_name()
					+ "的" + ui.getU_name() + "离开了聊天室！</font><br>");
			if(UserMessage.comeCount == 1) {
				UserMessage.comeCount = 0;
				MessageBoard.sendMessage(userMessage);
			}
		}
		return NONE;
	}

	@Override
	public void setHttpServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
