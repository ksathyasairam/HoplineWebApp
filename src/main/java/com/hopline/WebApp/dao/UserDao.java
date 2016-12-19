package com.hopline.WebApp.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.hopline.WebApp.model.dao.SecurityToken;
import com.hopline.WebApp.model.dao.User;

public class UserDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public UserDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getUserByPhone(String phone) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class, "user");
		criteria.add(Restrictions.eq("user.phone", phone));

		Object obj = criteria.uniqueResult();

		if (obj != null)
			return (User) obj;

		return null;
	}
	
	public User getUserByMacId(String mac) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class, "user");
		criteria.add(Restrictions.eq("user.mac", mac));

		Object obj = criteria.uniqueResult();

		if (obj != null)
			return (User) obj;

		return null;
	}

	public Integer saveUser(User user) {
		return (Integer) getSessionFactory().getCurrentSession().save(user);
	}
	public void udpateUser(User user) {
		getSessionFactory().getCurrentSession().update(user);
	}
}
