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
	background-image: url(images/faceimges/whiteBg.png);
	background-color: #000000;
}

.STYLE3 {
	color: #0000FF
}

.STYLE4 {
	color: #FFFFFF
}

.STYLE2 {
	color: #0000FF
}
</style>
<script type="text/javascript">
function showYear(sel) {
	if(sel.options.length <= 1) {
		for(var i = 0 ; i < sel.options.length ; i++) {
			sel.options.remove(i);
		}
		var year = 2006;
		for(var i = year ; i <= new Date().getFullYear() ; i ++) {
			sel.options.add(new Option("" + i));
		}
	}
}
</script>
</head>
<body>
	<table width="100%" height="617" border="0">
		<tr>
			<td height="100"><jsp:include page="/top.jsp" flush="true"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="550">
				<table width="70%" height="26" border="0" align="center">
					<tr>
						<td width="78%" height="26" bgcolor="1D67DD"><span
							class="STYLE4">我的个人信息::</span>
						</td>
						<td width="22%" bgcolor="1D67DD"><span class="STYLE4">提示：非本人操作请自觉。</span>
						</td>
					</tr>
				</table>
				<form action="" method="post" id="userForm">
					<table width="70%" align="center" border="0" bordercolor="#1D67DD"
						style="background-color:#F4F4F4"
						background="images/faceimges/whiteBg.png">
						<tr>
							<td height="753"><table width="100%" height="723" border="0">
									<tr>
										<td colspan="2"><div align="center">
												<table border="0" width="50%">
													<tr>
														<td width="19%" height="50"><div align="right">
																<span class="STYLE3">姓名</span>：
															</div>
														</td>
														<td height="50" colspan="2"><input readonly
															type="text" name="u_name"
															style="width:200px;color:#0000FF; height:25px" value="${list[0].u_name }" />
														</td>
													</tr>
													<tr>
														<td height="50"><div align="right" class="STYLE3">性别：</div>
														</td>
														<td height="50" colspan="2"><input type="radio"
															name="sex" value="男" /> <span class="STYLE3">男</span>
															&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="sex"
															value="女" /> <span class="STYLE3">女</span>
														</td>
													</tr>
													<tr>
														<td height="50"><div align="right" class="STYLE3">班级：</div>
														</td>
														<td height="50" colspan="2"><input readonly
															type="text" name="c_name"
															style="width:200px;color:#0000FF; height:25px"
															value="${list[0].c_name }" />
														</td>
													</tr>
													<tr>
														<td height="50"><div align="right" class="STYLE3">学号：</div>
														</td>
														<td height="50" colspan="2"><input readonly
															type="text" name="u_id"
															style="width:200px;   color:#0000FF; height:25px"
															value="${list[0].u_id }" />
														</td>
													</tr>
													<tr>
														<td height="50"><div align="right" class="STYLE3">身份：</div>
														</td>
														<td height="50" colspan="2"><input readonly
															type="text" name="statusName"
															style="width:200px; color:#0000FF; height:25px"
															value="${list[0].statusName }" />
														</td>
													</tr>
													<tr>
														<td height="50"><div align="right" class="STYLE3">指导老师：</div>
														</td>
														<td height="50" colspan="2"><input readonly
															type="text" name="teacher_name"
															style="width:200px; color:#0000FF; height:25px"
															value="${list[0].teacher_name }" />
														</td>
													</tr>
													<tr>
														<td height="50"><div align="right" class="STYLE3">入学年份：</div>
														</td>
														<td height="50" colspan="2"><select name="entrance_date"
															style="width:200px;  color:#0000FF; height:25px" onClick="javascript:showYear(this)">
														</select></td>
													</tr>
													<tr>
														<td height="50"><div align="right" class="STYLE3">联系电话：</div>
														</td>
														<td height="50" colspan="2"><input type="text"
															name="phone"
															style="width:200px; color:#0000FF; height:25px"
															value="${list[0].phone }" />
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
												</form>
												<br> <br>
											</div>
											<div id="Zones"></div> <label></label> <label></label> <label></label>
										</td>
									</tr>

								</table>
							</td>
						</tr>
					</table>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		var sex = "${list[0].sex}";
		var sexModule = document.getElementsByName("sex");
		for ( var i = 0; i < sexModule.length; i++) {
			if (sexModule[i].value == sex) {
				sexModule[i].checked = true;
				break;
			}
		}
		var entrance_date = "${list[0].entrance_date}";
		if(entrance_date != "") {
			var year = document.getElementById("entrance_date"); 
			for(var i = 0 ; i < year.options.length; i ++) {
				year.options.remove(i);
			}
			year.options.add(new Option(entrance_date));
		}
		
</script>
</body>
</html>
