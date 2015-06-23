<?php

	/**
	 * 			mt_rand(  )  or mt_rand(int $min , int $max)
	 
		Description:
			Many random number generators of older libcs have dubious or unknown characteristics and are 
			slow. By default, PHP uses the libc random number generator with the rand() function. 
			The mt_rand() function is a drop-in replacement for this. It uses a random number generator 
			with known characteristics using the »  Mersenne Twister, which will produce random 
			numbers four times faster than what the average libc rand() provides. 
			
			If called without the optional min, max arguments mt_rand() returns a pseudo-random value 
			between 0 and mt_getrandmax(). If you want a random number between 5 and 15 (inclusive), 
			for example, use mt_rand(5, 15). 

		Returns Values:
			A random integer value between min (or 0) and max (or mt_getrandmax(), inclusive), 
			or FALSE if max is less than min. 
		
		compare to rand() method:
				will produce random numbers four times faster than what the average libc rand() provides
			
		Example:
		
	 */

echo "car".time().md5(mt_rand(100, 1000000))."html";