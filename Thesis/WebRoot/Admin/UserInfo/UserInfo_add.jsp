<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>管理员添加用户</title>
<link href="Admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="Admin/css/select.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="Admin/js/jquery.js"></script>
<script language="JavaScript" src="Admin/js/select-ui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
</script>
<script charset="utf-8" type="text/javascript" src="js/custom/error.js"></script>
<script type="text/javascript" src="js/custom/ajax.js"></script>
</head>
<body>
	<input type="hidden" id="msg" value="${info[0]}" />
	<div class="place">
		<span>当前位置：</span>
		<ul class="placeul">
			<li><a href="Admin/UserInfo/UserInfo_add.jsp">添加用户</a></li>
		</ul>
	</div>
	<!--中间部分开始-->
	<div class="formbody">
		<div class="formtitle">
			<span>系统用户添加</span>
		</div>
		<form name="form1" action="UserInfo_add.do?wd=back" method="post">
			<!--主体表单开始-->
			<!--大文本框样式为textinput,下拉框样式为select1,下拉框需用<div class="vocation"></div>包含-->
			<ul class="forminfo">
				<li><label> 登录名: </label> <input type="text" name="u_id"
					class="dfinput" /></li>
				<li><label> 用户名: </label> <input type="text" name="u_name"
					class="dfinput" /></li>
				<li><label> 性别: </label> <input type="radio" name="sex"
					value="男" checked="checked" /> 男 <input type="radio" name="sex"
					value="女" /> 女</li>

				<li style="margin-bottom: 10px; margin-top: -10px;"><label>
						身份设置: </label> <input type="radio" name="status" checked=true value="0" />
					学生 <input type="radio" name="status" value="1" /> 评审老师</li>

				<li><label> 班级: </label>
					<div class="vocation">
						<select name="c_id" class="select1" id="grade"></select>
					</div>
				</li>

				<script src="Admin/js/My97DatePicker/WdatePicker.js"
					type="text/javascript">
					
				</script>
				<li><label> &nbsp; </label> <input name="btnSubmit"
					type="submit" class="btn" value="提交" /></li>
			</ul>
		</form>
		<!--主体表单结束-->
	</div>
	<!--中间结束-->
	<script type="text/javascript">
		function showGrade() {
			var loader = new net.AjaxRequest("ajax.Grade.do?nocache="
					+ new Date().getTime(), deal, onerror, "GET");
		}

		function deal() {
			grade.innerHTML = this.req.responseText;
		}
		showGrade(); //当页面载入后显示班级信息
	</script>
</body>
</html>

