<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	if(session.getAttribute("admin") != null) {
		session.invalidate();
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>欢迎登录后台管理系统</title>
<link href="Admin/css/style.css" rel="stylesheet" type="text/css" />

<script src="Admin/js/jquery.js">
	
</script>

<script src="Admin/js/cloud.js" type="text/javascript">
	
</script>

<script language="javascript">
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
	});
</script>
<script charset="utf-8" type="text/javascript" src="js/custom/error.js"></script>
</head>
<body
	style="background-color: #1c77ac; background-image: url(Admin/images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">
		<input type="hidden" id="msg" value="${info[0]}" />
	<form id="form1" method="post" action="Admin.do">
		<div id="mainBody">
			<div id="cloud1" class="cloud"></div>
			<div id="cloud2" class="cloud"></div>
		</div>
		<div class="logintop">
			<span>欢迎登录论文评审后台管理界面平台</span>
			<ul>
				<li><a href="Admin/login.jsp">帮助</a></li>
				<li><a href="Admin/login.jsp">关于</a></li>
			</ul>
		</div>
		<div class="loginbody">
			<span class="systemlogo"></span>
			<div class="loginbox">
				<ul>
					<li><input id="uname" name="uname" class="loginuser"
						type="text"></input></li>
					<li><input id="passwd" name="passwd" class="loginpwd"
						type="password"></input></li>
					<li><input type="submit" class="loginbtn" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;<a href="login.jsp" style="font-size:15px">普通用户登陆</a></li>
					
				</ul>
			</div>
		</div>
		<div class="loginbm">版权所有 江西农业大学软件学院软件1202</div>
	</form>
</body>
</html>
