<?php

$link = mysql_connect("localhost" , "root" , "root") or die("连接错误");
if($link) {
	mysql_select_db("php_test");
	mysql_query('set names utf8');
}
$sql = 'select * from t_student';
$result = mysql_query($sql);
while ($row = mysql_fetch_assoc($result)) {
	echo $row[id]."=>".$row[stu_name]."<br>";
}