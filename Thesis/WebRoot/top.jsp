<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/wordchek.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/letguide.js"></script>
<script type='text/javascript' src='js/dropdown.js'></script>
<script type="text/javascript" src="js/bbs/GG.js"></script>
<link rel="stylesheet" type="text/css" href="css/bbs/GgCss.css">
<link rel="stylesheet" type="text/css" href="css/css.css">
<link href="css/facecss/smohan.face.css" type="text/css"
	rel="stylesheet">
<script src="js/jquery-1.6.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/flord.css">
<script charset="utf-8" type="text/javascript" src="js/newflord.js"></script>
<script charset="utf-8" type="text/javascript" src="js/Rightmenu.js"></script>
<script charset="utf-8" type="text/javascript" src="js/custom/error.js"></script>
<script charset="utf-8" type="text/javascript" src="js/custom/check.js"></script>
<script charset="utf-8" type="text/javascript" src="js/custom/public_check.js"></script>
<script charset="utf-8" type="text/javascript" src="js/border/front_check.js"></script>
</head>
<body>
	<input type="hidden" id="msg" value="${info[0]}" />
	<div id="header">
		<div align="center" style="background-color:#F4F4F4">
			<img src="images/login_log3.png" width="694" height="65"
				align="absbottom" />
		</div>
	</div>
	<div id="topmenu">
		<div id="navMenu">
			<ul>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li class="line"></li>
				<li><a href="index.jsp">&nbsp;&nbsp;主页&nbsp;&nbsp;</a>
				</li>
				<li class="line"></li>
				<c:choose>
					<c:when test="${user.status == 0 }">
						<li><a href="Thesises.query.do?u_id=${user.u_id }&isdelete=0"
							rel='dropmenu1' target="_parent">&nbsp;&nbsp;论文管理&nbsp;&nbsp;</a>
						</li>
					</c:when>
					<%-- 如果是老师--%>
					<c:otherwise>
						<li><a
							href="Thesises.query.do?isdelete=0&c_id=${user.c_id}&commit_status=1"
							rel='dropmenu1' target="_parent">&nbsp;&nbsp;论文管理&nbsp;&nbsp;</a>
						</li>
					</c:otherwise>
				</c:choose>
				<li class="line"></li>
				<li><a href="Forum.query.do?isleaf=0" rel='dropmenu2'
					target="_parent">&nbsp;&nbsp;论坛&nbsp;&nbsp;</a>
				</li>
				<li class="line"></li>
				<li><a href="UserInfo.query.do?u_id=${user.u_id }"
					rel='dropmenu3' target="_parent">&nbsp;&nbsp;个人信息&nbsp;&nbsp;</a>
				</li>
				<li class="line"></li>
				<li><a href="<%=path%>/user_file/Chat/GroupMess.jsp"
					rel='dropmenu4' target="_parent">&nbsp;聊天室&nbsp;</a>
				</li>
				<li class="line"></li>
				<c:choose>
					<%--	如果是学生	--%>
					<c:when test="${user.status == 0 }">
						<li><a
							href="Thesises.query.do?u_id=${user.u_id }&isdelete=1&x=ot"
							target="_parent">&nbsp;&nbsp;回收站&nbsp;&nbsp;</a>
						</li>
					</c:when>
					<%-- 如果是老师--%>
					<c:otherwise>
						<li><a
							href="Thesises.query.do?c_id=${user.c_id }&isdelete=1&x=ot&commit_status=1"
							target="_parent">&nbsp;&nbsp;回收站&nbsp;&nbsp;</a>
						</li>
					</c:otherwise>
				</c:choose>

				<li class="line"></li>
				<li class="right"></li>
			</ul>
		</div>
	</div>

	<script type="text/javascript">
		cssdropdown.startchrome("navMenu")
	</script>

	<ul id="dropmenu1" class="dropMenu">
		<c:choose>
			<%--	如果是学生	--%>
			<c:when test="${user.status == 0 }">
				<li><a href="Thesises.query.do?u_id=${user.u_id }&isdelete=0"
					target="_parent">论文查看</a>
				</li>
				<li><a
					href="Thesises.query.do?isdelete=0&x=rm&u_id=${user.u_id }"
					target="_parent">论文操作</a>
				</li>
				<li><a href="<%=path%>/user_file/Thesises/Thesises_add.jsp"
					target="_parent">论文上传</a>
				</li>
				<!--<li><a  href="" target="_parent">论文在线编辑</a></li>-->
				<li><a
					href="Thesises.query.do?isdelete=0&x=cm&u_id=${user.u_id }"
					target="_parent">论文送审</a>
				</li>
			</c:when>
			<%-- 如果是老师--%>
			<c:otherwise>
				<li><a
					href="Thesises.query.do?isdelete=0&c_id=${user.c_id}&commit_status=1"
					target="_parent">论文查看</a>
				</li>
				<li><a
					href="Thesises.query.do?isdelete=0&x=rm&c_id=${user.c_id}&commit_status=1"
					target="_parent">论文操作</a>
				</li>
				<li><a href="Thesises.query.do?isdelete=0&x=info&c_id=${user.c_id}&commit_status=1"
					target="_parent">论文信息</a>
				</li>
			</c:otherwise>
		</c:choose>

	</ul>
	<ul id="dropmenu2" class="dropMenu">
		<li><a href="Forum.query.do?isleaf=0" target="_parent">查看论帖</a>
		</li>
		<li><a href="<%=path%>/user_file/Forum/Forum_add.jsp"
			target="_parent">发帖</a>
		</li>
		<li><a href="Forum.query.do?isleaf=0&x=rm&u_id=${user.u_id }"
			target="_parent">删帖</a>
		</li>
	</ul>
	<ul id="dropmenu3" class="dropMenu">
		<li><a href="UserInfo.query.do?u_id=${user.u_id }"
			target="_parent">个人信息维护</a>
		</li>
		<li><a href="u.do?op=pp&s=x&u_id=${user.u_id }" target="_parent">密保重设</a>
		</li>
		<li><a href="<%=path%>/user_file/UserInfo/PassWordInsert.jsp"
			target="_parent">密码重设</a>
		</li>
	</ul>
	<ul id="dropmenu4" class="dropMenu">
		<li><a href="<%=path%>/user_file/Chat/GroupMess.jsp"
			target="_parent">群消息查看</a>
		</li>
		<li><a href="<%=path%>/user_file/Chat/PrivateMess.jsp"
			target="_parent">个人消息</a>
		</li>
	</ul>

	<div id="Layer1">
		<table width="192" height="281" border="1" cellpadding="1"
			cellspacing="1" bordercolor="#1D67DD"
			style="background-color:#F4F4F4">
			<tr>
				<td width="166"><table width="153" height="284" border="0">
						<tr>
							<td width="154" height="41"><span class="STYLE2">欢迎回来，${user.u_name
									}</span>
							</td>
						</tr>
						<tr>
							<td height="30"><span class="STYLE2">学号：${user.u_id }</span>
							</td>
						</tr>
						<tr>
							<td height="30"><span class="STYLE2">身份：${user.statusName
									}</span>
							</td>
						</tr>
						<tr>
							<td height="34"><span class="STYLE2">班级：${user.c_name
									}</span>
							</td>
						</tr>
						<c:if test="${user.status == 0 }">
							<tr>
								<td height="32"><span class="STYLE2">指导老师：${user.teacher_name}</span>
								</td>
							</tr>
						</c:if>
						<tr>
							<td height="56"><div align="right">
									<form action="cancel.jsp" method="post">
										<input type="submit" name="Submit"
											style="width:50px; height:25px; color:#0000FF" value="注销" />
								</div>
								</form></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<div id="leftsead">
		<ul>
			<li><a id="top_btn"><img src="images/foot03/ll06.png"
					width="131" height="49" class="hides" /><img
					src="images/foot03/l06.png" width="47" height="49" class="shows" />
			</a>
			</li>
		</ul>
	</div>

</body>
</html>
