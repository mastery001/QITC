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

<title>江西农业大学论文评审系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script charset="utf-8" type="text/javascript" src="js/custom/error.js"></script>
</head>
<body>
	<input type="hidden" id="msg" value="${info[0]}" />

	<form action="login.do" method="post">
		<div class="login">
			<div class="box png">
				<div class="logo png"></div>
				<div class="input">
					<div class="log">
						<div class="name">
							<label>用户名</label><input type="text" class="text" id="value_1"
								placeholder="用户名" name="u_id" tabindex="1">
						</div>
						<div class="pwd">
							<label>密 码</label><input type="password" class="text"
								id="value_2" placeholder="密码" name="password" tabindex="2">
							<input type="submit" class="submit" tabindex="3" value="登录">
							<div class="check"></div>
						</div>
						<div class="tip"></div>
					</div>
				</div>
			</div>

		</div>
	</form>
	<script type="text/javascript" src="js/jQuery.js"></script>
	<script type="text/javascript" src="js/fun.base.js"></script>
	<script type="text/javascript" src="js/script.js"></script>


	<!--[if IE 6]>
<script src="js/DD_belatedPNG.js" type="text/javascript"></script>
<script>DD_belatedPNG.fix('.png')</script>
<![endif]-->
	<div
		style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
	</div>
</body>
</html>
