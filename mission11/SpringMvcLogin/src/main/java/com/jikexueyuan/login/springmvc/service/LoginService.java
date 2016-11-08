package com.jikexueyuan.login.springmvc.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jikexueyuan.login.springmvc.dao.impl.UserDao;
import com.jikexueyuan.login.springmvc.entity.User;

@Service("loginService")
public class LoginService implements ILoginService {

	@Resource(name="userDao")
	private UserDao userDao;
	
	public String doLogin(String uname, String password) {
		
		User user = userDao.findUser(uname, password);
		
		if(user != null){
			return "message";
		}
		else {
			return "error";
		}
	}
 
}
