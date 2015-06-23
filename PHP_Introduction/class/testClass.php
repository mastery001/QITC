<?php

class User {
	private $name;
	private $age;

	/**
	 * 构造函数一般不支持重载
	 * @param unknown_type $name
	 * @param unknown_type $age
	 */
	public function __construct($name , $age) {
		print "<h1 align='center' >invoke the __construct1 method, which have parameters</h1>";
		$this->name = $name.PHP_EOL;
		$this->age = $age.PHP_EOL;
	}

	public function show() {
		echo "User [name='$this->name', age='$this->age']";
	}
}
$user = new User("张三" , 13);
$user->show();
?>