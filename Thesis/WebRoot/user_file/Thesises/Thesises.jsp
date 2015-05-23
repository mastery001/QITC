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
    <jsp:include page ="/top.jsp"  flush="true"></jsp:include>
    </td>
    	</tr>
  <tr>
    <td height="550"><table width="70%" height="26" border="0" align="center">
<tr>
<td width="68%" height="10" bgcolor="1D67DD" class="STYLE4">论文查看::</td>
<td width="32%" bgcolor="1D67DD"  class="STYLE4">提示：本系统禁止以任何形式转载论文。</td>
</tr>
</table>
<table width="70%" border="0" align="center" style="background-color:#F4F4F4; background-image:url(images/faceimges/whiteBg.png)">
      <tr>
        <td height="837"><table width="100%" height="830" border="0">
            <tr>
              <td height="200"><table  id="imgid" class="textbox" width="98%" onmousemove="Mouse_Over(this)" onmouseout="Mouse_Out(this)"  border="1"  cellpadding="1" cellspacing="1" bordercolor="#1D67DD">
                <tr>
                  <td width="56%" rowspan="4"><img src="images/lunwen.jpg" alt="" width="149" height="165" /></td>
                  <td width="44%" height="35" align="center"><span class="STYLE2">黄 宾</span></td>
                </tr>
                <tr>
                  <td height="35" align="center"><span class="STYLE2">软件1202</span></td>
                </tr>
                <tr>
                  <td height="40" align="center"><span class="STYLE2">软件开发</span></td>
                </tr>
                <tr>
                  <td height="47" align="center"><span class="STYLE2">20121576</span></td>
                </tr>
                <tr>
                  <td height="54" colspan="2" align="center"><span class="STYLE2">农大论文评审系统</span></td>
                </tr>
              </table></td>
              <td><table id="imgid" class="textbox" width="98%" onmousemove="Mouse_Over(this)" onmouseout="Mouse_Out(this)" width="98%" border="1"  cellpadding="1" cellspacing="1" bordercolor="#1D67DD">
                <tr>
                  <td width="56%" rowspan="4"><img src="images/lunwen.jpg" alt="" width="149" height="165" /></td>
                  <td width="44%" height="35" align="center"><span class="STYLE2">黄 宾</span></td>
                </tr>
                <tr>
                  <td height="35" align="center"><span class="STYLE2">软件1202</span></td>
                </tr>
                <tr>
                  <td height="40" align="center"><span class="STYLE2">软件开发</span></td>
                </tr>
                <tr>
                  <td height="47" align="center"><span class="STYLE2">20121576</span></td>
                </tr>
                <tr>
                  <td height="54" colspan="2" align="center"><span class="STYLE2">农大论文评审系统</span></td>
                </tr>
              </table></td>
              <td><table id="imgid" class="textbox" width="98%" onmousemove="Mouse_Over(this)" onmouseout="Mouse_Out(this)"  width="98%" border="1"  cellpadding="1" cellspacing="1" bordercolor="#1D67DD">
                <tr>
                  <td width="56%" rowspan="4"><img src="images/lunwen.jpg" alt="" width="149" height="165" /></td>
                  <td width="44%" height="35" align="center"><span class="STYLE2">杨珺</span></td>
                </tr>
                <tr>
                  <td height="35" align="center"><span class="STYLE2">软件1202</span></td>
                </tr>
                <tr>
                  <td height="40" align="center"><span class="STYLE2">软件开发</span></td>
                </tr>
                <tr>
                  <td height="47" align="center"><span class="STYLE2">20121576</span></td>
                </tr>
                <tr>
                  <td height="54" colspan="2" align="center"><span class="STYLE2">农大论文评审系统</span></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="200"><table id="imgid" class="textbox" width="98%" onmousemove="Mouse_Over(this)" onmouseout="Mouse_Out(this)"  width="98%" border="1"  cellpadding="1" cellspacing="1" bordercolor="#1D67DD">
                <tr>
                  <td width="56%" rowspan="4"><img src="images/lunwen.jpg" alt="" width="149" height="165" /></td>
                  <td width="44%" height="35" align="center"><span class="STYLE2">黄 宾</span></td>
                </tr>
                <tr>
                  <td height="35" align="center"><span class="STYLE2">软件1202</span></td>
                </tr>
                <tr>
                  <td height="40" align="center"><span class="STYLE2">软件开发</span></td>
                </tr>
                <tr>
                  <td height="47" align="center"><span class="STYLE2">20121576</span></td>
                </tr>
                <tr>
                  <td height="54" colspan="2" align="center"><span class="STYLE2">农大论文评审系统</span></td>
                </tr>
              </table></td>
              <td height="29"><table id="imgid" class="textbox" width="98%" onmousemove="Mouse_Over(this)" onmouseout="Mouse_Out(this)"  width="98%" border="1"  cellpadding="1" cellspacing="1" bordercolor="#1D67DD">
                <tr>
                  <td width="56%" rowspan="4"><img src="images/lunwen.jpg" alt="" width="149" height="165" /></td>
                  <td width="44%" height="35" align="center"><span class="STYLE2">黄 宾</span></td>
                </tr>
                <tr>
                  <td height="35" align="center"><span class="STYLE2">软件1202</span></td>
                </tr>
                <tr>
                  <td height="40" align="center"><span class="STYLE2">软件开发</span></td>
                </tr>
                <tr>
                  <td height="47" align="center"><span class="STYLE2">20121576</span></td>
                </tr>
                <tr>
                  <td height="54" colspan="2" align="center"><span class="STYLE2">农大论文评审系统</span></td>
                </tr>
              </table></td>
              <td height="29"><table id="imgid" class="textbox" width="98%" onmousemove="Mouse_Over(this)" onmouseout="Mouse_Out(this)"  width="98%" border="1"  cellpadding="1" cellspacing="1" bordercolor="#1D67DD">
                <tr>
                  <td width="56%" rowspan="4"><img src="images/lunwen.jpg" alt="" width="149" height="165" /></td>
                  <td width="44%" height="35" align="center"><span class="STYLE2">黄 宾</span></td>
                </tr>
                <tr>
                  <td height="35" align="center"><span class="STYLE2">软件1202</span></td>
                </tr>
                <tr>
                  <td height="40" align="center"><span class="STYLE2">软件开发</span></td>
                </tr>
                <tr>
                  <td height="47" align="center"><span class="STYLE2">20121576</span></td>
                </tr>
                <tr>
                  <td height="54" colspan="2" align="center"><span class="STYLE2">农大论文评审系统</span></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="200"><table id="imgid" class="textbox" width="98%" onmousemove="Mouse_Over(this)" onmouseout="Mouse_Out(this)"  width="98%" border="1"  cellpadding="1" cellspacing="1" bordercolor="#1D67DD">
                <tr>
                  <td width="56%" rowspan="4"><img src="images/lunwen.jpg" alt="" width="149" height="165" /></td>
                  <td width="44%" height="35" align="center"><span class="STYLE2">黄 宾</span></td>
                </tr>
                <tr>
                  <td height="35" align="center"><span class="STYLE2">软件1202</span></td>
                </tr>
                <tr>
                  <td height="40" align="center"><span class="STYLE2">软件开发</span></td>
                </tr>
                <tr>
                  <td height="47" align="center"><span class="STYLE2">20121576</span></td>
                </tr>
                <tr>
                  <td height="54" colspan="2" align="center"><span class="STYLE2">农大论文评审系统</span></td>
                </tr>
              </table></td>
              <td height="200"><table id="imgid" class="textbox" width="98%" onmousemove="Mouse_Over(this)" onmouseout="Mouse_Out(this)"  width="98%" border="1"  cellpadding="1" cellspacing="1" bordercolor="#1D67DD">
                <tr>
                  <td width="56%" rowspan="4"><img src="images/lunwen.jpg" alt="" width="149" height="165" /></td>
                  <td width="44%" height="35" align="center"><span class="STYLE2">黄 宾</span></td>
                </tr>
                <tr>
                  <td height="35" align="center"><span class="STYLE2">软件1202</span></td>
                </tr>
                <tr>
                  <td height="40" align="center"><span class="STYLE2">软件开发</span></td>
                </tr>
                <tr>
                  <td height="47" align="center"><span class="STYLE2">20121576</span></td>
                </tr>
                <tr>
                  <td height="54" colspan="2" align="center"><span class="STYLE2">农大论文评审系统</span></td>
                </tr>
              </table></td>
              <td height="200"><table id="imgid" class="textbox" width="98%" onmousemove="Mouse_Over(this)" onmouseout="Mouse_Out(this)"  width="98%" border="1"  cellpadding="1" cellspacing="1" bordercolor="#1D67DD">
                <tr>
                  <td width="56%" rowspan="4"><img src="images/lunwen.jpg" alt="" width="149" height="165" /></td>
                  <td width="44%" height="35" align="center"><span class="STYLE2">黄 宾</span></td>
                </tr>
                <tr>
                  <td height="35" align="center"><span class="STYLE2">软件1202</span></td>
                </tr>
                <tr>
                  <td height="40" align="center"><span class="STYLE2">软件开发</span></td>
                </tr>
                <tr>
                  <td height="47" align="center"><span class="STYLE2">20121576</span></td>
                </tr>
                <tr>
                  <td height="54" colspan="2" align="center"><span class="STYLE2">农大论文评审系统</span></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="66" colspan="3"><center>
                <span class="STYLE2">【首页】&nbsp;【上一页】&nbsp;【1】&nbsp;【2】&nbsp;【3】&nbsp;【4】&nbsp;【下一页】&nbsp;【尾页】 </span>
              </center></td>
            </tr>
            <tr>
              <td height="53" colspan="3">&nbsp;</td>
            </tr>
        </table></td>
      </tr>
</table>
    </td>
  </tr>
</table>
    <div id="mask"> </div>
 <div id="myMenu" >
     <ul>
        <li><a  href="学生_论文查看.html">打开</a></li>
        <li><a   href="学生_论文下载.html">下载</a></li>
        <li><a  onclick='Mouse_KeyDown()' >删除</a></li>
        <li onclick="textFoucus()">重命名</li>
    </ul>
 </div>
  </body>
</html>
