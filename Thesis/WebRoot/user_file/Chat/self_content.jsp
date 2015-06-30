<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:forEach items="${message}" var="msg">
	<c:if test="${msg.from == user.u_id || msg.to == user.u_id }">
		<font color="blue"> <strong>${msg.f_name}</strong>
	</font>对
		<font color="green">[${msg.to_name}]</font>说："
		<font color="red">${msg.content}"</font>
		（ <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
		value="${msg.sendTime}" type="both" />）<br>
	</c:if>
</c:forEach>
