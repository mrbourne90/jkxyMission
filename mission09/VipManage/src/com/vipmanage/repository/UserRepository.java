package com.vipmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vipmanage.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// 根据用户名 密码检查用户是否存在
	public User checkUser(User user);

	// 恢复一名用户的权限
	public Boolean activateUser(User user);

	// 禁用一名用户
	public Boolean deactivateUser(User user);
}
