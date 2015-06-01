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
.STYLE2 {
	color: #0000FF;
}

.STYLE3 {
	color: #0000FF
}

.STYLE4 {
	color: #FFFFFF
}

body {
	background-image: url(images/faceimges/whiteBg.png);
	background-color: #000000;
}
</style>

<link rel="stylesheet" href="js/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="js/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="js/kindeditor/lang/zh_CN.js"></script>

<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			allowFileManager : true
		});
	});
</script>
<title>My JSP 'BbsPost.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body style=" height:1000">
	<table width="100%" height="617" border="0">
		<tr>
			<td height="100"><jsp:include page="/top.jsp" flush="true"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="550">
				<table width="70%" height="26" border="0" align="center">
					<tr>
						<td width="63%" height="26" bgcolor="1D67DD"><span
							class="STYLE4">我的论帖/发帖::</span></td>
						<td width="37%" bgcolor="1D67DD"><span class="STYLE4">提示：本论坛严禁出现不良信息，请后斟酌发帖</span>
						</td>
					</tr>
				</table>
				<form action="Forum_add.do" method="post" enctype="multipart/form-data">
					<input type="hidden" name="u_id" value="${user.u_id }" />
					<input type="hidden" name="isleaf" value="1" />
					<table width="70%" align="center" border="0" bordercolor="#1D67DD"
						style="background-color:#F4F4F4"
						background="images/faceimges/whiteBg.png">
						<tr>
							<td height="753"><table width="100%" height="738" border="0">
									<tr>
										<td height="50" colspan="2"><br> <br> <br>
											<br> <label>
												<div align="center">
													<span class="STYLE3">标题：</span> <input type="text"
														name="title" style="width:200px; height:25px" />
												</div> </label></td>
									</tr>
									<tr>
										<td height="50" colspan="2"><br> <br>
											<div align="center">
												<span class="STYLE3">主题：</span> <input type="text"
													name="subject" style="width:200px; height:25px" />
											</div></td>
									</tr>
									<tr >
										<td height="172" colspan="2"><div id="Smohan_FaceBox" align="center">
												<div align="left"><span class="STYLE3">正文：</span></div> <br> <br>
												<textarea name="content" id="content" class="content"></textarea>
											</div>
											<div id="Zones"></div>
										</td>
									</tr>
									<tr>
										<td height="178" colspan="2"><div align="center">

												<div id="divPreview" align="center">
													<span class="STYLE2">请选择头像：</span> <img
														src="images/noperson.jpg" alt="" width="110" height="69"
														align="top" id="imgHeadPhoto"
														style="width: 160px; height: 170px; border: solid 1px #d2e2e2;" />
												</div>
												<p>
													<br />
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<input name="image" type="file"
														onchange="javascript:PreviewImage(this,'imgHeadPhoto','divPreview')"
														value="选择本地照片" size="20" />
												</p>
												<p>&nbsp;</p>
												<p>
													<input type="submit" name="Submit2"
														style="height:40px; width:100px; color:#0000FF;font-size:20px; font-family: "
														楷体"" value="发布" />
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
														type="submit" name="Submit"
														style="height:40px; width:100px; font-size:20px; color:#0000FF; font-family: "
														楷体"" value="取消" />
												</p>
											</div></td>
									</tr>
									</form>
									<tr>
										<td height="243" colspan="2"><label></label></td>
									</tr>
								</table></td>
						</tr>
					</table>
			</td>
		</tr>
	</table>
</body>
</html>
