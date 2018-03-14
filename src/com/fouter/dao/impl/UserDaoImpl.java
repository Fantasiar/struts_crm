package com.fouter.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fouter.dao.UserDao;
import com.fouter.domain.User;
import com.fouter.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User getByUserCode(String user_code) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		String hql="from User where user_code=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, user_code);
		User u=(User) query.uniqueResult();
		return u;
	}
	
}
