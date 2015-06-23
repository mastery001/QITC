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

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.STYLE2 {
	color: #0000FF
}

.STYLE4 {
	color: #FFFFFF
}
</style>
<script type="text/javascript">
	function validate(f) {
		var tIds = document.getElementsByName("t_id");
		var count = 0;
		for ( var i = 0; i < tIds.length; i++) {
			if (tIds[i].checked == true) {
				count++;
			}
		}
		if (count > 1) {
			alert("每次只能提交一篇论文");
			return false;
		}
		return true;
	}
</script>
</head>

<body>

	<table width="100%" border="0">
		<tr>
			<td height="100"><jsp:include page="/top.jsp" flush="true"></jsp:include></td>
		</tr>
		<tr>
			<td>

				<table width="70%" height="26" border="0" align="center">
					<tr>
						<td width="77%" height="26" bgcolor="1D67DD"><span
							class="STYLE4">论文送审::</span></td>
						<td width="23%" bgcolor="1D67DD"><span class="STYLE4">提示：非本人操作请自觉。</span>
						</td>
					</tr>
				</table>
				<table width="70%" align="center" border="0" bordercolor="#1D67DD"
					style="background-color:#F4F4F4"
					background="images/faceimges/whiteBg.png">
					<tr>
						<td><table width="100%" border="0">
								<form action="Thesises_update.do?wd=commit" method="post"
									onSubmit="javascript:return validate()">
									<input type="hidden" name="commit_status" value="1" />
									<tr>
										<td><table width="100%" height="184" border="solid"
												align="right" cellpadding="2" cellspacing="0"
												bordercolor="#1D67DD">
												<tr>
													<td height="27" colspan="7"><div align="center">论文信息</div>
													</td>
												</tr>
												<tr>
													<td><div align="center">文件名</div></td>
													<td width="8%"><div align="center">送审状态</div></td>
													<td width="8%"><div align="center">送审次数</div></td>
													<td width="8%"><div align="center">是否送审</div></td>
													<td><div align="center">老师评语</div></td>
												</tr>
												<c:forEach var="entry" varStatus="st" items="${list}">
													<tr>
														<td><div align="center">
																<a
																	href="user_file/Thesises/word.jsp?document=${entry.document }">${entry.t_name
																	}</a>
															</div></td>
														<td><div align="center">${entry.commit_status
																== 0 ? "未送审" : "已送审" }</div></td>
														<td><div align="center">${entry.verify_count }</div>
														</td>
														<td><c:choose>
																<c:when
																	test="${entry.commit_status ==
															0}">
																	<div align="center">
																		<input type="checkbox" name="t_id"
																			value="${entry.t_id }" /> 是
																	</div>
																</c:when>
																<c:otherwise>
																	<div align="center">已送审</div>
																</c:otherwise>
															</c:choose></td>

														<c:if test="${entry.comment !=
															null}">
															<td>
																<div align="center">${entry.comment }
															</td>
														</c:if>

													</tr>
												</c:forEach>
											</table></td>
									</tr>
									<tr>
										<td height="46"><div align="center">
												<input type="submit" name="Submit2"
													style="height:40px; width:100px; color:#0000FF; font-size:20px; font-family: "
													楷体="楷体" "" value="提交" />
											</div></td>
									</tr>
									<tr>
										<td height="138">&nbsp;</td>
									</tr>
								</form>
							</table></td>
				</table>
			</td>
		</tr>
	</table>

	<br>
</body>
</html>
