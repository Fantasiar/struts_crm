package com.fouter.web.action;

import java.nio.file.attribute.UserPrincipalLookupService;

import com.fouter.domain.User;
import com.fouter.service.UserService;
import com.fouter.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user=new User();
	private UserService us=new UserServiceImpl();
	
	public String login() throws Exception {
		// TODO Auto-generated method stub
		User u=us.login(user);
		ActionContext.getContext().getSession().put("user", u);
		return "toHome";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
