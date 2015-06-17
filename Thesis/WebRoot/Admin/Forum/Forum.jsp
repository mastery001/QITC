<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
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
<title>GongYing</title>
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
	<form name="form1" action="GongYing.do" method="post">
		<div class="place">
			<span>当前位置:</span>
			<ul class="placeul">
				<li><a href="#">论贴列表</a></li>
				<li><a href="javascript:void(0);" onclick="isDelete(<%=""%>);"
					class="tablelink"> &nbsp;&nbsp;&nbsp;清空所有论贴</a></li>
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
						<th>论贴ID</th>
						<th>论贴名称</th>
						<th>发布时间</th>
						<th>论贴作者</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href="javascript:void(0);" onclick="isDelete();"
							class="tablelink">删除</a></td>
					</tr>

				</tbody>
				<script type="text/javascript">
function isDelete(objId) {
	if (confirm("您确定要删除吗？")) {
	}
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
