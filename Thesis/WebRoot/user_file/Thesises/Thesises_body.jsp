<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<html>
<head>
<base href="<%=basePath%>">

<title>江西农业大学论文评审系统</title>

<style type="text/css">
.STYLE2 {
	color: #0000FF
}

.STYLE8 {
	color: #FFFFFF
}

body {
	background-image: url(images/faceimges/whiteBg.png);
	background-color: #000000;
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
						<td width="74%" height="26" bgcolor="1D67DD"><span
							class="STYLE8">回收站::</span>
						</td>
						<td width="26%" bgcolor="1D67DD"><span class="STYLE8">提示：文件保存10天后自动删除</span>
						</td>
					</tr>
				</table>

				<table width="70%" align="center" border="0" bordercolor="#1D67DD"
					style="background-color:#F4F4F4; background-image:url(images/faceimges/whiteBg.png)">
					<c:forEach var="entry" items="${list }">
						<tr>
							<td height="75" colspan="2"><div align="center">
									<table width="87%" height="40" border="0" align="center">
										<tr>
											<td width="6%" height="36" align="center"><input
												type="checkbox" name="t_id" value="${entry.t_id }" /></td>
											<td width="76%" bgcolor="#1D67DD"><span class="STYLE8">${entry.u_id
													}- ${entry.u_name } : ${entry.t_name }</span>
											</td>
											<td width="6%" align="center" bgcolor="#1D67DD"><span
												class="STYLE8">删除</span>
											</td>
											<td width="6%" align="center" bgcolor="#1D67DD"><a
												href="Thesises_update.do?t_id=${entry.t_id }&isdelete=0"><span
													class="STYLE8">还原</span> </a>
											</td>
											<td width="6%" align="center" bgcolor="#1D67DD"><span
												class="STYLE8">10天</span>
											</td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td width="50%" height="60" colspan="2"><center>
								<input type="button" value="全选" style="width:50px;height:30px" />
								<input type="button" value="删除" style="width:100px;height:30px" />
								<input type="button" value="还原" style="width:100px;height:30px" />
							</center></td>
					</tr>
					<tr>
						<td colspan="2"><center>
								<a>共有${page.count}条记录 </a> <a>当前第${page.page}页</a> <a
									href="Thesises.query.do?u_id=${user.u_id }&isdelete=1&x=ot&firstIndex=1"><span
									class="STYLE2">【首页】</span> </a> <a
									href="Thesises.query.do?u_id=${user.u_id }&isdelete=1&x=ot&firstIndex=${page.page-1<=1?1:page.page- 1}"><span
									class="STYLE2">【上一页】</span> </a> <a
									href="Thesises.query.do?u_id=${user.u_id }&isdelete=1&x=ot&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}"><span
									class="STYLE2">【下一页】</span> </a> <a
									href="Thesises.query.do?u_id=${user.u_id }&isdelete=1&x=ot&firstIndex=${page.lastPage}"><span
									class="STYLE2">【末页】</span> </a>
							</center>
						</td>
					</tr>
				</table></td>
		</tr>
	</table>

</body>
</html>
