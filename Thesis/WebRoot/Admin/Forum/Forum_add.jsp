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
<title>CaiGou添加</title>
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
	<form name="form1" action="" method="post">
		<input type="hidden" name="action" value="add" />
		<div class="place">
			<span>当前位置：</span>
			<ul class="placeul">
				<li><a href="#">论坛管理</a></li>
			</ul>
		</div>
		<!--中间部分开始-->
		<div class="formbody">
			<div class="formtitle">
				<span>公告发布</span>
			</div>
			<!--主体表单开始-->
			<!--大文本框样式为textinput,下拉框样式为select1,下拉框需用<div class="vocation"></div>包含-->
			<ul class="forminfo">
				<li><label> 公告标题: </label> <input type="text" id="LoginName"
					name="title" class="dfinput" /></li>
				<li><label> 公告图片: </label> <input type="text" id="GoodsFiles1"
					name="image" class="dfinput" /> <input type="button"
					id="uploadGoodsFiles1" value="上传" /> *必填 <script>
						KindEditor.ready(function(K) {
							var uploadbutton = K.uploadbutton({
								button : K('#uploadGoodsFiles1')[0],
								fieldName : 'imgFile',
								url : 'Admin/Admin/upload_json.jsp?dir=file',
								afterUpload : function(data) {
									if (data.error === 0) {
										var url = K.formatUrl(data.url,
												'absolute');
										K('#GoodsFiles1').val(url);
									} else {
										alert(data.message);
									}
								},
								afterError : function(str) {
									alert('自定义错误信息: ' + str);
								}
							});
							uploadbutton.fileBox.change(function(e) {
								uploadbutton.submit();
							});
						});
					</script></li>
				<li><label> 公告文件: </label> <input type="text" id="GoodsFiles"
					name="GoodsFiles" class="dfinput" /> <input type="button"
					id="uploadGoodsFiles" value="上传" /> <script>
						KindEditor.ready(function(K) {
							var uploadbutton = K.uploadbutton({
								button : K('#uploadGoodsFiles')[0],
								fieldName : 'imgFile',
								url : 'Admin/Admin/upload_json.jsp?dir=file',
								afterUpload : function(data) {
									if (data.error === 0) {
										var url = K.formatUrl(data.url,
												'absolute');
										K('#GoodsFiles').val(url);
									} else {
										alert(data.message);
									}
								},
								afterError : function(str) {
									alert('自定义错误信息: ' + str);
								}
							});
							uploadbutton.fileBox.change(function(e) {
								uploadbutton.submit();
							});
						});
					</script></li>

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
		</div>
		<!--中间结束-->
	</form>
</body>
</html>

