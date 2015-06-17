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
</style>

</head>

<body>

	<table width="100%" border="0">
		<tr>
			<td height="100"><jsp:include page="/top.jsp" flush="true"></jsp:include></td>
		</tr>
		<tr>
			<td>
				<table width="70%" height="26" border="0" align="center">
					<tr>
						<td width="77%" height="26" bgcolor="1D67DD"><span
							class="STYLE4">论文送审::</span>
						</td>
						<td width="23%" bgcolor="1D67DD"><span class="STYLE4">提示：非本人操作请自觉。</span>
						</td>
					</tr>
				</table>
				<table width="70%" align="center" border="0" bordercolor="#1D67DD"
					style="background-color:#F4F4F4"
					background="images/faceimges/whiteBg.png">
					<tr>
						<td><table width="907" border="0">
								<tr>
									<td height="53"><div align="center">
											<a
												href="Thesises.query.do?isdelete=0&x=info&c_id=${user.c_id}&commit_status=1">全部论文</a>
										</div>
									</td>
									<td height="53"><div align="center">
											<a
												href="Thesises.query.do?isdelete=0&x=info&c_id=${user.c_id}&commit_status=1&verify_status=1">已通过评审论文</a>
										</div>
									</td>

									<td height="53"><div align="center">
											<a href="Thesises.query.do?isdelete=0&x=info&c_id=${user.c_id}&commit_status=1&verify_status=0">未评审通过论文</a>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="3"><table width="913"
											border="solid" align="right" cellpadding="2" cellspacing="0"
											bordercolor="#1D67DD">
											<tr>
												<td height="27" colspan="8"><div align="center"><font size="5"><b>论文信息</b></font></div>
												</td>
											</tr>
											<tr>
												<td height="20"><div align="center">学生</div>
												</td>
												<td><div align="center">班级</div>
												</td>
												<td><div align="center">文件名</div>
												</td>
												<td><div align="center">评审状态</div>
												</td>
												<td><div align="center">评审次数</div>
												</td>
												<td><div align="center">论文评审</div>
												</td>
											</tr>
											<c:forEach var="entry" items="${list }">
												<tr>
													<td height="33"><div align="center">${entry.c_name
															}</div>
													</td>
													<td><div align="center">${entry.c_name }</div>
													</td>
													<td><div align="center">
															<a
																href="user_file/Thesises/word.jsp?document=${entry.document }">${entry.t_name
																}</a>
														</div>
													</td>
													<td><div align="center">${entry.verify_status ==
															0 ? "未评审" : "已评审" }</div>
													</td>
													<td><div align="center">${entry.verify_count }</div>
													</td>
													<td><div align="center">
															<a href="Thesises.query.do?x=j&t_id=${entry.t_id }">前往评审</a>
														</div>
													</td>
													<%--<td><div align="center">
															<a
																href="user_file/Thesises/word.jsp?document=${entry.document }">查看论文</a>
														</div></td>
												--%>
												</tr>
											</c:forEach>
										</table>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<center>
											<a>共有${page.count}条记录 </a> <a>当前第${page.page}页 </a> <a
												href="Thesises.query.do?isdelete=0&x=info&c_id=${user.c_id}&commit_status=1&firstIndex=1"><span
												class="STYLE2">【首页】</span> </a> <a
												href="Thesises.query.do?isdelete=0&x=info&c_id=${user.c_id}&commit_status=1&firstIndex=${page.page-1<=1?1:page.page- 1}"><span
												class="STYLE2">【上一页】</span> </a> <a
												href="Thesises.query.do?isdelete=0&x=info&c_id=${user.c_id}&commit_status=1&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}"><span
												class="STYLE2">【下一页】 </span> </a> <a
												href="Thesises.query.do?isdelete=0&x=info&c_id=${user.c_id}&commit_status=1&firstIndex=${page.lastPage}"><span
												class="STYLE2">【末页】 </span> </a>
										</center></td>
								</tr>
							</table>
						</td>
				</table></td>
		</tr>
	</table>

</body>
</html>
