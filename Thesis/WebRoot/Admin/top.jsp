<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
	<c:if test="${sessionScope.admin == null }">
		<script>
			window.parent.toUrl();
		</script>
	</c:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
		<title>头部</title>
		<link href="Admin/css/style.css" rel="stylesheet" type="text/css" />

		<script language="JavaScript" src="Admin/js/jquery.js">
</script>

		<script type="text/javascript">
$(function() {
	//顶部导航切换
	$(".nav li a").click(function() {
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})
})
</script>
<script type="text/javascript" src="js/custom/error.js"></script>
	</head>
	<input type="hidden" id="msg" value="${info[0]}" />
	<body style="background: url(Admin/images/topbg.gif) repeat-x;">
		
		<div class="topleft">
			<a href="main.html" target="_parent"> <img src="Admin/images/pph.png"
					title="系统首页" width="306" height="74"/> </a>
		</div>
		
		<div class="topright">
			<ul>
				<li>
					<span> <img src="Admin/images/help.png" title="帮助" class="helpimg" />
					</span><a href="#">帮助</a>
				</li>
				<li>
					<a href="#">关于</a>
				</li>
				<li>
					<a href="Admin/login.jsp" target="_parent" id="exit">退出</a>
				</li>
			</ul>
			<div class="user" style="color: white;">
				<%
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String time = format.format(new java.util.Date());
					out.print(time);
				%>
				欢迎
				<span> <label id="lblAdmin">
					</label> </span>
			</div>
		</div>
	</body>
</html>
