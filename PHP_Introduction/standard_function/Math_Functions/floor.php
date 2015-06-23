<?php

	/**
	 * 			float floor(float $value )
	 
		Description:
			Rerurns the next lowest integer value by rounding down value if necessary.
			
		Returns Values:
			value rounded to the next lowest integer. The return value of floor() is 
			still of type float because the value range of float is usually bigger 
			than that of integer. 

		Example:
	 */
echo floor(4.3)."<BR>";   // 4
echo floor(9.999)."<BR>"; // 9
echo floor(-3.14)."<BR>"; // -4
