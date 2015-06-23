<?php

// 创建一个画布， 默认是黑色的
$im = @imagecreatetruecolor(100,50) or exit("创建失败");

//rgb;默认是一个彩色的
//$im=imagecreate(100, 30);

// 采集了颜色，为一副图像分配颜色
$bg = imagecolorallocate($im , 0 , 0 , 0 );
//采集了白色的前景色；
$fg = imagecolorallocate($im , 255 , 255 , 255);

//将颜色填充到画布去；
/*imagefill($im , 0 , 0 , $bg);
for ($i=1;$i<=4;$i++){
	$rnd.=dechex(mt_rand(0,15));
}*/
// 生成字母与数字的验证码
$arr1 = range(A , Z);
$arr2 = range(a , z);
$arr3 = range(0 , 9);

$arr = array_merge($arr1 , $arr2 , $arr3);

//shuffle the arr array
shuffle($arr);
for($i = 0 ; $i < 4 ; $i++ ) {
	$rnd.=$arr[mt_rand(0 , count($arr)-1)];
}
//画了200个不同颜色的点；
for ($d=1;$d<=200;$d++){
	$dg=imagecolorallocate($im,mt_rand(0, 255), mt_rand(0, 255), mt_rand(0, 255));
    imagesetpixel($im, mt_rand(0, 100), mt_rand(0,30),$dg);
}
$fontfile="STCAIYUN.TTF";
$str="天要下雨";
imagettftext($im, 14, 0, 5, 25, $fg, $fontfile, $str);

//imagestring($im, 14, 10, 5, "$rnd", $fg);
header("content-type:image/jpeg");
//header("content-type:html/css");
//header("location:testCreateValidateCode_001.php");
imagejpeg($im);//输出图形到浏灠器或是文件