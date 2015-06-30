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
							class="STYLE4">论文送审::</span></td>
						<td width="23%" bgcolor="1D67DD"><span class="STYLE4">提示：非本人操作请自觉。</span>
						</td>
					</tr>
				</table>
				<table width="70%" align="center" border="0" bordercolor="#1D67DD"
					style="background-color:#F4F4F4"
					background="images/faceimges/whiteBg.png">
					<form action="Thesises_update.do?wd=j" method="post" onSubmit="tj_check(f)">
						<input type="hidden" name="t_id" value="${list[0].t_id }">
						<input type="hidden" name="verify_count" value="${list[0].verify_count + 1 }">
						<tr>
							<td><table width="100%" border="0">
									<tr>
										<td><table width="80%" border="1" cellspacing="0"
												bordercolor="#0000FF" align="center">
												<tr>
													<td height="30" colspan="2"><div align="center">
															<font size="5"><b>评审老师评审论文</b> </font>
														</div></td>
												</tr>
												<tr>
													<td width="372" height="27">学生</td>
													<td width="371">${list[0].u_name }</td>
												</tr>
												<tr>
													<td width="372" height="27">班级</td>
													<td width="371">${list[0].c_name }</td>
												</tr>
												<tr>
													<td height="28">文件名</td>
													<td><a
														href="user_file/Thesises/word.jsp?document=${list[0].document }&c=${entry.commit_status}">${list[0].t_name
															}</a></td>
												</tr>
												<tr>
													<td height="26">评审次数</td>
													<td>${list[0].verify_count }</td>
												</tr>
												<tr>
													<td height="31" colspan="2"><div align="center">评审老师评语</div>
													</td>
												</tr>
												<tr>
													<td height="290" colspan="2"><textarea name="comment"
															style="width:99%; height:99.5%; background:url(images/faceimges/whiteBg.png)"></textarea>
													</td>
												</tr>
												<tr>
													<td height="28">本次评审是否通过</td>
													<td><div align="center">
															<input type="radio" name="verify_status" value="1" />
															通过&nbsp;&nbsp; <input type="radio"
																name="verify_status" value="0" /> 不通过
														</div></td>
												</tr>
												<tr>
													<td height="28">是否退回</td>
													<td><div align="center">
															<input type="radio" name="commit_status" value="0" />
															是&nbsp;&nbsp; <input type="radio" name="commit_status"
																value="1" /> 否
														</div></td>
												</tr>
												<tr>
													<td height="30">
														<div align="center">
															<input type="submit" name="Submit2"
																style="width:50px; height:25px; color:#0000FF"
																value="提交" />
														</div></td>
													<td><div align="center">
															<input type="reset" name="reset"
																style="width:50px; height:25px; color:#0000FF"
																value="重置" />
														</div></td>
												</tr>
											</table></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
								</table></td>
						</tr>
					</form>
				</table>
			</td>
		</tr>
	</table>
	<br>
</body>
</html>
