<?php

/**
 * 一维数组测试
 */
$arrs = array("1" => "test");
echo "一维数组测试：";
print_r($arrs);
echo "</br>";


/**
 * 索引数组测试
 */
$arrs = array(35 , "hb" , "男");
echo "索引数组测试：";
print_r($arrs);
echo "</br>";
echo "foreach循环值输入测试：";
foreach($arrs as  $value) {
	echo "值：$value;";
}
echo "</br>";
echo "foreach循环键值输入测试：";
foreach($arrs as $key => $value) {
	echo "键：$key,值：$value;";
}
echo "</br>";

/**
 * 数组中存储数组测试
 */
$arrs = array("hb" , array(35 , "男"));
echo "数组中存储数组测试：";
print_r($arrs);
echo "</br>";
?>