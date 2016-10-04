package com.hopline.WebApp.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.hopline.WebApp.model.dao.Category;

public class CategoryDao {
	
	private final SessionFactory sessionFactory;
	

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	public CategoryDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	public List<Category> retriveAllCategory() {
		return (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).list();
	}
	
//	@Override
//	public List<BmwAgreement> retrieveAgreement(int hceId) {
//		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BmwAgreement.class, "bmwAgreement");
//		criteria.createCriteria("bmwAgreement.healthcareEstablishment", "hce");
//		criteria.add(Restrictions.eq("hce.hceId", hceId));
//		criteria.add(Restrictions.eq("bmwAgreement.deleteInd",YESNO.NO.getCode()));
//
//		return (List<BmwAgreement>) criteria.list();
//	}
//	
	

}
