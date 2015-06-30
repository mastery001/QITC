<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧菜单</title>
<link href="Admin/css/style.css" rel="stylesheet" type="text/css" />

<script language="JavaScript" src="Admin/js/jquery.js">
	
</script>

<script type="text/javascript">
	$(function() {
		//导航切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});

		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
	})
</script>

</head>
<body style="background: #f0f9fd;">

	<div class="lefttop">
		<span></span>后台管理

	</div>
	<dl class="leftmenu">

		<dd>
			<div class="title">
				<span><img src="Admin/images/leftico01.png" /> </span>用户管理：
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="Admin/UserInfo/UserInfo_add.jsp"
					target="rightFrame">用户添加</a><i></i></li>
				<li><cite></cite><a href="UserInfo.query.do?x=back"
					target="rightFrame">用户列表</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="Admin/images/leftico01.png" /> </span>班级管理：
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="Admin/Grade/Grade_add.jsp"
					target="rightFrame">班级添加</a><i></i></li>
				<li><cite></cite><a href="Grade.query.do?x=back" target="rightFrame">班级列表</a><i></i>
				</li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="Admin/images/leftico01.png" /> </span>论文库管理：
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="Documents.query.do?x=back"
					target="rightFrame">论文库查看</a><i></i></li>
					<li><cite></cite><a href="Admin/Documents/Documents_add.jsp"
					target="rightFrame">论文库上传</a><i></i></li>

			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img src="Admin/images/leftico01.png" /> </span>论文管理：
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="Admin/Thesises/Thesises.jsp"
					target="rightFrame">无效论文</a><i></i></li>

			</ul>
		</dd>

		<dd>
			<div class="title">
				<span><img src="Admin/images/leftico01.png" /> </span>论坛管理：
			</div>
			<ul class="menuson">

				<li><cite></cite><a href="Admin/Forum/Forum_add.jsp"
					target="rightFrame">公告发布</a><i></i></li>

				<li><cite></cite><a href="Admin/Forum/Forum.jsp" target="rightFrame">论贴设置</a><i></i>
				</li>


			</ul>
		</dd>

		<dd>
			<div class="title">
				<span><img src="Admin/images/leftico01.png" /> </span>系统管理：
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="Admin/m.jsp" target="rightFrame">系统备份</a><i></i>
				</li>

				<li><cite></cite><a href="Admin/m.jsp" target="rightFrame">系统恢复</a><i></i>
				</li>
				<li><cite></cite><a href="Admin/m.jsp" target="rightFrame">
						系统操作日志</a><i></i></li>


			</ul>
		</dd>



	</dl>
</body>
</html>
