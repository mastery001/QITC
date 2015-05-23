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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.STYLE2 {color: #0000FF}
.STYLE4 {color: #FFFFFF}
</style>
  </head>
  
  <body>
  
   <table width="100%" height="617" border="0">
   <tr>
    <td height="100">
    <jsp:include page ="/top.jsp"  flush="true"></jsp:include></td>
  </tr>
  <tr>
    <td height="550"> 
    
  <table width="70%" height="26" border="0" align="center">
<tr>
<td width="77%" height="26" bgcolor="1D67DD"><span class="STYLE4">论文送审::</span></td>
<td width="23%" bgcolor="1D67DD"><span class="STYLE4">提示：非本人操作请自觉。</span></td>
</tr>
</table>
<table width="70%" align="center" border="0" bordercolor="#1D67DD" style="background-color:#F4F4F4" background="images/faceimges/whiteBg.png">
<tr>
<td height="753"><table width="907" height="440" border="0">
  <tr>
    <td height="16">&nbsp;</td>
  </tr>
  <tr>
    <td height="229"><table width="913" height="184" border="solid" align="right" cellpadding="2" cellspacing="0" bordercolor="#1D67DD" >
      <tr>
        <td height="27" colspan="7"><div align="center">论文信息</div></td>
      </tr>
      <tr>
        <td height="20"><div align="center">论文ID</div></td>
        <td><div align="center">文件名</div></td>
        <td><div align="center">送审状态</div></td>
        <td><div align="center">送审次数</div></td>
        <td><div align="center">初审状态</div></td>
        <td><div align="center">复审状态</div></td>
        <td><div align="center">是否送审</div></td>
      </tr>
      <tr>
        <td height="33"><div align="center">lw20121576</div></td>
        <td><div align="center">论文评审</div></td>
        <td><div align="center">未送审</div></td>
        <td><div align="center">0</div></td>
        <td><div align="center">未通过</div></td>
        <td><div align="center">未通过</div></td>
        <td><div align="center">
          <input type="checkbox" name="checkbox854" value="checkbox" />
        是&nbsp;&nbsp;
        <input type="checkbox" name="checkbox8542" value="checkbox" />
        否</div></td>
      </tr>
       <tr>
        <td height="33"><div align="center">lw20121424</div></td>
        <td><div align="center">学生成绩管理系统</div></td>
        <td><div align="center">已送审</div></td>
        <td><div align="center">3</div></td>
        <td><div align="center">通过</div></td>
        <td><div align="center">未通过</div></td>
        <td><div align="center">
          <input type="checkbox" name="checkbox854" value="checkbox" />
        是&nbsp;&nbsp;
        <input type="checkbox" name="checkbox8542" value="checkbox" />
        否</div></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="46"><div align="center"><input type="submit" name="Submit2"  style="height:40px; width:100px; color:#0000FF; font-size:20px; font-family: "楷体="楷体""" value="提交"  /></div></td>
  </tr>
  <tr>
    <td height="138">&nbsp;</td>
  </tr>
</table></td>
</table>
    </td>
  </tr>
</table>

 <br>
  </body>
</html>
