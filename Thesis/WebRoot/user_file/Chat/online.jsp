<%@page import="edu.jxau.action.filter.LoginUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	request.setAttribute("users", LoginUser.getLoginUser());
	int amount = LoginUser.getCount();
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="23" align="center">所有人
		</td>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td height="23" align="center">${user.c_name}&nbsp;&nbsp;${user.u_name}
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td height="30" align="center">当前在线[<font color="#FF6600"><%=amount%></font>]人</td>
	</tr>
</table>