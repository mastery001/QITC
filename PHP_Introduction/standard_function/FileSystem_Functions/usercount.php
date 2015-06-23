<?php

	/**
	 * 	@Description:利用读文件实现用户计数器功能
	 	
		@author: master
		
		@time: 2015-6-9
	 */

$filename = "data.txt";
$fp = fopen($filename , "r");
if(is_resource($fp)) {
	$c = @fread($fp, filesize($filename));
	$c = intval($c+1);
	fclose($fp);
	if(is_writable($filename)) {
		$fw = @fopen($filename, "w");
		fwrite($fw , $c);
		fclose($fw);
	}else{
		die("{$filename}没有写入权限");
	}
}
?>

<font color="red">您是第</font>
<?php 
	for($i = 0 ; $i < strlen($c) ; $i++) {
		$res = substr($c , $i , 1);
		echo "<img src=img/".$res.".jpg>&nbsp;";
	}
	echo "位用户";
?>