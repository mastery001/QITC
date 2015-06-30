<%@page import="edu.jxau.vo.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%@ page
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*;"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	request.setAttribute("goto", request.getParameter("go"));
	request.setAttribute("c", request.getParameter("c"));
	//******************************卓正PageOffice组件的使用*******************************
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage(request.getContextPath() + "/poserver.zz"); //此行必须
	WordDocument doc = new WordDocument();
	//添加水印 ，设置水印的内容
	//doc.getWaterMark().setText("word查看工具");
	poCtrl1.setSaveFilePage("saveFile.jsp?c=" + request.getParameter("c"));//如要保存文件，此行必须
	poCtrl1.addCustomToolButton("保存", "Save()", 1);//添加自定义工具栏按钮
	//打开文件，webOpen()方法中的三个参数分别为：要打开的文件路径、打开模式、打开的操作人，其中文件路径既可是相对路径也可是绝对路径 
	poCtrl1.setWriter(doc);
	String u_name = "";
	UserInfo ui = (UserInfo) session.getAttribute("user");
	if (ui != null) {
		u_name = ui.getU_name();
	}
	//设置打开方式
	poCtrl1.webOpen("../../" + request.getParameter("document"),
			OpenModeType.docNormalEdit, u_name);
	poCtrl1.setTagId("word"); //此行必须
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>论文查看</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function Save() {
		var status = "${sessionScope.user.status}";
		var c = "${requestScope.c}";
		if(status == 0 && c == 1) {
			alert("该论文已经提交至审核！老师尚未退回！不能修改！");
			return false;
		}else {
			document.getElementById("word").WebSave();
		}
	}
</script>
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
						<td width="65%" height="10" bgcolor="1D67DD" class="STYLE4">论文查看::</td>
						<td width="35%" bgcolor="1D67DD" class="STYLE4">提示：本系统禁止以任何形式转载论文。</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<div style="width:70%;margin-left:200px" align="left">
		<input type="hidden" name="doc" value="<%=request.getParameter("document") %>" />
		<br> <a href="#"><font color="blue" size="3">返回</font>
		 </a><b>友情提示：不支持chrome浏览器！安装pageoffice注册序列号为：QZ4LF-W74G-4MZZ-3Y769</b> <br> <br>
		<po:PageOfficeCtrl id="word" />
	</div>
	<!--**************   卓正 PageOffice组件 ************************-->

</body>
</html>
