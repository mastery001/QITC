function u_check(f) {
	var conditions = {
		"u_id" : "登录名",
		"u_name" : "用户名",
		"c_id" : "班级"
	};
	return public_check(f, conditions);
}

function c_check(f) {
	return public_check(f, {
		"c_name" : "班级名称",
		"major" : "班级专业"
	});
}

function do_check(f) {
	var flag = public_check(f, {
		"document" : "论文"
	});
	if (flag) {
		var value = f.document.value;
		var ext = value.substring(value.lastIndexOf("."));
		if (ext.indexOf("doc") == -1) {
			alert("上传的文件格式只能为doc或者docx");
			flag = false;
		} else {
			var name;
			if (value.lastIndexOf("\\") != -1) {
				name = value.substring(value.lastIndexOf("\\") + 1, value.lastIndexOf("."));
			}else {
				name = value.substring(0, value.lastIndexOf("."));
			}
			f.d_name.value = name;
		}
	}
	return flag;

}
