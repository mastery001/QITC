<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>管理员查看用户列表</title>
<link href="Admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="Admin/js/jquery.js">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>
<script type="text/javascript" src="js/custom/error.js"></script>
</head>
<body>
	<div class="place">
		<span>当前位置:</span>
		<ul class="placeul">
			<li><a href="UserInfo.query.do?x=back">系统用户管理</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<!--操作按钮开始===========================-->
		<!--操作按钮结束===========================-->
		<!--查询开始===========================-->

		<!--查询结束===========================-->
		<!--列表 开始===========================-->
		<table class="tablelist" width="963" height="147">

			<thead>
				<tr>
					<th>登录名</th>
					<th>姓名</th>
					<th>身份</th>
					<th>班级</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach var="entry" items="${list}">
				<tbody>
					<tr>
						<td>${entry.u_id}</td>
						<td>${entry.u_name}</td>
						<td>${entry.statusName}</td>
						<td>${entry.c_name}</td>
						<td><a href="UserInfo.query.do?u_id=${entry.u_id}&x=bupdate"
							class="tablelink">修改</a>&nbsp; <a href="javascript:void(0)"
							onClick="return isDelete('UserInfo_delete.do?wd=back&u_id=${entry.u_id }');"
							class="tablelink">删除</a></td>
					</tr>
				</tbody>
			</c:forEach>
			<tr>
				<td height="67" colspan="5"><div align="center" class="STYLE2">
						<a>共有${page.count}条记录 </a><a>当前第${page.page}页 </a> <a
							href="UserInfo.query.do?x=back&firstIndex=1">【首页】</a> <a
							href="UserInfo.query.do?x=back&firstIndex=${page.page-1<=1?1:page.page- 1}">【上一页】</a>
						<a
							href="UserInfo.query.do?x=back&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}">【下一页】
						</a> <a href="UserInfo.query.do?x=back&firstIndex=${page.lastPage}">【末页】</a>
					</div></td>
			</tr>
		</table>
		<!--列表 结束===========================-->
		<!--p s===========================-->
		<div class="pagin"></div>
		<!--p e===========================-->
	</div>

	<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>
</body>
</html>
