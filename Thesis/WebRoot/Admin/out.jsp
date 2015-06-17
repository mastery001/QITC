<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.myProject.JingJia.util.*,java.text.*"%>
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
<title>安全退出</title>
</head>
<body><br>
<% 
	   	session.removeAttribute("user"); 
	   	out.print("<script>window.parent.location.href='../index.jsp';</script>"); 
	    //request.getSession().invalidate();
        //request.getRequestDispatcher("index.jsp").forward(request, response);
 %>
</body>
</html>