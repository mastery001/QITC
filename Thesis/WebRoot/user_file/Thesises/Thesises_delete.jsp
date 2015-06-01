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

.STYLE1 {
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
						<td width="62%" height="26" bgcolor="1D67DD"><span
							class="STYLE1">论文操作::</span>
						</td>
						<td width="38%" bgcolor="1D67DD"><span class="STYLE1">提示：本系统禁止以任何形式转载论文。</span>
						</td>
					</tr>
				</table>
				<table width="70%" align="center" border="0" bordercolor="#1D67DD"
					style="background-color:#F4F4F4">
					<tr>
						<td><table width="100%" border="0">
								<c:forEach var="entry" items="${list}">
									<tr>
										<td><div align="center">
												<table width="100%" height="40" border="0" align="center">
													<tr>
														<td width="6%" height="36" align="center"><input
															type="checkbox" name="checkbox854" value="checkbox" />
														</td>
														<td width="76%" bgcolor="#1D67DD"><span
															class="STYLE1">${entry.t_name }</span>
														</td>
														<td width="6%" align="center" bgcolor="#1D67DD"><a
															href="Thesises_delete.do?t_id=${entry.t_id }"><span
																class="STYLE1">删除</span> </a>
														</td>
														<td width="6%" align="center" bgcolor="#1D67DD"><a
															href="download.do?document=${entry.document }"><span
															class="STYLE1">下载</span></a>
														</td>
														<td width="6%" align="center" bgcolor="#1D67DD"><span
															class="STYLE1">编辑</span>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
								</c:forEach>
								<tr>
									<td width="50%" height="60" colspan="2"><center>
											<input type="button" value="全选"
												style="width:50px;height:30px" /> <input type="button"
												value="删除" style="width:100px;height:30px" /> <input
												type="button" value="还原" style="width:100px;height:30px" />
										</center></td>
								</tr>
								<tr>
									<td height="75"><center>
											<a>共有${page.count}条记录 </a> <a>当前第${page.page}页 </a> <a
												href="Thesises.query.do?isdelete=0&x=rm&u_id=${user.u_id }&firstIndex=1"><span
												class="STYLE2">【首页】</span> </a> <a
												href="Thesises.query.do?isdelete=0&x=rm&u_id=${user.u_id }&firstIndex=${page.page-1<=1?1:page.page- 1}"><span
												class="STYLE2">【上一页】</span> </a> <a
												href="Thesises.query.do?isdelete=0&x=rm&u_id=${user.u_id }&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}"><span
												class="STYLE2">【下一页】 </span> </a> <a
												href="Thesises.query.do?isdelete=0&x=rm&u_id=${user.u_id }&firstIndex=${page.lastPage}"><span
												class="STYLE2">【末页】 </span> </a>
										</center>
									</td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
