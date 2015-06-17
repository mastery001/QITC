<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:forEach items="${list}" var="entry">
	<option value="${entry.c_id }">${entry.c_name }</option>
</c:forEach>
