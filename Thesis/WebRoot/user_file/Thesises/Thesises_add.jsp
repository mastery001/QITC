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
.STYLE5 {color: #0000FF}
.STYLE1 {color: #FFFFFF}
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
<td width="68%" height="26" bgcolor="1D67DD"><span class="STYLE1 STYLE4">论文上传::</span></td>
<td width="32%" bgcolor="1D67DD"><span class="STYLE1 STYLE4">提示：本系统禁止以任何形式转载论文。</span></td>
</tr>
</table>
<table width="70%"  align="center" border="0" style="background-color:#F4F4F4; background-image:url(images/faceimges/whiteBg.png)">
      <tr>
        <td height="563"><div align="center">
          <form action="" method="post" enctype="multipart/form-data" name="form1" id="form1">
            <table   border="0" width="55%">
			  <tr>
                <td height="50">&nbsp;</td>
                <td height="50" colspan="2">&nbsp;</td>
              </tr>
			  <tr>
                <td height="50"><div align="right"><span class="STYLE5">选择文档：</span></div></td>
			    <td height="50" colspan="2"><input type="file" name="file" /> </td>
		      </tr>
			  <tr>
                <td height="50">&nbsp;</td>
                <td height="50" colspan="2">&nbsp;</td>
              </tr>
              <tr>
                <td width="19%" height="50"><div align="right" class="STYLE5" >文件名称：</div></td>
                <td height="50" colspan="2"><input name="text" type="text"  style="width:300px; height:30px"/></td>
              </tr>
              <tr>
                <td height="50">&nbsp;</td>
                <td height="50" colspan="2">&nbsp;</td>
              </tr>
			   <tr>
                <td height="50"><div align="right" class="STYLE5">封面图片：</div></td>
                <td height="50" colspan="2"><input type="file" name="file2" /></td>
              </tr>
			   <tr>
                <td height="50">&nbsp;</td>
                <td height="50" colspan="2">&nbsp;</td>
              </tr>
              <tr>
                <td height="24"><div align="right" class="STYLE5">文档简介：</div></td>
                <td height="50" colspan="2" rowspan="2"><textarea name="textarea" style="width:300px; height:100px;color:#0000FF;font:normal 14px/14px 'Microsoft JhengHei','Microsoft YaHei', Arial, sans-serif;"></textarea></td>
              </tr>
              <tr>
                <td height="24">&nbsp;</td>
              </tr>

             <tr>
                <td height="50">&nbsp;</td>
                <td height="50" colspan="2">&nbsp;</td>
              </tr>

              <tr>
                <td height="50"><div align="right" class="STYLE5">标签：</div></td>
                <td height="50" colspan="2"><input type="text"  style="width:300px; height:30px"/></td>
              </tr>
			    <tr>
                <td height="50">&nbsp;</td>
                <td height="50" colspan="2">&nbsp;</td>
              </tr>
              <tr>
                <td height="50">&nbsp;</td>
                <td width="34%" height="50"><label>
                  <input type="submit" name="Submit2"  style="height:40px; width:100px; color:#0000FF; font-size:20px; font-family: "楷体="楷体""" value="上传">
                </label></td>
                <td width="47%"><input type="submit" name="Submit22"  style="height:40px; width:100px;color:#0000FF; font-size:20px; font-family: "楷体="楷体""" value="取消" /></td>
              </tr>
              <tr>
                <td height="136">&nbsp;</td>
                <td height="136" colspan="2">&nbsp;</td>
              </tr>
            </table>
          </form>
        </div></td>
      </tr>
</table>
     
    </td>
  </tr>
</table>
  </body>
</html>
