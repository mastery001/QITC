<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>CaiGou</title>
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

</head>
<body>
	<form name="form1" action="CaiGou.do" method="post">
		<div class="place">
			<span>当前位置:</span>
			<ul class="placeul">
				<li><a href="#">班级管理</a></li>
			</ul>
		</div>
		<div class="rightinfo">
			<!--操作按钮开始===========================-->
			<!--操作按钮结束===========================-->
			<!--查询开始===========================-->

			<!--查询结束===========================-->
			<!--列表 开始===========================-->
			<table class="tablelist">

				<thead>
					<tr>
						<th>班级名称</th>
						<th>班级方向</th>
						<th>操作</th>
					</tr>
				</thead>
				<c:forEach var="entry" items="${list }">
					<tbody>
						<tr>
							<td>${entry.c_name }</td>
							<td>${entry.major }</td>
							<td><a href="Grade.query.do?c_id=${entry.c_id }&x=bupdate" class="tablelink">修改</a>&nbsp; <a
								href="Grade_delete.do?wd=back&c_id=${entry.c_id }" onclick="return isDelete();"
								class="tablelink">删除</a></td>
						</tr>
					</tbody>
				</c:forEach>
				<script type="text/javascript">
					function isDelete() {
						if (confirm("您确定要删除吗？")) {
							return true;
						}
						return false;
					}
				</script>

			</table>
			<!--列表 结束===========================-->
			<!--p s===========================-->
			<div class="pagin"></div>
			<!--p e===========================-->
		</div>

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>
	</form>
</body>
</html>
