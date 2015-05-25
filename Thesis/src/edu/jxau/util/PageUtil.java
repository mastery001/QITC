package edu.jxau.util;

import javax.servlet.http.HttpServletRequest;

import org.web.dao.core.support.Page;

public class PageUtil {

	// 设置每页显示条数
	public static final Integer SHOW_NUM = 2;

	/**
	 * 接收前台传递的参数并且封装成Page对象
	 * 
	 * @param request
	 * @param pageMaxSize
	 * @return
	 */
	public static Page getPage(HttpServletRequest request, Integer pageMaxSize) {
		Page page = new Page();
		if (pageMaxSize != null) {
			page.setMaxSize(pageMaxSize);
		}
		// 获得从页面中传递过来的数据
		String firstIndex = request.getParameter("firstIndex");
		if (firstIndex != null) {
			int temp = Integer.parseInt(firstIndex);
			page.setPage(temp);
		}
		return page;
	}
}
