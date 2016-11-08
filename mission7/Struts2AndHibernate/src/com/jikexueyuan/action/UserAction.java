package com.jikexueyuan.action;

import java.util.List;

import com.jikexueyuan.entity.User;
import com.jikexueyuan.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	// 登录结果
	private String loginResult;
	// 注册结果
	private String regResult;
	// 当前用户或选中用户
	private User user = new User();
	// 所有用户
	private List<User> users;
	// 选中用户id
	private int id;
	// 使用的用户服务
	private UserService userService = new UserService();

	// 用户登录
	public String login() {
		if ((user = userService.findUnique(user.getUserName(), user.getPassword())) != null) {
			loginResult = "success";
			return "loginSuccess";
		} else {
			loginResult = "fail";
			return "loginFail";
		}
	}

	// 用户注册
	public String register() {
		userService.save(user);
		setRegResult("success");
		return "regSuccess";
	}

	// 用户列表
	public String show() {
		users = userService.findAll();
		return "showSuccess";
	}

	// 根据id获取某个用户
	public String get() {
		user = userService.get(user.getId());
		return "getSuccess";
	}

	// 根据id删除某个用户
	public String delete() {
		userService.delete(user.getId());
		users = userService.findAll();
		return "deleteSuccess";
	}

	public String getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}

	public String getRegResult() {
		return regResult;
	}

	public void setRegResult(String regResult) {
		this.regResult = regResult;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public User getModel() {
		return user;
	}

}
