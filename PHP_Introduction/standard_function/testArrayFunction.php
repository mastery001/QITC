<?php
/**
 *	test the explode function
 *	effect:
 *		split the string into an array,which is a index array. 
 */
print 'test the explode function<br>';
$string = 'how are you';
$arrs = explode(' ' , $string);
print_r($arrs);
echo "<br>";
/**
 *  test the count function
 *  effect:
 *  	Number of statistical array elements.
 */
print 'test the count function<br>';
$age = array('age1' => 35 , 'age2' => 36 , 'age3' => 37);
for($i = 1 ; $i <= count($age) ; $i++) {
	echo "age$i:".$age["age$i"]."<br>";
}
echo '<br>';

/**
 * 	echo $_SERVER array 
 */ 
print_r($_SERVER);
echo '<br><br><br>';

/**
 * 	echo $GLOBALS array 
 */ 
print_r($GLOBALS);

