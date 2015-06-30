window.onload=function() {
	var msg = document.getElementById('msg');
	if(msg.value != "") {
		alert(msg.value);
	}
};

function isDelete(url) {
	if (confirm("您确定要删除吗？")) {
		window.location.href = url;
		return true;
	}
	return false;
}