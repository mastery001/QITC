<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<div class="place">
		<span>当前位置:</span>
		<ul class="placeul">
			<li><a href="#">无效论文列表</a></li>
			<li><a href="javascript:void(0);" onclick="isDelete(<%=""%>);"
				class="tablelink"> &nbsp;&nbsp;&nbsp;清空无效论文</a></li>
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
					<th>论文ID</th>
					<th>论文名称</th>
					<th>论文作者</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach var="entry" items="${list}">
				<tbody>

					<tr>
						<td>${entry.t_id}</td>
						<td>${entry.t_name}</td>
						<td>${entry.u_name}</td>


						<td><a href="javascript:void(0);" onclick="isDelete();"
							class="tablelink">删除</a></td>
					</tr>

				</tbody>
			</c:forEach>
			<script type="text/javascript">
function isDelete(objId) {
	if (confirm("您确定要删除吗？")) {
		window.location.href = "../../GongYing.do?action=delete&id=" + objId;
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
</body>
</html>
