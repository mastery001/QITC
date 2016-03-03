package com.mastery.webapp.controller.resolver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mastery.common.exception.BusinessException;
import com.mastery.webapp.controller.result.DwzResultObject;

public class DefaultMappingExceptionResolver extends SimpleMappingExceptionResolver {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String ERROR_SYSTEM_ERROR = "系统出现异常，请稍后再试";
	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		logger.info("出现异常，exception is {}" , ex);
		if(ex instanceof BusinessException) {
			responseJson(request, response, ex.getMessage());
		}else {
			responseJson(request, response, ERROR_SYSTEM_ERROR);
		}
		
		return null;
	}

	/**
	 * 生成json并返回给客户端
	 * 
	 * @param req
	 * @param res
	 * @param message
	 */
	private void responseJson(HttpServletRequest request, HttpServletResponse response, String message) {
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
		} catch (IOException e1) {
			logger.error("在取得PrintWriter时出现异常");
		}
		DwzResultObject dwz = new DwzResultObject();
		dwz.setMessage(message);
		dwz.setStatusCode(DwzResultObject.DWZ_STATUS_CODE_FAIL);
		out.print(JSON.toJSONString(dwz, SerializerFeature.WriteMapNullValue));
		out.flush();
		out.close();

	}

}
