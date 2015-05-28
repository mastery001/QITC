<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
body {
	background-color: #000000;
}

.STYLE3 {
	color: #FFFFFF
}

.STYLE2 {
	color: #0000FF
}

.STYLE5 {
	color: #0000FF
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
						<td width="78%" height="26" bgcolor="1D67DD" class="STYLE3">修改个人密码::</td>
						<td width="22%" bgcolor="1D67DD"><span class="STYLE3">提示：非本人操作请自觉。</span>
						</td>
					</tr>
				</table>

				<table width="70%" align="center" border="0" bordercolor="#1D67DD"
					style="background-color:#F4F4F4"
					background="images/faceimges/whiteBg.png">
					<tr>
						<td><table width="100%" border="0">
								<tr>
									<td colspan="2"><div align="center">
											<form action="u.do?op=ps" method="post">
												<input type="hidden" name="u_id" value="${user.u_id }" />
												<table border="0" width="50%">
													<tr>
														<td height="50"><div align="right" class="STYLE5">原密码：</div>
														</td>
														<td height="50" colspan="2"><input type="password"
															name="oldPassword"
															style="width:200px;color:#0000FF; height:25px" /></td>
													</tr>
													<tr>
														<td width="19%" height="50"><div align="right"
																class="STYLE5">新密码：</div></td>
														<td height="50" colspan="2"><input type="password"
															name="newPassword"
															style="width:200px;color:#0000FF; height:25px"></td>
													</tr>
													<tr>
														<td height="50"><div align="right" class="STYLE5">确认密码：</div>
														</td>
														<td height="50" colspan="2"><input type="password"
															name="newPassword1"
															style="width:200px;color:#0000FF; height:25px"></td>
													</tr>
													<tr>
														<td height="30">&nbsp;</td>
														<td width="42%" height="30"><label></label></td>
														<td width="39%">&nbsp;</td>
													</tr>
													<tr>

														<td height="50"><label> <input type="submit"
																name="Submit2"
																style="height:40px; width:100px; color:#0000FF; font-size:20px; font-family: "
																楷体="楷体" "" value="保存" /> </label></td>
														<td align="right"><input type="submit"
															name="Submit22"
															style="height:40px; width:100px;color:#0000FF; font-size:20px; font-family: "
															楷体="楷体" "" value="取消" /></td>
														<td height="50">&nbsp;</td>
													</tr>
													<tr>
														<td height="136">&nbsp;</td>
														<td height="136" colspan="2">&nbsp;</td>
													</tr>
												</table>
											</form>
											<br> <br>
										</div>
										<div id="Zones"></div> <label></label> <label></label> <label></label>
									</td>
								</tr>

							</table></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
