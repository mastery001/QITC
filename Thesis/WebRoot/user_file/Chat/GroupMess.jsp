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
body {
	background-image: url(images/faceimges/whiteBg.png);
	background-color: #000000;
}

.STYLE2 {
	color: #0000FF
}

.STYLE4 {
	color: #FFFFFF
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
<script language="javascript">
	window.setInterval("showContent();", 1000);
	window.setInterval("showOnline();", 1000);
	window.setInterval("showSelfContent();", 1000);
	//var sysBBS = "<span style='font-size:14px; line-height:30px;'>欢迎光临mastery聊天室，请遵守聊天室规则，不要使用不文明用语。</span><br><span style='line-height:22px;'>";
	//此处需要加?nocache="+new Date().getTime()，否则将出现在线人员列表不更新的情况
	function showOnline() {
		var loader = new net.AjaxRequest("user_file/Chat/online.jsp?nocache="
				+ new Date().getTime(), deal_online, onerror, "GET");
	}
	function showContent() {
		var loader1 = new net.AjaxRequest("message.do?nocache="
				+ new Date().getTime(), deal_content, onerror, "GET");
	}
	function showSelfContent() {
		var loader3 = new net.AjaxRequest("message.do?o=self&nocache="
				+ new Date().getTime(), deal_selfcontent, onerror, "GET");
	}

	function showUser() {
		var loader2 = new net.AjaxRequest("user_file/Chat/users.jsp?nocache="
				+ new Date().getTime(), deal_user, onerror, "GET");
	}

	function deal_user() {
		users.innerHTML = this.req.responseText;
	}

	function onerror() {
		/*alert("很抱歉，服务器出现错误，当前窗口将关闭！");
		window.opener = null;
		window.close();*/
	}
	function deal_online() {
		online.innerHTML = this.req.responseText;
	}
	function deal_selfcontent() {
		var returnValue = this.req.responseText; //获取Ajax处理页的返回值
		var h = returnValue.replace(/\s/g, ""); //去除字符串中的Unicode空白符
		if (h == "error") {
			//alert("您的账户已经过期，请重新登录！");
			Exit();
		} else {
			self_content.innerHTML = returnValue;
		}
	}

	function deal_content() {
		var returnValue = this.req.responseText; //获取Ajax处理页的返回值
		var h = returnValue.replace(/\s/g, ""); //去除字符串中的Unicode空白符
		if (h == "error") {
			//alert("您的账户已经过期，请重新登录！");
			Exit();
		} else {
			content.innerHTML = returnValue;
			//document.getElementById('content').scrollTop = document
			//		.getElementById('content').scrollHeight * 2; //当聊天信息超过一屏时，设置最先发送的聊天信息不显示
		}
	}

	window.onload = function() {
		showUser();
		showContent(); //当页面载入后显示聊天内容
		showSelfContent();
		showOnline(); //当页面载入后显示在线人员列表
	}

	window.onbeforeunload = function() { //当用户单击浏览器中的关闭按钮时执行退出操作
		if (event.clientY<0 && event.clientX>document.body.scrollWidth) {
			Exit(); //执行退出操作
		}
	}
</script>
<script language="javascript">
	function send() { //验证聊天信息并发送\
		if (form1.to.value == "") {
			alert("请选择聊天对象！");
			return false;
		}
		if (form1.content.value == "") {
			alert("发送信息不可以为空！");
			form1.content1.focus();
			return false;
		}
		if (form1.from.value == form1.to.value) {
			alert("错误！自己不能和自己私聊！");
			return false;
		}
		var params = "from=" + form1.from.value + "&f_name="
				+ form1.f_name.value + "&to=" + form1.to.value + "&content="
				+ form1.content.value;
		document.getElementById("txt_cont").value = "";
		var loader = new net.AjaxRequest("message.do", deal_send, onerror,
				"POST", params);

	}
	function deal_send() {
		content.innerHTML = sysBBS + this.req.responseText + "</span>";
	}
	function Exit() {
		window.location.href = "leave.jsp";
		alert("欢迎您下次光临！");
	}
</script>
<script language="javascript">
	function set(selectPerson) { //自动添加聊天对象
		if (selectPerson != "${username}") {
			form1.to.value = selectPerson;
		} else {
			alert("请重新选择聊天对象！");
		}
	}
</script>

</head>

<body style=" height:1000">
	<table width="100%" height="617" border="0">
		<tr>
			<td height="100"><jsp:include page="/top.jsp" flush="true"></jsp:include></td>
		</tr>
		<tr>
			<td height="550">
				<table width="70%" height="26" border="0" align="center">
					<tr>
						<td width="68%" height="26" bgcolor="1D67DD"><span
							class="STYLE4">Web聊天室::</span>
						</td>
						<td width="32%" bgcolor="1D67DD"><span class="STYLE4">提示：文明聊天从我做起，请自觉遵守。</span>
						</td>
					</tr>
				</table>
				<table width="70%" align="center" border="0" bordercolor="#1D67DD"
					style="background-color:#F4F4F4"
					background="images/faceimges/whiteBg.png">
					<tr>
						<td height="733"><table width="100%" height="735" border="0"
								cellpadding="1" cellspacing="0" bordercolor="#0000FF">
								<tr>
									<td colspan="3" rowspan="2">
										<div id="content"
											style="width:99%; height:99.5%; overflow:auto; border:1px solid #000000;">
										</div> <%--<textarea overflow-x="auto" overflow-x="auto" readonly
											name="textarea" id="content"
											style="width:99%; height:99.5%; background:url(images/faceimges/whiteBg.png)"> </textarea>
									--%>
									</td>
									<td height="46"><img src="images/21.jpg" width="100%"
										height="48" />
									</td>
								</tr>
								<tr>
									<td rowspan="3" id="online"></td>
								</tr>
								<tr>
									<td width="126" height="41"><img src="images/321.jpg"
										width="100%" height="43" />
									</td>
									<td width="247">&nbsp;</td>
									<td width="181">&nbsp;</td>
								</tr>
								<tr>
									<td height="143" colspan="3">
										<div id="self_content"
											style="width:99%; height:99.5%; overflow:auto; border:1px solid #000000;">
										</div>
								</tr>
								<form name="form1" action="" method="post">
									<input name="f_name" type="hidden"
										value="${sessionScope.user.u_name}"> <input
										name="from" type="hidden" value="${sessionScope.user.u_id}">
									<tr>
										<td height="34" colspan="4"><select name="to" id="users"
											onmousedown="showUser();"
											style=" width:120px;height:100%; color:#0000FF">
										</select> &nbsp;&nbsp;&nbsp;&nbsp; <label> <input
												type="checkbox" name="checkbox" value="checkbox" /> <span
												class="STYLE3">私密会话 </span> </label>
										</td>
									</tr>
									<tr>
										<td height="30" colspan="3"><textarea name="content"
												id="txt_cont" style=" width:100%"></textarea>
										</td>
										<td width="186"><img src="images/32.jpg" width="185"
											height="57" onClick="send()" />
										</td>
									</tr>
								</form>
							</table>
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
