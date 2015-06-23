<?php
/**
 * 	初步生成验证码
 */
header ('Content-Type:image/png'); 
// 创建一个画布，默认是黑色的
$im = @imagecreatetruecolor(120,30) or die('创建失败');
$text_color = imagecolorallocate($im , 233 , 14 , 91);
imagestring($im , 1 , 5 , 5 , "A Simple Text String" , $text_color);
imagepng($im);
imagedestory($im);

?>
