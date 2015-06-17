<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>江西农业大学论文评审系统</title>
	</head>

	<frameset rows="88,*" cols="*" frameborder="no" border="0"
		framespacing="0">
		<frame src="Admin/top.jsp" name="topFrame" scrolling="no"
			noresize="noresize" id="topFrame" title="topFrame" />
		<frameset cols="188,*" frameborder="no" border="0" framespacing="0">
			<frame src="Admin/left.jsp" name="leftFrame" scrolling="no"
				noresize="noresize" id="leftFrame" title="leftFrame" />
			<frame src="Admin/m.jsp" name="rightFrame" id="rightFrame"
				title="rightFrame" />
		</frameset>
	</frameset>
	<noframes>
		<body>
		</body>
	</noframes>
</html>
