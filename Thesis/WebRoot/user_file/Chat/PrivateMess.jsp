<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

body {
	background-image: url(images/faceimges/whiteBg.png);
	background-color: #000000;
}
.STYLE2 {color: #0000FF}
.STYLE4 {color: #FFFFFF}

}
</style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body   style=" height:1000">
    <table width="100%" height="617" border="0">
   <tr>
    <td height="100">
    <jsp:include page ="/top.jsp"  flush="true"></jsp:include></td>
  </tr>
  <tr>
    <td height="550"> 
    
<table width="70%" height="26" border="0" align="center">
          <tr>
            <td width="68%"  height="26" bgcolor="1D67DD"><span class="STYLE4">Web聊天室::</span></td>
            <td width="32%" bgcolor="1D67DD"><span class="STYLE4">提示：文明聊天从我做起，请自觉遵守。</span></td>
          </tr>
</table>
<table width="70%"  align="center" border="0"  bordercolor="#1D67DD" style="background-color:#F4F4F4" background="images/faceimges/whiteBg.png">
      <tr>
        <td height="662"><table width="100%" height="660" border="1" cellpadding="1" cellspacing="0" bordercolor="#0000FF">
          <tr>
            <td rowspan="2"> <textarea  readonly name="textarea"  style="width:99%; height:99.5%; background:url(images/faceimges/whiteBg.png)"></textarea></td>
            <td width="30%"  height="46"><img src="images/323.jpg" width="100%" height="48" /></td>
          </tr>
          <tr>
            <td rowspan="2"> <textarea  readonly name="textarea"  style="width:99%; height:99.5%; background:url(images/faceimges/whiteBg.png)"></textarea></td>
          </tr>
          
          <tr>
            <td height="34">
                  <select name="select2"  style=" width:120px;height:100%; color:#0000FF">
                    <option  value="稻草人">@稻草人</option>
                    <option  value="邹子文">@邹子文</option>
                    <option  value="杨俊老师">@杨俊老师</option>
                    <option  value="令狐聪">@令狐聪</option>
                    <option  value="所有人">@所有人</option>
                  </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <span class="STYLE3">消息记录</span>
           </td>
          </tr>
          <tr>
            <td height="61"><textarea name="text"  style=" width:100%"></textarea></td>
            <td width="186"><img src="images/32.jpg" width="185" height="57" /></td>
          </tr>
        </table></td>
      </tr>
</table>
    
    </td>
  </tr>
</table>
  </body>
</html>
