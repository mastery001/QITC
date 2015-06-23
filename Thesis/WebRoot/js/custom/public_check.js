function public_check(f , conditions) {
	var forms = f.getElementsByTagName("input");
	var flag = false;
	for(var i = 0 ; i < forms.length ; i ++) {
		var name = forms[i].name;
		var value = forms[i].value;
		var attributeValue;
		for(var key in conditions) {
			if(name == key) {
				attributeValue = conditions[key];
				flag = true;
				break;
			}
		}
		if(flag) {
			if(value == "") {
				alert(attributeValue  + "不能为空");
				forms[i].focus();
				return false;
			}
		}
	}
	return true;
}