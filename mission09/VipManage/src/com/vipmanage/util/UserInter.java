package com.vipmanage.util;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.vipmanage.model.User;
import com.vipmanage.service.UserService;

/**
 * 用户拦截器，用来拦截未登录的用户
 * 
 * @author Administrator
 *
 */
@Controller("userInter")
@Scope("prototype")
public class UserInter extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;

	// 用于拦截未登录的用户
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		Map session = (Map) invocation.getInvocationContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			return Action.LOGIN;
		}
		return invocation.invoke();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
