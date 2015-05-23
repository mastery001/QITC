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

body {
	background-image: url(images/faceimges/whiteBg.png);
	background-color: #000000;
}
.STYLE3 {color: #0000FF}
.STYLE4 {color: #FFFFFF}
.STYLE2 {color: #0000FF}
</style>
  </head>
  
  <body>
    <table width="100%" height="617" border="0">
   <tr>
    <td height="100">
    <jsp:include page ="/top.jsp"  flush="true"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="550"> 
    <table width="70%" height="26" border="0" align="center">
<tr>
<td width="78%" height="26" bgcolor="1D67DD"><span class="STYLE4">我的个人信息::</span></td>
<td width="22%" bgcolor="1D67DD"><span class="STYLE4">提示：非本人操作请自觉。</span></td>
</tr>
</table>
<table width="70%" align="center" border="0" bordercolor="#1D67DD" style="background-color:#F4F4F4" background="images/faceimges/whiteBg.png">
<tr>
<td height="753"><table width="100%" height="723" border="0">
<tr>
<td colspan="2"><div align="center">
    <table   border="0" width="50%">
    <tr>
      <td width="19%" height="50"><div align="right"><span class="STYLE3">姓名</span>：</div></td>
        <td height="50" colspan="2"><input readonly type="text" name="textfield2" style="width:200px;color:#0000FF; height:25px"   value="黄宾"/></td>
      </tr>
    <tr>
      <td height="50"><div align="right" class="STYLE3">性别：</div></td>
      <td height="50" colspan="2"><input  type="radio" name="sex"  value="男" checked/>
        <span class="STYLE3">男</span>   &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" name="sex"  value="女"/>
        <span class="STYLE3">女</span></td>
    </tr>
    <tr>
      <td height="50"><div align="right" class="STYLE3">班级：</div></td>
      <td height="50" colspan="2"><input readonly type="text" name="textfield22" style="width:200px;color:#0000FF; height:25px"  value="软件1202"/></td>
    </tr>
    <tr>
      <td height="50"><div align="right" class="STYLE3">学号：</div></td>
      <td height="50" colspan="2"><input readonly type="text" name="textfield222" style="width:200px;   color:#0000FF; height:25px" value="20121576"/></td>
    </tr>
    <tr>
      <td height="50"><div align="right" class="STYLE3">身份：</div></td>
      <td height="50" colspan="2"><input readonly type="text" name="textfield223" style="width:200px; color:#0000FF; height:25px" value="学生"/></td>
    </tr>
    <tr>
      <td height="50"><div align="right" class="STYLE3">指导老师：</div></td>
      <td height="50" colspan="2"><input readonly type="text" name="textfield2232" style="width:200px; color:#0000FF; height:25px" value="杨珺"/></td>
    </tr>
    <tr>
      <td height="50"><div align="right" class="STYLE3">入学年份：</div></td>
      <td height="50" colspan="2">
        <select  name="select" style="width:200px;  color:#0000FF; height:25px">
	      <option value="2016">2016</option>
		  <option value="2015">2015</option>
		  <option value="2015">2015</option>
		  <option value="2015">2015</option>
		  <option value="2012">2012</option>
		  <option value="2011">2011</option>
		  <option value="2010">2010</option>
		  <option value="2009">2009</option>
		  <option value="2008">2008</option>
		  <option value="2007">2007</option>
		  <option value="2006">2006</option>
          </select>      </td>
    </tr>
    <tr>
      <td height="50"><div align="right" class="STYLE3">联系电话：</div></td>
      <td height="50" colspan="2"><input type="text" name="textfield22322" style="width:200px; color:#0000FF; height:25px" value="13247760589"/></td>
    </tr>
	<tr>
      <td height="50">&nbsp;</td>
      <td width="42%" height="50"><label></label></td>
      <td width="39%">&nbsp;</td>
	</tr>
	<tr>
      <td height="50">&nbsp;</td>
	  <td height="50"><label>
        <input type="submit" name="Submit2"  style="height:40px; width:100px; color:#0000FF; font-size:20px; font-family: "楷体="楷体""" value="保存"  />
      </label></td>
	  <td><input type="submit" name="Submit22"  style="height:40px; width:100px;color:#0000FF; font-size:20px; font-family: "楷体="楷体""" value="取消" /></td>
	  </tr>
	<tr>
      <td height="136">&nbsp;</td>
      <td height="136" colspan="2">&nbsp;</td>
    </tr>
  </table>
  <br>
  <br>  
</div>
  <div id="Zones"></div>  
  <label></label>
  <label></label> 
    <label></label></td>
</tr>

</table></td>
</tr>
</table>
    </td>
  </tr>
</table>
  </body>
</html>
