package com.hopline.WebApp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.hopline.WebApp.constants.OrderStates;
import com.hopline.WebApp.model.dao.Feedback;
import com.hopline.WebApp.model.dao.Order;
import com.hopline.WebApp.model.dao.OrderProduct;
import com.hopline.WebApp.model.dao.OrderProductAddon;
import com.hopline.WebApp.model.dao.OrderStatusLog;
import com.hopline.WebApp.rest.framework.Util;

public class OrderDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public OrderDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void flush(){
		sessionFactory.getCurrentSession().flush();
	}

	//TODO : test
	public Order getLastUserOrder(int userId, Integer shopId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class, "order");
		criteria.add(Restrictions.not(Restrictions.eq("order.orderState", OrderStates.TEMP_SUBMIT)));
		criteria.createCriteria("order.user", "user");
		criteria.add(Restrictions.eq("user.iduser", userId));
		
		criteria.createCriteria("order.shop", "shop");
		criteria.add(Restrictions.eq("shop.idshop", shopId));
		
		criteria.addOrder(org.hibernate.criterion.Order.desc("order.orderTime"));
		criteria.setMaxResults(1);
		return (Order) criteria.uniqueResult();
	}

	public Integer getMaxOrderId() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class, "order");
		criteria.setMaxResults(1);
		Order order = (Order) criteria.uniqueResult();
		
		if (order == null)
			return 1;
		return order.getIdorder();
	}

	//TODO : test
	public List<Order> getActiveUnpaidOrders(int userId, Integer shopId) {
		String queryString = "from com.hopline.WebApp.model.dao.Order r where r.user.iduser = ? and r.shop.idshop = ? and (r.orderState = ? or r.orderState = ? or r.orderState = ?"
				+ "or r.orderState = ? or r.orderState = ? or ( r.orderState = ? and r.orderTime > ?)) and r.paidYn='N' ";

		Query query = sessionFactory.getCurrentSession().createQuery(queryString);

		query.setParameter(0, userId);
		query.setParameter(1, shopId);
		query.setParameter(2, OrderStates.BIG_ORDER_PAY);
		query.setParameter(3, OrderStates.BIG_ORDER_CALL);
		query.setParameter(4, OrderStates.DEFAULTER_CALL);
		query.setParameter(5, OrderStates.OK_ORDER);
		query.setParameter(6, OrderStates.PREPARING);
		query.setParameter(7, OrderStates.READY_FOR_PICKUP);
		query.setParameter(8, Util.getUserSessionStartTime());

		return (List<Order>) query.list();
	}
	
	public List<Order> getAllOrders(int userId) {
		String queryString = "from com.hopline.WebApp.model.dao.Order r where r.user.iduser = ? and r.orderState <> ? and r.orderTime > ? ORDER BY r.orderTime DESC";

		Query query = sessionFactory.getCurrentSession().createQuery(queryString);

		query.setParameter(0, userId);
		query.setParameter(1, OrderStates.TEMP_SUBMIT);
		query.setParameter(2, Util.getUserSessionStartTime());

		return (List<Order>) query.list();
	}
	//TODO : test
	public int getNumbeOrdersInQueue(int idOrder, Integer shopId) {
		String queryString = "select count(*) from com.hopline.WebApp.model.dao.Order r where r.shop.idshop = ? and r.idorder <= ? and r.orderTime > ? and (r.orderState = ? or r.orderState = ? or r.orderState = ?"
				+ "or r.orderState = ? or r.orderState = ?)";

		Query query = sessionFactory.getCurrentSession().createQuery(queryString);

		query.setParameter(0, idOrder);
		query.setParameter(1, idOrder);
		query.setParameter(2, Util.getUserSessionStartTime());
		query.setParameter(3, OrderStates.BIG_ORDER_CALL);
		query.setParameter(4, OrderStates.DEFAULTER_CALL);
		query.setParameter(5, OrderStates.OK_ORDER);
		query.setParameter(6, OrderStates.PREPARING);
		query.setParameter(7, OrderStates.BIG_ORDER_PAY);

		Long res = (Long)query.uniqueResult();
		if (res == null) return 0;
		return Util.safeLongToInt(res) ;
	}
	
	public int getItemsToPerpareInQueue(int idOrder) {
		
		
		String subQueryString = "select r.idorder from com.hopline.WebApp.model.dao.Order r where r.idorder <= ? and r.orderTime > ? and (r.orderState = ? or r.orderState = ? or r.orderState = ?"
				+ "or r.orderState = ? or r.orderState = ?)";
		
		String queryString = "select sum(p.count) from com.hopline.WebApp.model.dao.OrderProduct p where p.order.idorder  IN ("+subQueryString+")";
				
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		
		query.setParameter(0, idOrder);
		query.setParameter(1, Util.getUserSessionStartTime());
		query.setParameter(2, OrderStates.BIG_ORDER_CALL);
		query.setParameter(3, OrderStates.DEFAULTER_CALL);
		query.setParameter(4, OrderStates.OK_ORDER);
		query.setParameter(5, OrderStates.PREPARING);
		query.setParameter(6, OrderStates.BIG_ORDER_PAY);
		
		Long res = (Long)query.uniqueResult();
		if (res == null) return 0;
		return Util.safeLongToInt(res) ;
	}
	
	
	
	public Integer saveOrder(Order order) {
		return (Integer) getSessionFactory().getCurrentSession().save(order);
	}
	
	public Integer saveOrderProduct(OrderProduct orderProduct) {
		return (Integer) getSessionFactory().getCurrentSession().save(orderProduct);
	}
	
	public void updateOrder(Order order) {
		getSessionFactory().getCurrentSession().saveOrUpdate(order);
	}
	
	public void refresh(Object obj) {
		sessionFactory.getCurrentSession().refresh(obj);
	}
	
	public Order retrieveOrderById(int orderId) {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class, "o");
	criteria.add(Restrictions.eq("o.idorder", orderId));
	Order order = (Order) criteria.uniqueResult();
	return order;
}

	public Integer saveOrderProductAddon(OrderProductAddon orderProductAddon) {
		return (Integer) getSessionFactory().getCurrentSession().save(orderProductAddon);
		
	}

	public Order getOrder(Integer idorder) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class, "order");
		criteria.add(Restrictions.eq("order.idorder", idorder));
		return (Order) criteria.uniqueResult();
	}
	
	public Integer saveOrderStatusLog(OrderStatusLog orderStatusLog) {
		return (Integer) getSessionFactory().getCurrentSession().save(orderStatusLog);
	}
	
	public Integer saveFeedback(Feedback feedback) {
		return (Integer) getSessionFactory().getCurrentSession().save(feedback);
	}
//	public Shop retrieveShopById(int shopId) {
//		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Shop.class, "s");
//		criteria.add(Restrictions.eq("s.idshop", shopId));
//		return (Shop) criteria.uniqueResult();
//	}
//	
//	public Product retrieveProductById(int productId) {
//		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class, "p");
//		criteria.add(Restrictions.eq("p.productId", productId));
//		return (Product) criteria.uniqueResult();
//	}
//	
//	public AddOn retrieveAddonId(int addonId) {
//		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AddOn.class, "a");
//		criteria.add(Restrictions.eq("a.idaddOn", addonId));
//		return (AddOn) criteria.uniqueResult();
//	}
//	
//	public AddOn retrieveUserById(int userId) {
//		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AddOn.class, "a");
//		criteria.add(Restrictions.eq("a.idaddOn", userId));
//		return (AddOn) criteria.uniqueResult();
//	}
	

	// public SecurityToken getTokenbyUserId(Integer userId) {
	// Criteria criteria =
	// sessionFactory.getCurrentSession().createCriteria(SecurityToken.class,
	// "sc");
	// criteria.createCriteria("sc.user", "user");
	// criteria.add(Restrictions.eq("user.iduser", userId));
	//
	// Object obj = criteria.uniqueResult();
	//
	// if (obj != null)
	// return (SecurityToken) obj;
	//
	// return null;
	// }
	//
	// public SecurityToken getTokenbyTokenString(String tokenString) {
	// Criteria criteria =
	// sessionFactory.getCurrentSession().createCriteria(SecurityToken.class,
	// "sc");
	// criteria.add(Restrictions.eq("sc.securityToken", tokenString));
	//
	// return (SecurityToken) criteria.uniqueResult();
	// }

	// public Integer saveToken(SecurityToken token) {
	// return (Integer) getSessionFactory().getCurrentSession().save(token);
	// }

	// public void delete(int userId) {
	// Query q = sessionFactory.getCurrentSession().createQuery("delete
	// SecurityToken as s where s.user.iduser = :uid");
	// q.setInteger("uid", userId);
	// q.executeUpdate();
	// }

}

