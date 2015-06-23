<?php
	/**
	 * 			bool ksort( array &$array[, int $sort_flags = SORT_REGULAR] )
	 
		Description:
			Sorts an array by key , maintaining key to data correlations. This is
			useful mainly for associative arrays.

		Returns Values:
			Returns TRUE on success or FALSE on failure. 

		Example:
	 */

$fruits = array("d"=>"lemon" , "a"=>"orange" , "b" => "banana" , "c"=>"apple");
ksort($fruits);
foreach($fruits as $key=>$value) {
	echo "$key=$value"."<BR>";
}