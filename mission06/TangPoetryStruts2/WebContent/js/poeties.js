function check(form) {
	if (document.forms.search.searchKey.value == "") {
		document.getElementById("msg").innerHTML = "请输入关键字！";
		document.forms.search.searchKey.focus();
		return false;
	}else{
		document.getElementById("msg").innerHTML = "";
	}
}

