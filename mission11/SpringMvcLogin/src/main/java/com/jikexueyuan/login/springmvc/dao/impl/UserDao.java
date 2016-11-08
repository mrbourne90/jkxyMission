package com.jikexueyuan.login.springmvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.jikexueyuan.login.springmvc.dao.IUserDao;
import com.jikexueyuan.login.springmvc.entity.User;

@Repository("userDao")
public class UserDao implements IUserDao {

	@Override
	public User findUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//若用户名密码符合 则返回用户信息
		if (user.getUsername().equals("admin") && user.getPassword().equals("123456")) {
			return user;
		}
		return null;
	}
}
