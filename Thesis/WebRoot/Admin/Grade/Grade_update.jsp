<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.myProject.JingJia.util.*,java.text.*"%>
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
<title>CaiGou编辑页面</title>
<script src="Admin/js/myjs.js" type="text/javascript">
	
</script>
<link href="Admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="Admin/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="Admin/js/jquery.js">
	
</script>
<script src="Admin/js/select-ui.min.js" type="text/javascript">
	
</script>
<link rel="stylesheet"
	href="Admin/Admin/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="Admin./Admin/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="Admin/Admin/kindeditor/kindeditor.js">
	
</script>
<script charset="utf-8" src="Admin/Admin/kindeditor/lang/zh_CN.js">
	
</script>
<script charset="utf-8"
	src="Admin./Admin/kindeditor/plugins/code/prettify.js">
	
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
</head>
<body>
	<div class="place">
		<span>当前位置：</span>
		<ul class="placeul">
			<li><a href="#">班级信息编辑</a></li>
		</ul>
	</div>
	<!--中间部分开始-->
	<div class="formbody">
		<div class="formtitle">
			<span>班级信息编辑</span>
		</div>
		<form name="form1" action="Grade_update.do?wd=back" method="post">
			<input type="hidden" name="c_id" value="${list[0].c_id }" />
			<!--主体表单开始-->
			<!--大文本框样式为textinput,下拉框样式为select1,下拉框需用<div class="vocation"></div>包含-->
			<ul class="forminfo">
				<li><label> 班级名称: </label> <input type="text" id="c_name"
					name="c_name" class="dfinput" value="${list[0].c_name }" /></li>
				<li><label> 班级专业: </label> <input type="text" id="major"
					name="major" class="dfinput" value="${list[0].major }" /></li>
				<script src="Admin/js/My97DatePicker/WdatePicker.js"
					type="text/javascript">
					
				</script>
				<script type="text/javascript">
					function checkForm() {
						document.forms[0].submit();
					}
				</script>
				<li><label> &nbsp; </label> <input name="btnSubmit"
					type="button" class="btn" value="提交" onclick="checkForm();" /></li>
			</ul>
			<!--主体表单结束-->
		</form>
	</div>
	<!--中间结束-->

</body>
</html>



