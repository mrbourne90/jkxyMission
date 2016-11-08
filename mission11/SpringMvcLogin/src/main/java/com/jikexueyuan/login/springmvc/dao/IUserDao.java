package com.jikexueyuan.login.springmvc.dao;

import com.jikexueyuan.login.springmvc.entity.User;

public interface IUserDao {

	public User findUser(String username, String password);
}
