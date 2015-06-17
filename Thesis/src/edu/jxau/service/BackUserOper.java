package edu.jxau.service;

import java.util.List;

import org.web.exception.ErrorException;
import org.web.service.OperateService;

import edu.jxau.vo.UserInfo;

public class BackUserOper extends OperateService {

	@Override
	protected void add(Object entity) throws ErrorException {
		UserInfo ui = (UserInfo) entity;
		// 设置默认密码
		ui.setPassword("123456");
		super.add(ui);
	}

	@Override
	protected void add(List<Object> list) throws ErrorException {
		for(Object entity : list) {
			this.add(entity);
		}
	}
	
}
