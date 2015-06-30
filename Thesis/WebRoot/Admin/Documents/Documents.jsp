<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>论文库查看</title>
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
			<li><a href="Documents.query.do?x=back">论文库管理</a>
			</li>
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
					<th>论文名称</th>
					<th>论文上传时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach var="entry" items="${list }">
				<tbody>
					<tr>
						<td><a
							href="Admin/Documents/word.jsp?document=${entry.document}">${entry.d_name}</a>
						</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
								value="${entry.up_time }" type="both" />
						</td>
						<td><a href="javascript:void(0)"
							onClick="return isDelete('Documents_delete.do?wd=back&id=${entry.id }');"
							class="tablelink">删除</a>
						</td>
					</tr>
				</tbody>
			</c:forEach>
			<tr>
				<td height="67" colspan="5"><div align="center" class="STYLE2">
						<a>共有${page.count}条记录 </a><a>当前第${page.page}页 </a> <a
							href="Documents.query.do?x=back&firstIndex=1">【首页】</a> <a
							href="Documents.query.do?x=back&firstIndex=${page.page-1<=1?1:page.page- 1}">【上一页】</a>
						<a
							href="Documents.query.do?x=back&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}">【下一页】
						</a> <a href="Documents.query.do?x=back&firstIndex=${page.lastPage}">【末页】</a>
					</div>
				</td>
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
