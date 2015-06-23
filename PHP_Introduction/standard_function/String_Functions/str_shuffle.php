<?php 
	/**
	 * 			string str_shuffle ( string $str )
	 * Description:
	   		str_shuffle() shuffles a string. One permutation of all possible is created. 
	   		
	   	Example:
	 */
$str = "abcdef";
$shuffled = str_shuffle($str);

// This will echo something like : ebcdfa
echo $shuffled."<br>";
?>