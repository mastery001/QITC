<?php

	/**
	 * 	@Description: testing file functions.
	 	
		@author: master
		
		@time: 2015-6-9
	 */

$data = "data.txt";
if(file_exists($data)) {
	$fp = fopen($data , "r");
	if(is_readable($data)) {
		echo "可读";
	}
}else{
	echo die("文件不存在!");
}