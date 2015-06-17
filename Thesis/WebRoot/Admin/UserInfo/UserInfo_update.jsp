<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=GBK" pageEncoding="utf-8"%>
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
<title>Admin添加</title>
<script src="Admin/js/myjs.js" type="text/javascript">
	
</script>
<link href="Admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="Admin/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="Admin/js/jquery.js">
	
</script>
<script src="Admin/js/select-ui.min.js" type="text/javascript">
	
</script>

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

<script type="text/javascript" src="js/custom/ajax.js"></script>
<script type="text/javascript">
	function showGrade() {
		var loader = new net.AjaxRequest("ajax.Grade.do?nocache="
				+ new Date().getTime(), deal, onerror, "GET");
	}

	function deal() {
		grade.innerHTML = this.req.responseText;
	}
</script>
</head>
<body>
	<form name="form1" action="UserInfo_update.do?wd=back" method="post">
		<div class="place">
			<span>当前位置：</span>
			<ul class="placeul">
				<li><a href="#">修改用户</a></li>
			</ul>
		</div>
		<div class="formbody">
			<div class="formtitle">
				<span>系统用户添加</span>
			</div>
			<!--主体表单开始-->
			<!--大文本框样式为textinput,下拉框样式为select1,下拉框需用<div class="vocation"></div>包含-->
			<ul class="forminfo">
				<li><label> 登录名: </label> <input type="text" id="u_id"
					name="u_id" class="dfinput" value="${list[0].u_id}" /></li>
				<li><label> 用户名: </label> <input type="text" name="u_name"
					value="${list[0].u_name}" class="dfinput" /></li>
				<li><label> 性别: </label> <input type="radio" name="sex"
					value="难" checked="checked" /> 男 <input type="radio" name="sex"
					value="女" /> 女</li>
				<li style="margin-bottom: 10px; margin-top: -10px;"><label>
						身份设置: </label><input type="radio" name="status" value="0" /> 学生<input
					type="radio" name="status" value="1" /> 评审老师</li>

				<li><label> 班级: </label>
					<div class="vocation">
						<select name="c_id" class="select1" id="grade"
							onClick="javascript:showGrade()"></select>
					</div></li>
				<script src="Admin/js/My97DatePicker/WdatePicker.js"
					type="text/javascript">
					
				</script>
				<li><label> &nbsp; </label> <input name="btnSubmit"
					type="submit" class="btn" value="提交" /></li>
			</ul>
			<!--主体表单结束-->
		</div>
		<!--中间结束-->
		<!--中间结束-->
	</form>
	<script src="js/custom/help.js" type="text/javascript"></script>
	<script type="text/javascript">
		correctRadio("sex", "${list[0].sex}");
		correctRadio("status", "${list[0].status}");

		var selectModule = document.getElementsByName("c_id")[0];
		selectModule.options.add(new Option("${list[0].c_name}",
				"${list[0].c_id}"));
		selectModule.options[0].selected = true;
	</script>
</body>
</html>

