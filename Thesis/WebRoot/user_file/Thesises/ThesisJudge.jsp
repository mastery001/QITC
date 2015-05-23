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
  <td height="753"><table width="100%" height="1031" border="0">
    <tr>
      <td height="41">&nbsp;</td>
    </tr>
    <tr>
      <td height="536"><table width="80%" height="563" border="1" cellspacing="0" bordercolor="#0000FF" align="center">
        <tr>
          <td height="30" colspan="2"><div align="center">评审老师评审论文</div></td>
          </tr>
        <tr>
          <td width="372" height="27">论文ID </td>
          <td width="371">hw451268546 </td>
        </tr>
        <tr>
          <td height="28">文件名 </td>
          <td>论文评审系统</td>
        </tr>
        <tr>
          <td height="26">评审次数</td>
          <td>3</td>
        </tr>
        <tr>
          <td height="28">打开论文</td>
          <td>单击此处文件名打开论文</td>
        </tr>
        <tr>
          <td height="31" colspan="2"><div align="center">评审老师评语</div></td>
          </tr>
        <tr>
          <td height="290" colspan="2"><textarea name="textarea2"  style="width:99%; height:99.5%; background:url(images/faceimges/whiteBg.png)"></textarea></td>
          </tr>
        <tr>
          <td height="28">本次评审是否通过</td>
          <td><div align="center">
            <input type="checkbox" name="checkbox854" value="checkbox" />
            通过&nbsp;&nbsp;
            <input type="checkbox" name="checkbox8542" value="checkbox" />
            不通过
          </div></td>
        </tr>
        <tr>
          <td height="25">是否提交审核</td>
          <td><div align="center">
            <input type="checkbox" name="checkbox8543" value="checkbox" />
            是
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" name="checkbox85422" value="checkbox" />
            否
          </div></td>
        </tr>
        <tr>
          <td height="18">
            
                  <div align="center">
                    <input type="submit" name="Submit2"  style="width:50px; height:25px; color:#0000FF" value="提交" />
                </div></td>
          <td><div align="center">
            <input  type="reset" name="reset"  style="width:50px; height:25px; color:#0000FF" value="重置" />
          </div></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
    </tr>
  </table></td>
</table>
    </td>
  </tr>
</table> <br>
  </body>
</html>
