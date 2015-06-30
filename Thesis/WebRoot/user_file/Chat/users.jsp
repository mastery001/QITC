<%@page import="edu.jxau.action.filter.LoginUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	request.setAttribute("users", LoginUser.getLoginUser());
%>
<c:forEach items="${users}" var="user">
	<option value="所有人">所有人</option>
	<option value="${user.u_id },${user.u_name}">${user.u_name }</option>
</c:forEach>