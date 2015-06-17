function __checkall(name, flag) {
	var checkBoxs = document.getElementsByName(name);
	for ( var i = 0; i < checkBoxs.length; i++) {
		checkBoxs[i].checked = flag;
	}
}

function __commitAllcheck(action , name) {
	var form = document.getElementById("checkForm");
	var checkBoxs = document.getElementsByName(name);
	var flag = false;
	for ( var i = 0; i < checkBoxs.length; i++) {
		if(checkBoxs[i].checked == true) {
			flag = true;
			if(action.indexOf("?")) {
				action += "?" + name + "=" + checkBoxs[i].value;
			}else {
				action += "&" + name + "=" + checkBoxs[i].value;
			}
		}
	}
	if(!flag) {
		alert("请至少选择一条数据操作");
		return false;
	}
	form.action = action;
	form.submit();
}