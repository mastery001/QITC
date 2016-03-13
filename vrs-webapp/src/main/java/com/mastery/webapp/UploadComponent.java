package com.mastery.webapp;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mastery.common.CalendarUtil;
import com.mastery.common.Constant;
import com.mastery.common.exception.CommonException;

/**
 * 上传的组件
 * 
 * @author mastery
 * @time 2016年3月13日下午10:06:29
 */
@Component
public class UploadComponent {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private ConfigHolder configHolder;

	/**
	 * 上传图片并获得相对路径名
	 * 
	 * @time 2016年3月13日下午10:09:49
	 * @param request
	 * @return
	 */
	public String upload(HttpServletRequest request) {
		if (!(request instanceof MultipartHttpServletRequest)) {
			return null;
		}
		// 获得上传文件对象
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 得到上传的文件，name为myFile
		MultipartFile multipartFile = multipartRequest.getFile("myFile");
		if (multipartFile.getOriginalFilename().trim().equals("")) {
			return null;
		}
		// 构建上传目录名，即上传目录+/+当前日期，当前为localUpload/当前日期
		String upload = configHolder.getUploadDir() + Constant.SEPARATE_XIE
				+ CalendarUtil.getDateString(Calendar.getInstance(), CalendarUtil.SHORT_DATE_FORMAT_NO_DASH);// 上传目录
		// 获取上传文件的后缀名
		String suffix = multipartFile.getOriginalFilename()
				.substring(multipartFile.getOriginalFilename().lastIndexOf(Constant.DOT_STRING));
		File sourcePicDir = new File(upload);
		if (!sourcePicDir.exists()) {
			sourcePicDir.mkdirs();
		}
		String sourcePicName = UUID.randomUUID().toString() + suffix;
		String sourceFileName = upload + Constant.SEPARATE_XIE + sourcePicName;
		File file = new File(sourceFileName);
		try {
			multipartFile.transferTo(file);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CommonException("图片生成错误！");
		}
		logger.info("upload file is {}" , sourceFileName);
		return sourceFileName;
	}
}
