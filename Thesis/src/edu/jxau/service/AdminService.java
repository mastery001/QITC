package edu.jxau.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.web.exception.ErrorException;

import tool.mastery.core.ToolKit;
import tool.mastery.log.Logger;

import edu.jxau.vo.Admin;

public class AdminService {

	private static final Admin ROOT = new Admin();

	static {
		InputStream is = ToolKit.getResourceAsStream("admin.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			Logger.getLogger(AdminService.class).debug(e.getMessage(), e);
		}
		ROOT.setUname(prop.getProperty("uname"));
		ROOT.setPasswd(prop.getProperty("passwd"));
	}

	public void loginAdmin(Admin admin) throws ErrorException {
		if (admin == null) {
			throw new NullPointerException("admin参数为空");
		}
		if (!ROOT.getUname().equals(admin.getUname())
				|| !ROOT.getPasswd().equals(admin.getPasswd())) {
			throw new ErrorException("用户名或密码错误！请重新登录！");
		}
	}
}
