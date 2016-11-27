package com.hopline.WebApp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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


	public List<Integer> getFavouriteItems(Integer iduser) {

		String subQueryString = "select o.idorder from com.hopline.WebApp.model.dao.Order o where o.user.iduser=?";
		String queryString = "select p.product.productId, count(p.product.productId) from com.hopline.WebApp.model.dao.OrderProduct p where p.order.idorder  IN ("+subQueryString+")"
				+ " GROUP BY p.product.productId ORDER BY count(p.product.productId) DESC"; 
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter(0, iduser);
		query.setMaxResults(5);
		List<Object[]> queryResult= (List<Object[]>) query.list();

		List<Integer> result = new ArrayList<Integer>();
		
		for (Object[] obj : queryResult) {
			int productId = (Integer) obj[0];
			Long count = (Long) obj[1];
			if (count > 3) {
				result.add(productId);
			}
		}
		
		return result;
	}
	
	private class OrderItemCount{
			
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
