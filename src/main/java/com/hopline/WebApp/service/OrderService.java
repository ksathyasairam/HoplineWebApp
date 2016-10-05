package com.hopline.WebApp.service;

import java.util.Calendar;
import java.util.Date;

import com.hopline.WebApp.constants.OrderStates;
import com.hopline.WebApp.dao.OrderDao;
import com.hopline.WebApp.model.dao.Order;
import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.rest.framework.IService;

public class OrderService extends IService {
	private OrderDao orderDao;
	
	public OrderVo createOrder(OrderVo orderVo) {
		
		return orderVo;
//		if (isDefaulter(orderVo))
		
		
	}

	private boolean isDefaulter(OrderVo orderVo) {
		
		Order lastOrder = orderDao.getLastUserOrder(orderVo.getUserId());
		
		if (lastOrder == null) return false;
		
		if (lastOrder.getPaidYn() == "Y") return false;
		
		return (lastOrder.getOrderState().equals(OrderStates.UNPICKED) || lastOrder.getOrderState().equals(OrderStates.DEFAULTER_CALL) 
				|| ( lastOrder.getOrderState().equals(OrderStates.READY_FOR_PICKUP) && lastOrder.getOrderTime().compareTo(getTime5HrAgo()) < 0 ) );
	}
	
	
	private boolean isBigOrder(OrderVo orderVo) {
		
		
		return false;
	}
	
	

	private Date getTime5HrAgo() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -5);
		Date date = cal.getTime();
		return date;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
