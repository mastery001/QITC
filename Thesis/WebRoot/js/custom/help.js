function correctRadio(name, value) {
	var radioModule = document.getElementsByName(name);
	for ( var i = 0; i < radioModule.length; i++) {
		if (radioModule[i].value == value) {
			radioModule[i].checked = true;
			break;
		}
	}
}

function correctSelect(name, value) {
	var selectModule = document.getElementsByName(name)[0];
	for(var i = 0 ; i < selectModule.options.length ; i++) {
		if(selectModule.options[i].value == value) {
			selectModule.options[i].selected=true;
			break;
		}
		
	}
}