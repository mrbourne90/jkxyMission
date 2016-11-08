package com.vipmanage.service;

import com.vipmanage.model.User;

public interface UserService {

	public User checkUser(User user);

	public Boolean activateUser(User user);

	public Boolean deactivateUser(User user);

}
