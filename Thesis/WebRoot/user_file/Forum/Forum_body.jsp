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
<style type="text/css">
.STYLE2 {
	color: #0000FF;
}

.STYLE3 {
	color: #0000FF
}

.STYLE4 {
	color: #FFFFFF
}
</style>
<title>My JSP 'Bbsndex.jsp' starting page</title>


</head>

<body style=" height:1000">
	<table width="100%" height="" border="0">
		<tr>
			<td height="100"><jsp:include page="/top.jsp" flush="true"></jsp:include>
			</td>
		</tr>
	</table>
	<table width="70%" height="26" border="1" align="center">
		<tr>
			<td width="61%" height="26" bgcolor="1D67DD"><span
				class="STYLE4">论坛::</span>
			</td>
			<td width="39%" bgcolor="1D67DD"><span class="STYLE4">提示：本论坛严禁出现不良信息，请后斟酌发帖。</span>
			</td>
		</tr>
	</table>

	<table width="70%" align="center" border="0"
		style="background-image:url(images/faceimges/whiteBg.png)">
		<c:forEach var="entry" items="${list}">
			<tr>
				<td height="230" colspan="2"><table width="100%" height="238"
						border="1" cellpadding="1" cellspacing="1" bordercolor="#3366FF">
						<tr>
							<td width="115" height="103" rowspan="2"><img
								src="${entry.image }" width="149" height="146" /></td>
							<td height="38"><font color="#f00">标题：</font><span
								class="STYLE14">${entry.title }</span>
							</td>
							<td height="38" width="230px"><font color="#f00">时间：</font><span
								class="STYLE14"><fmt:formatDate
										pattern="yyyy-MM-dd HH:mm:ss" value="${entry.time}"
										type="both" /> </span>
							</td>
						</tr>
						<tr>
							<td colspan="2" rowspan="3" bordercolor="#0000FF"><p
									align="left" class="STYLE11">${entry.content }
							</td>
						</tr>
						<tr>
							<td height="26"><div align="center" class="STYLE12">姓名:${entry.u_name
									}</div>
							</td>
						</tr>
						<tr>
							<td height="18"><div align="center" class="STYLE12">班级：${entry.c_name
									}</div>
							</td>
						</tr>
						<tr>
							<td height="36"><div align="center" class="STYLE12">性别：${entry.sex
									}</div>
							</td>
							<td width="354" colspan="2"><div align="center"
									class="STYLE12">
									<a href="user_file/Forum/Forum_add.jsp?reply=1&&t=${entry.title }&pi=${entry.p_id}">评论</a>
								</div></td>
						</tr>
					</table>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td height="67" colspan="2"><div align="center" class="STYLE2">
					<a>共有${page.count}条记录</a> <a>当前第${page.page}页</a> <a
						href="Forum.query.do?p_id=${list[0].p_id }&x=ot&firstIndex=1"><span
						class="STYLE2">【首页】</span> </a> <a
						href="Forum.query.do?p_id=${list[0].p_id }&x=ot&firstIndex=${page.page-1<=1?1:page.page- 1}"><span
						class="STYLE2">【上一页】</span> </a> <a
						href="Forum.query.do?p_id=${list[0].p_id }&x=ot&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}"><span
						class="STYLE2">【下一页】 </span> </a> <a
						href="Forum.query.do?p_id=${list[0].p_id }&x=ot&firstIndex=${page.lastPage}"><span
						class="STYLE2">【末页】 </span> </a>
				</div>
			</td>
		</tr>
	</table>
	</td>
	</tr>
	</table>
</body>
</html>
