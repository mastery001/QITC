package edu.jxau.action.front;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.web.framework.action.AutoWire;
import org.web.servlet.ActionSupport;
import org.web.servlet.HttpServletRequestAware;

import edu.jxau.service.chat.MessageBoard;
import edu.jxau.vo.UserMessage;

public class SendMessage extends ActionSupport implements HttpServletRequestAware{

	@AutoWire
	private UserMessage userMessage;
	
	private HttpServletRequest request;
	@Override
	public String execute() throws Exception {
		Random random = new Random();
		// 获取需要发送的人
		if (userMessage != null && userMessage.getTo() != null) {
			userMessage.setSendTime(new Date());
			// 如果是发送给所有人，则给所有人都发送
			if(userMessage.getTo().equals("所有人")) {
				MessageBoard.sendMessage(userMessage);
			}else {
				// 如果是私聊，则只发送给对应的用户
				MessageBoard.sendMessageToOneUser(userMessage, userMessage.getFrom() ,  userMessage.getTo());
			}
		}
		this.setProperties("nocache",  String.valueOf(random.nextInt(10000)));
		if(request.getParameter("o") != null) {
			return "self";
		}
		return SUCCESS;
	}

	@Override
	public void setHttpServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
