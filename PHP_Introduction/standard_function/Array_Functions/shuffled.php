<?php
	/**
	 * 				bool shuffle ( array &$array )
	 
		Description:
			This function shuffles (randomizes the order of the elements in) an array. 

		Returns Values:
			Returns TRUE on success or FALSE on failure. 

		Example:
	 */
$number = range(1,20);
shuffle($number);
foreach($number as $value) {
	echo $value."<BR>";
}