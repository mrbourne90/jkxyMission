function check(form) {
	if (document.getElementById("key").value.trim() == "") {
		document.getElementById("msg").innerHTML = "请输入关键字！";
		document.getElementById("key").focus();
		return false;
	} else {
		document.getElementById("msg").innerHTML = "";
	}
}
