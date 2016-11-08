package com.vipmanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipmanage.model.User;
import com.vipmanage.repository.UserRepository;
import com.vipmanage.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User checkUser(User user) {
		return userRepository.checkUser(user);
	}

	@Override
	public Boolean activateUser(User user) {
		return userRepository.activateUser(user);
	}

	@Override
	public Boolean deactivateUser(User user) {
		return userRepository.deactivateUser(user);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
