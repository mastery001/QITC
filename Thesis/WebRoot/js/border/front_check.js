function t_check(f) {
	var flag = public_check(f, {
		"document" : "上传的论文文档",
		"t_name" : "文件名称",
		"description" : "文档简介"
	});
	if (flag) {
		var value = f.document.value;
		value = value.substring(value.lastIndexOf("."));
		if (value.indexOf("doc") == -1) {
			alert("上传的文件格式只能为doc或者docx");
			flag = false;
			return flag;
		}
		var t_front = f.document.value;
		if (t_front != "") {
			t_front = t_front.substring(t_front.lastIndexOf("."));
			if (t_front.indexOf("gif") == -1 || t_front.indexOf("jpg") == -1
					|| t_front.indexOf("jpeg") == -1
					|| t_front.indexOf("bmp") == -1 || t_front.indexOf("ico") == -1 || t_front.indexOf("png") == -1) {
				alert("上传的头像格式只能为gif、jpg、png、jpeg、bmp、ico");
				flag = false;
				return flag;
			}
		}
	}
	return flag;

}

function f_check(f) {
	return public_check(f, {
		"title" : "标题",
		"subject" : "主题",
		"content" : "正文"
	});
}

function tj_check(f) {
	return public_check(f, {
		"comment" : "评语"
	});
}
