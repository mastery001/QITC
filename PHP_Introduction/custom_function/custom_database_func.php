<?php
/**
 * create custom functions
 */

include 'conf_inc.php';

function dblink() {
	$link = @mysql_connect(DB_HOST , DB_USER , DB_PWD) or die("数据库连接错误！");
	if($link) {
		mysql_select_db(DB_NAME);
		mysql_query("set names DB_CONFIG");
	}
}

function selectall($tablename) {
	dblink();
	$sql = "select * from {$tablename}";
	$result = mysql_query($sql);
	while($row = mysql_fetch_array($result)) {
		$rows[] = $row;
	}
	return $rows;
}

print_r(selectall('t_student'));
echo "<br>";

/**
 * 传递的最后一个参数为表名，其余为属性字段
 * @return 此张表中对应的记录---数组
 */
function fields() {
	// 获得参数数组
	$arr = func_get_args();
	$tablename = array_pop($arr);
	$field = implode(',' , $arr);
	dblink();
	$sql = "select $field from {$tablename}";
	$result = mysql_query($sql);
	while($row = mysql_fetch_assoc($result)) {
		$rows[] = $row;
	}
	return $rows;
}

//print_r(fields("id" , "stu_name" , "t_student"));
