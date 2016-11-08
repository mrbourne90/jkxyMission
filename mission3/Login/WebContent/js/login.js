/**
 * 检查用户名是否为空
 */
function checkUserName(){
	document.getElementById("note").innerHTML = "";
	var userName = String(document.getElementById("userName").value);
	if(userName == ""){
		document.getElementById("note").innerHTML = "请输入用户名！";
	}
	checkSubmit();
}

/**
 * 检查密码是否为空
 */
function checkPassword(){
	document.getElementById("note").innerHTML = "";
	var password = String(document.getElementById("password").value);
	if(password == ""){
		document.getElementById("note").innerHTML = "请输入密码！";
	}
	checkSubmit();
}

/**
 * 检查用户名密码是否都不为空，满足条件允许提交
 */
function checkSubmit(){
	var userName = String(document.getElementById("userName").value);
	var password = String(document.getElementById("password").value);
	if(userName != "" && password != ""){
		document.getElementById("submit").disabled = false;
	}
}
/*
 * 防止点击重置按钮后提交按钮变为可用
 */
function checkReset(){
	document.getElementById("submit").disabled = true;
}
