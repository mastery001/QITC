<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>江西农业大学论文评审系统</title>
<style type="text/css">
.STYLE2 {
	color: #0000FF;
}

.STYLE3 {
	color: #0000FF
}

.STYLE4 {
	color: #FFFFFF
}
</style>
<title>My JSP 'Bbsndex.jsp' starting page</title>


</head>

<body style=" height:1000">
	<table width="100%" height="" border="0">
		<tr>
			<td height="100"><jsp:include page="/top.jsp" flush="true"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="550">
				<table width="70%" height="26" border="0" align="center">
					<tr>
						<td width="61%" height="26" bgcolor="1D67DD"><span
							class="STYLE4">论坛::</span>
						</td>
						<td width="39%" bgcolor="1D67DD"><span class="STYLE4">提示：本论坛严禁出现不良信息，请后斟酌发帖。</span>
						</td>
					</tr>
				</table>
				<table width="70%" align="center" border="0"
					style=" background-image:url(images/faceimges/whiteBg.png)">
					<tr>
						<td height="837">

							<table width="100%" height="1404" align="right">
								<tr>
									<td height="256" colspan="2"><table width="899"
											height="282" border="0">
											<tr>
												<td width="549" height="20" rowspan="5">
													<div id="bannerBox">
														<div id="bannerImgesBox">
															<a style="z-index:7; display:block;"><img
																src="images/lunwen/132Q00592O0-155T.jpg" width="585"
																height="453">
															</a><a href="http://www.duice.net/html/list_624.html"
																target="_parent"><img
																src="images/lunwen/20100523122942532.jpg" width="585"
																height="453">
															</a> <a href="http://www.duice.net/html/list_624.html"
																target="_parent"><img
																src="images/lunwen/20090421215256-1984479794.jpg"
																height="453">
															</a> <a href="http://www.duice.net/html/list_624.html"
																target="_parent"><img
																src="images/lunwen/Img378564923.jpg" height="453">
															</a> <a href="http://www.duice.net/html/list_624.html"
																target="_parent"><img
																src="images/lunwen/132Q00113960-5P58.jpg" width="585"
																height="453">
															</a> <a href="http://www.duice.net/html/list_624.html"
																target="_parent"><img
																src="images/lunwen/20090421215256-1984479794.jpg"
																height="453">
															</a> <a href="http://www.duice.net/html/list_624.html"
																target="_parent"><img
																src="images/lunwen/Img378564923.jpg" height="453">
															</a>
														</div>

														<div id="bannerTextBox">
															<ul>
																<li class="thisHover" set="0"><a href="#">1</a>
																</li>
																<li set="1"><a href="#">2</a>
																</li>
																<li set="2"><a href="#">3</a>
																</li>
																<li set="3"><a href="#">4</a>
																</li>
																<li set="4"><a href="#">5</a>
																</li>
																<li set="5"><a href="#">6</a>
																</li>
																<li set="6"><a href="#">7</a>
																</li>
															</ul>
														</div>
													</div></td>
												<td width="334" height="45"><span class="STYLE6">企业招聘热门个人简历封面一</span>
												</td>
											</tr>
											<tr>
												<td height="45"><span class="STYLE6">自考本科毕业论文优秀范文</span>
												</td>
											</tr>
											<tr>
												<td height="45"><span class="STYLE6">网络中“呵呵”的相关功能研究</span>
												</td>
											</tr>
											<tr>
												<td height="52" class="STYLE6">企业信息管理师论文标准格式</td>
											</tr>
											<tr>
												<td height="45"><span class="STYLE6">企业招聘热门个人简历封面</span><span
													class="STYLE6">二</span>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<c:forEach var="entry" items="${list}">
								<tr>
									<td height="230" colspan="2"><table width="903"
											height="238" border="1" cellpadding="1" cellspacing="1"
											bordercolor="#3366FF">
											<tr>
												<td width="115" height="103" rowspan="2"><img
													src="images/BbsImages/22222.jpg" width="149" height="146" />
												</td>
												<td height="38" colspan="2"><span class="STYLE14">${entry.title }</span>
												</td>
											</tr>
											<tr>
												<td colspan="2" rowspan="3" bordercolor="#0000FF"><p
														align="left" class="STYLE11">
														${entry.content }
												</td>
											</tr>
											<tr>
												<td height="26"><div align="center" class="STYLE12">姓名:${entry.u_name }</div>
												</td>
											</tr>
											<tr>
												<td height="18"><div align="center" class="STYLE12">班级：${entry.c_name }</div>
												</td>
											</tr>
											<tr>
												<td height="36"><div align="center" class="STYLE12">性别：${entry.sex }</div>
												</td>
												<td width="412"><div align="center" class="STYLE12">进入论帖</div>
												</td>
												<td width="354"><div align="center" class="STYLE12">评论</div>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								</c:forEach>
								<tr>
									<td height="67" colspan="2"><div align="center"
											class="STYLE2">【首页】&nbsp;【上一页】&nbsp;【1】&nbsp;【2】&nbsp;【3】&nbsp;【4】&nbsp;【下一页】&nbsp;【尾页】
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
