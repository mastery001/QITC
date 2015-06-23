<?php

/**
 * 	@Description:
  
 @author: master

 @time: 2015-6-18
 */
include "conf/conf_inc.php";
$id = intval($_GET['id']);
$sql = "delete from t_message where id=".$id;
$result=@mysql_query($sql) or die(mysql_error());
if($result && mysql_affected_rows()>0){
	echo"<script>alert('删除成功!');</script>";
	echo"<script>location.href='index.php';</script>";
}else{
	echo "删除不成功！";
}
mysql_free_result($result);
mysql_close($conn);
