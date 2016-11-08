package com.vipmanage.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vipmanage.model.User;
import com.vipmanage.service.UserService;

//声明prototype类型的action并实例化bean
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	// 自动装配
	@Resource
	private UserService userService;
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	public String check() {
		// 根据用户名密码查看用户是否存在
		User checkedUser = userService.checkUser(user);
		// 将有效用户放入session中
		Map session = ActionContext.getContext().getSession();
		if (checkedUser != null) {
			session.put("user", checkedUser);
			return "check_success";
		} else {
			session.put("msg", "用户名或密码错误！");
			return "check_error";
		}
	}

	public String logout() {
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		return "logout_success";
	}

	public String activate() {

		if (userService.activateUser(user)) {
			return "activate_success";
		} else {
			return "activate_error";
		}
	}

	public String deactivate() {

		if (userService.deactivateUser(user)) {
			return "deactivate_success";
		} else {
			return "deactivate_error";
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
