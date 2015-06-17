<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
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
		<title>班级添加</title>
		<script src="Admin/js/myjs.js" type="text/javascript">
</script>
		<link href="Admin/css/style.css" rel="stylesheet" type="text/css" />
		<link href="Admin/css/select.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="Admin/js/jquery.js">
</script>
		<script src="Admin/js/select-ui.min.js" type="text/javascript">
</script>
</script>
		<script type="text/javascript">
$(document).ready(function(e) {
	$(".select1").uedSelect( {
		width : 345
	});
	$(".select2").uedSelect( {
		width : 167
	});
	$(".select3").uedSelect( {
		width : 100
	});
});
</script>
		<script type="text/javascript">
$('.tablelist tbody tr:odd').addClass('odd');
<script charset="utf-8" type="text/javascript" src="js/custom/error.js"></script>
</head>
<body>
	<input type="hidden" id="msg" value="${info[0]}" />
		<form name="form1" action="Grade_add.do?wd=back" method="post">
			<div class="place">
				<span>当前位置：</span>
				<ul class="placeul">
					<li>
						<a href="#">班级添加</a>
					</li>
				</ul>
			</div>
			<!--中间部分开始-->
			<div class="formbody">
				<div class="formtitle">
					<span>班级添加</span>
				</div>
				<!--主体表单开始-->
				<!--大文本框样式为textinput,下拉框样式为select1,下拉框需用<div class="vocation"></div>包含-->
				<ul class="forminfo">
					<li>
						<label>
							班级名称:
						</label>
						<input type="text" id="c_name" name="c_name" class="dfinput" />
					</li>
					<li>
						<label>
							班级专业:
						</label>
						<input type="text" id="major" name="major" class="dfinput" />
					</li>
					<script src="Admin/js/My97DatePicker/WdatePicker.js"
						type="text/javascript">
</script>
					<li>
						<label>
							&nbsp;
						</label>
						<input name="btnSubmit" type="submit" class="btn" value="提交" />
					</li>
				</ul>
				<!--主体表单结束-->
			</div>
			<!--中间结束-->
		</form>
	</body>
</html>

