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

<title>江西农业大学论文评审系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.STYLE2 {
	color: #0000FF
}

.STYLE4 {
	color: #FFFFFF
}
</style>
</head>

<body>
	<table width="100%" border="0">
		<tr>
			<td height="100"><jsp:include page="/top.jsp" flush="true"></jsp:include>
			</td>
		</tr>
		<tr>
			<td>
				<table width="70%" height="26" border="0" align="center">
					<tr>
						<td width="68%" height="10" bgcolor="1D67DD" class="STYLE4">论文查看::</td>
						<td width="32%" bgcolor="1D67DD" class="STYLE4">提示：本系统禁止以任何形式转载论文。</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table width="70%" border="0" align="center"
		style="background-color:#F4F4F4; background-image:url(images/faceimges/whiteBg.png)">
		<c:forEach var="entry" items="${list}">
			<tr>
				<td>
					<table width="33%" border="1" align="left" cellpadding="1"
						cellspacing="1">
						<tr>
							<td width="56%" rowspan="4"><img src="images/lunwen.jpg"
								alt="" width="149" height="165" />
							</td>
							<td width="44%" height="35" align="center"><span
								class="STYLE2">${entry.u_name }</span></td>
						</tr>
						<tr>
							<td height="35" align="center"><span class="STYLE2">${entry.c_name
									}</span></td>
						</tr>
						<tr>
							<td height="40" align="center"><span class="STYLE2">${entry.major
									}</span></td>
						</tr>
						<tr>
							<td height="47" align="center"><span class="STYLE2">${entry.u_id
									}</span></td>
						</tr>
						<tr>
							<td height="54" colspan="2" align="center"><span
								class="STYLE2">${entry.t_name }</span></td>
						</tr>
					</table></td>
			</tr>
		</c:forEach>
		<tr>
			<td height="66" colspan="3"><center>
					<a>共有${page.count}条记录
					</a> <a>当前第${page.page}页
					</a> <a
						href="Thesises.query.do?u_id=${user.u_id }&isdelete=0&firstIndex=1"><span
						class="STYLE2">【首页】</span>
					</a> <a
						href="Thesises.query.do?u_id=${user.u_id }&isdelete=0&firstIndex=${page.page-1<=1?1:page.page- 1}"><span
						class="STYLE2">【上一页】</span>
					</a> <a
						href="Thesises.query.do?u_id=${user.u_id }&isdelete=0&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}"><span
						class="STYLE2">【下一页】</span>
					</a> <a
						href="Thesises.query.do?u_id=${user.u_id }&isdelete=0&firstIndex=${page.lastPage}"><span
						class="STYLE2">【末页】</span>
					</a>
				</center></td>
		</tr>
		<tr>
			<td height="53" colspan="3">&nbsp;</td>
		</tr>
	</table>

	<div id="mask"></div>
	<div id="myMenu">
		<ul>
			<li><a href="学生_论文查看.html">打开</a></li>
			<li><a href="学生_论文下载.html">下载</a></li>
			<li><a onclick='Mouse_KeyDown()'>删除</a></li>
			<li onclick="textFoucus()">重命名</li>
		</ul>
	</div>
</body>
</html>
