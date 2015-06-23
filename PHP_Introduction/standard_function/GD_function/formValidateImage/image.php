<?php

	/**
	 * 	@Description:
	 	
		@author: master
		
		@time: 2015-6-8
	 */
session_start();
$im=@imagecreatetruecolor(100, 30) or exit("创建失败");
//$im=imagecreate(100, 30);//rgb
$bg=imagecolorallocate($im, 0, 0, 0);
$fg=imagecolorallocate($im, 255, 255, 255);
//imagefill($im, 0, 0, $bg);
/*for($i=1;$i<=4;$i++){
	$rnd.=dechex(mt_rand(0,15));
}*/

$arr1=range(A, Z);
$arr2=range(a, z);
$arr3=range(0, 9);
$arr=array_merge($arr1,$arr2,$arr3);
//print_r($arr);
shuffle($arr);
for($i=1;$i<=4;$i++){
	$rnd.=$arr[mt_rand(0,61)];
}


for($d=1;$d<=200;$d++){
	$dg=imagecolorallocate($im, mt_rand(0,255), mt_rand(0,255), mt_rand(0,255));
   imagesetpixel($im, mt_rand(0,100), mt_rand(0,30), $dg);
}

for($l=1;$l<=20;$l++){
	$lg=imagecolorallocate($im, mt_rand(0,255), mt_rand(0,255), mt_rand(0,255));
   imageline($im, mt_rand(0,15), mt_rand(0,30), 100, mt_rand(0,30), $lg);
}


$strfont="控 制 器 接 入 用 户 输 并 调 模 型 与 视 图 去 完 成 的 需 求 返 回 数 值 同 时";
$arr=explode(" ", $strfont);
str_shuffle($arr);
for($f=1;$f<=4;$f++){
	$str.=$arr[mt_rand(0,count($arr)-1)];
}
$_SESSION[code]=$str;
$fontfile="msyh.ttf";
imagettftext($im, 14, mt_rand(0,12), 5, 25, $fg, $fontfile, $str);
//imagestring($im, 14, 10, 5, $rnd, $fg);
header("content-type:image/jpeg");
//header("content-type:html/css");
//header("location:index.php");
imagejpeg($im);
