<?php

	/**
	 * 	@Description:
	 	
		@author: master
		
		@time: 2015-6-8
	 */
/*
*调用验证码
*/
?>
<script language="javascript">
function fresh(){
	var cs=document.getElementById("codestr");
	cs.src="image.php?"+Math.random();
}

</script>
<form action="result.php" method="post">
<table width="300" height="150" align="center">
<tr>
<td>用户</td>
<td><input type="text" name="username" style="width:160px;"></td>
</tr>
<tr>
<td>密码</td>
<td><input type="password" name="userpwd" style="width:160px;"></td>
</tr>
<tr>
<td>验证码</td>
<td><input type="text" name="code" style="width:60px;"><img src="image.php" id="codestr"  onclick="fresh()"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="submit" value="登陆"></td>
</tr>

</table>

</form>