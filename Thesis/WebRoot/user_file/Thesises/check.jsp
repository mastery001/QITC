<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${rate != null }">
		重复率为${rate }
	</c:when>
	<c:otherwise>
		正在查重中，请等待！请勿退出本页面！
	</c:otherwise>
</c:choose>

