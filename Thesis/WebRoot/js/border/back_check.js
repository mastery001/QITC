function u_check(f) {
	var conditions = {"u_id" : "登录名" , "u_name" : "用户名" ,"c_id" : "班级"};
	return public_check(f , conditions);
}

function c_check(f) {
	return public_check(f , {"c_name" : "班级名称" , "major" : "班级专业"});
}
