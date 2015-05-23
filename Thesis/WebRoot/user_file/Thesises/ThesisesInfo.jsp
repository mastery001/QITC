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
<td height="753"><table width="907" height="584" border="0">
  <tr>
    <td height="53"><div align="center">已通过评审论文</div></td>
    <td height="53"><div align="center">全部论文</div></td>
    <td height="53"><div align="center">未评审通过论文</div></td>
  </tr>
  <tr>
    <td height="222" colspan="3"><table width="913" height="184" border="solid" align="right" cellpadding="2" cellspacing="0" bordercolor="#1D67DD" >
      <tr>
        <td height="27" colspan="7"><div align="center">论文信息</div></td>
      </tr>
      <tr>
        <td height="20"><div align="center">论文ID</div></td>
        <td><div align="center">文件名</div></td>
        <td><div align="center">评审状态</div></td>
        <td><div align="center">评审次数</div></td>
        <td><div align="center">复审次数</div></td>
        <td><div align="center">复审状态</div></td>
        <td><div align="center">论文评审</div></td>
      </tr>
      <tr>
        <td height="33"><div align="center">lw20121576</div></td>
        <td><div align="center">论文评审</div></td>
        <td><div align="center">已评审</div></td>
        <td><div align="center">0</div></td>
        <td><div align="center">0</div></td>
        <td><div align="center">未通过</div></td>
        <td><div align="center">查看论文</div></td>
      </tr>
       <tr>
        <td height="33"><div align="center">lw20121424</div></td>
        <td><div align="center">学生成绩管理系统</div></td>
        <td><div align="center">未评审</div></td>
        <td><div align="center">3</div></td>
        <td><div align="center">2</div></td>
        <td><div align="center">未通过</div></td>
        <td><div align="center">查看论文</div></td>
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
    <td width="307" height="44">&nbsp;</td>
    <td width="284">&nbsp;</td>
    <td width="314">&nbsp;</td>
  </tr>
  <tr>
    <td height="255" colspan="3">&nbsp;</td>
  </tr>
</table></td>
</table>
    </td>
  </tr>
</table>

  </body>
</html>
