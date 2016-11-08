package com.jikexueyuan.login.springmvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jikexueyuan.login.springmvc.service.LoginService;

@Controller
public class LoginController {

	@Resource(name = "loginService")
	LoginService service;

	// 登录跳转
	@RequestMapping("index")
	public String toLogin() {
		return "login";
	}

	// 登录处理
	@RequestMapping("login")
	public String doLogin(String username, String password) {
		return service.doLogin(username, password);
	}
}
