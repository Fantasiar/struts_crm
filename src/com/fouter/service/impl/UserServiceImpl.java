package com.fouter.service.impl;

import javax.management.RuntimeErrorException;

import com.fouter.dao.UserDao;
import com.fouter.dao.impl.UserDaoImpl;
import com.fouter.domain.User;
import com.fouter.service.UserService;
import com.fouter.utils.HibernateUtils;

public class UserServiceImpl implements UserService {
	private UserDao ud=new UserDaoImpl();
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		HibernateUtils.getCurrentSession().beginTransaction();
		User existUser=ud.getByUserCode(user.getUser_code());
		HibernateUtils.getCurrentSession().getTransaction().commit();
		
		if (existUser==null) {
			throw new RuntimeException("用户名不存在!");
		}
		
		if (!existUser.getUser_password().equals(user.getUser_password())) {
			throw new RuntimeException("密码不正确！");
		}
		
		return existUser;
	}
	
}
