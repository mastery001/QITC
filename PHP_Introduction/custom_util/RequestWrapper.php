<?php
/**
 * 	create a function to wrap the $_GET
 */

function proceed() {
	$e=mb_detect_encoding($text, array('UTF-8', 'GBK'));
	if($e == 'UTF-8') {
		return $_GET;
	}
	$_Request = array();
	foreach($_GET as $key => $value) {
		$_Request[$key] = iconv("utf-8","GBK",$_GET[$key]);
	}
	return $_Request;
}

