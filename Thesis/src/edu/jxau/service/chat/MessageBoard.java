package edu.jxau.service.chat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import edu.jxau.action.filter.LoginUser;
import edu.jxau.vo.UserInfo;
import edu.jxau.vo.UserMessage;

@SuppressWarnings("unchecked")
public class MessageBoard {

	/**
	 * 发送信息给所有用户
	 * @param userMessage
	 */
	public static void sendMessage(UserMessage userMessage) {
		Set<UserInfo> loginUser = LoginUser.getLoginUser();
		for(Iterator<UserInfo> it = loginUser.iterator() ; it.hasNext(); ) {
			HttpSession userSession = LoginUser.getSession(it.next());
			List<UserMessage> message = (List<UserMessage>) userSession
					.getAttribute("message");
			if(message == null) {
				message = new ArrayList<UserMessage>();;
			}
			message.add(userMessage);
			userSession.setAttribute("message", message);
		}
	}
	
	/**
	 * 发送信息给指定用户
	 * @param userMessage
	 */
	public static void sendMessageToOneUser(UserMessage userMessage , String from ,  String to) {
		Set<UserInfo> loginUser = LoginUser.getLoginUser();
		for(Iterator<UserInfo> it = loginUser.iterator() ; it.hasNext(); ) {
			UserInfo ui = it.next();
			String username = ui.getU_id();
			if(username.equalsIgnoreCase(from) || username.equalsIgnoreCase(to)) {
				HttpSession userSession = LoginUser.getSession(ui);
				List<UserMessage> message = (List<UserMessage>) userSession
						.getAttribute("message");
				message.add(userMessage);
				userSession.setAttribute("message", message);
			}
		}
	}
}
