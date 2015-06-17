<%@page import="com.zhuozhengsoft.pageoffice.FileSaver"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'saveFile.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<%
	FileSaver fs = new FileSaver(request, response);
	//保存Word文档到相应的磁盘路径中
	fs.saveToFile(request.getSession().getServletContext()
			.getRealPath("")
			+ "/" + fs.getFormField("doc"));
	//fs.showPage(300,300);//可在前台弹出相应大小的窗口，并在上面显示想要显示的信息内容
	fs.close();
%>
<body>
</body>
</html>
