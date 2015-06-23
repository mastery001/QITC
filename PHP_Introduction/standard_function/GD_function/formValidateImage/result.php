<?php

	/**
	 * 	@Description:校验验证码是否正确
	 	
		@author: master
		
		@time: 2015-6-8
	 */
session_start();
if($_POST[code] == $_SESSION[code]) {
	echo "验证码输入正确";
}else{
	echo"验证码错误！";
}