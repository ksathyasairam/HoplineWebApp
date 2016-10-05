package com.hopline.WebApp.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.hopline.WebApp.model.dao.SecurityToken;

public class SecurityDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public SecurityDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SecurityToken getTokenbyUserId(Integer userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SecurityToken.class, "sc");
		criteria.createCriteria("sc.user", "user");
		criteria.add(Restrictions.eq("user.iduser", userId));

		Object obj = criteria.uniqueResult();
		
		if (obj != null)
			return (SecurityToken) obj;
		
		return null;
	}
	
	public SecurityToken getTokenbyTokenString(String tokenString) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SecurityToken.class, "sc");
		criteria.add(Restrictions.eq("sc.securityToken", tokenString));

		return (SecurityToken) criteria.uniqueResult();
	}

	public Integer saveToken(SecurityToken token) {
		return (Integer) getSessionFactory().getCurrentSession().save(token);
	}
	
	public void delete(int userId) {
		Query q = sessionFactory.getCurrentSession().createQuery("delete SecurityToken as s where s.user.iduser = :uid");
		q.setInteger("uid", userId);
		q.executeUpdate();
	}

}
