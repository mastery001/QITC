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
<style type="text/css">
body {
	background-image: url(images/faceimges/whiteBg.png);
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
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table width="100%" height="617" border="0">
		<tr>
			<td height="100"><jsp:include page="/top.jsp" flush="true"></jsp:include></td>
		</tr>
		<tr>
			<td height="550">

				<table width="70%" height="26" border="0" align="center">
					<tr>
						<td width="78%" height="26" bgcolor="1D67DD" class="STYLE3">修改个人密保::</td>
						<td width="22%" bgcolor="1D67DD"><span class="STYLE3">提示：非本人操作请自觉。</span>
						</td>
					</tr>
				</table>
				<table width="70%" align="center" border="0" bordercolor="#1D67DD"
					style="background-color:#F4F4F4"
					background="images/faceimges/whiteBg.png">
					<tr>
						<td height="753"><table width="100%" height="723" border="0">
								<tr>
									<td colspan="2"><div align="center">
											<table border="0" width="50%">
												<tr>
													<td height="50"><div align="right" class="STYLE5">问题1：</div>
													</td>
													<td height="50" colspan="2"><select name="pspb1"
														class="form-control" id="p1">
															<option>您的工号是？</option>
															<option>您高中班主任的名字是？</option>
															<option>你最熟悉的高中好友的名字？</option>
													</select>
													</td>
												</tr>
												<tr>
													<td width="19%" height="50"><div align="right"
															class="STYLE5">回答：</div>
													</td>
													<td height="50" colspan="2"><input type="text"
														name="answer1"
														style="width:200px;color:#0000FF; height:25px">
													</td>
												</tr>
												<tr>
													<td height="50"><div align="right" class="STYLE5">问题2：</div>
													</td>
													<td height="50" colspan="2"><select name="pspb2"
														class="form-control" id="p2">
															<option>对您影响最大的人的名字？</option>
															<option>你最熟悉的学校宿舍好友的名字是？</option>
															<option>你的生日是？</option>
													</select>
													</td>
												</tr>
												<tr>
													<td height="50"><div align="right" class="STYLE5">回答：</div>
													</td>
													<td height="50" colspan="2"><input type="text"
														name="answer2"
														style="width:200px;color:#0000FF; height:25px">
													</td>
												</tr>
												<tr>
													<td height="50"><div align="right" class="STYLE5">问题3：</div>
													</td>
													<td height="50" colspan="2"><select name="pspb3"
														class="form-control" id="p3">
															<option>您配偶的姓名是？</option>
															<option>您父亲的姓名是？</option>
															<option>你的出生地？</option>
													</select>
													</td>
												</tr>
												<tr>
													<td height="50"><div align="right" class="STYLE5">回答：</div>
													</td>
													<td height="50" colspan="2"><input type="text"
														name="answer3"
														style="width:200px;color:#0000FF; height:25px">
													</td>
												</tr>
												<tr>
													<td height="50">&nbsp;</td>
													<td width="42%" height="50"><label></label>
													</td>
													<td width="39%">&nbsp;</td>
												</tr>
												<tr>
													<td height="50">&nbsp;</td>
													<td height="50"><label> <input type="submit"
															name="Submit2"
															style="height:40px; width:100px; color:#0000FF; font-size:20px; font-family: "
															楷体="楷体" "" value="保存" /> </label>
													</td>
													<td><input type="submit" name="Submit22"
														style="height:40px; width:100px;color:#0000FF; font-size:20px; font-family: "
														楷体="楷体" "" value="取消" />
													</td>
												</tr>
												<tr>
													<td height="136">&nbsp;</td>
													<td height="136" colspan="2">&nbsp;</td>
												</tr>
											</table>
											<br> <br>
										</div>
										<div id="Zones"></div> <label></label> <label></label> <label></label>
									</td>
								</tr>

							</table>
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
