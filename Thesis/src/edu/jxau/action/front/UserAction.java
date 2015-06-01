package edu.jxau.action.front;

import javax.servlet.http.HttpServletRequest;

import org.web.exception.ErrorException;
import org.web.framework.action.AutoWire;
import org.web.servlet.ActionSupport;
import org.web.servlet.HttpServletRequestAware;

import tool.mastery.core.CollectionUtil;
import edu.jxau.po.User;
import edu.jxau.service.UserService;
import edu.jxau.vo.UserInfo;

public class UserAction extends ActionSupport implements
		HttpServletRequestAware {

	@AutoWire
	private User user;

	private HttpServletRequest request;

	private String operate;

	/**
	 * 此处当传递参数
	 * 
	 * @param=up 时为用户信息修改
	 * @param=ps 时为用户密码修改
	 * @param=pp 时为用户密保修改
	 */
	@Override
	public String execute() throws Exception {
		System.out.println(user);
		// 得到操作类型
		operate = this.request.getParameter("op");
		System.out.println("operate is" +operate);
		if ("ps".equals(operate)) {
			return updatePassword();
		}
		UserInfo ui = null;
		try {
			UserService service = new UserService();
			String retVal = validateView(service);
			if (retVal != null) {
				return retVal;
			}
			ui = service.execute(user, operate);
			if ("up".equals(operate)) {
				this.request.setAttribute("list",
						CollectionUtil.convertObjectToList(ui));
			}
		} catch (Exception e) {
			this.addMessage(e.getMessage());
		}
		if (this.getResponseMessage().size() == 0) {
			this.request.getSession().setAttribute("user", ui);
			this.addMessage("恭喜您修改成功！");
		}
		return operate;
	}

	/**
	 * @Title: validateView
	 * @Description: 验证是否密保修改时的视图切换
	 * @param @param service
	 * @param @return
	 * @return String 返回类型
	 * @throws
	 */
	private String validateView(UserService service) {
		if (request.getParameter("s") != null) {
			User user1 = service.getUser(user.getU_id());
			request.setAttribute("user1", user1);
			return "pp";
		} else if (request.getParameter("v") != null) {
			boolean flag = service.validateUserIsExist(user);
			if (!flag) {
				this.addMessage("密保答案错误！请重新验证！");
				request.setAttribute("user1", user);
			}
			return "pp";
		}
		return null;
	}

	/**
	 * @Title: updatePassword
	 * @Description: 修改密码操作
	 * @param @return
	 * @param @throws ErrorException
	 * @return String 返回类型
	 * @throws
	 */
	private String updatePassword() throws ErrorException {
		String oldPassword = request.getParameter("oldPassword");
		if (!((UserInfo) request.getSession().getAttribute("user"))
				.getPassword().equals(oldPassword)) {
			this.addMessage("原密码输入错误！请重新输入！");
			return operate;
		}
		user.setPassword(request.getParameter("newPassword"));
		new UserService().execute(user, operate);
		this.addMessage("密码修改成功，请重新登录！");
		return "ps_success";
	}

	@Override
	public void setHttpServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
