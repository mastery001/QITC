function t_check(f) {
	return public_check(f , {"document" : "上传的论文文档" ,"t_name" : "文件名称" , "description" : "文档简介"});
}

function f_check(f) {
	return public_check(f , {"title" : "标题" ,"subject" : "主题" , "content" : "正文"});
}

function tj_check(f) {
	return public_check(f , {"comment" : "评语"});
}
