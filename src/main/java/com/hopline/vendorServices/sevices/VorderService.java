package com.hopline.vendorServices.sevices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hopline.WebApp.constants.OrderStates;
import com.hopline.WebApp.model.dao.Order;
import com.hopline.WebApp.model.dao.Product;
import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.Constants;
import com.hopline.WebApp.rest.framework.IService;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.rest.framework.Util;
import com.hopline.WebApp.service.LoginServiceImpl;
import com.hopline.WebApp.service.OrderService;
import com.hopline.WebApp.translator.OrderTranslator;
import com.hopline.vendorServices.dao.VorderDao;
import com.hopline.vendorServices.model.FetchOrderTo;
import com.hopline.vendorServices.model.OrderStatusTo;
import com.hopline.vendorServices.model.Stock;

public class VorderService extends IService {
	private VorderDao orderDao;

	public VorderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(VorderDao orderDao) {
		this.orderDao = orderDao;
	}

	public OrderStatusTo udpateOrderStatus(OrderStatusTo orderStatus) {

		Order order = orderDao.getOrder(orderStatus.getOrderId());

		if (orderStatus.getOrderStatus() != null && !orderStatus.getOrderStatus().isEmpty())
			order.setOrderState(orderStatus.getOrderStatus());

		if (orderStatus.getPaidYN() != null && !orderStatus.getPaidYN().isEmpty())
			order.setPaidYn(orderStatus.getPaidYN());

		if (orderStatus.getCancelReason() != null && !orderStatus.getCancelReason().isEmpty())
			order.setCancelReason(orderStatus.getCancelReason());
		
		if(orderStatus.isUpdateOrderTime())
			order.setOrderTime(new Date());

		orderDao.updateOrder(order);
		
		if (OrderStates.PREPARING.equals(order.getOrderState())){
			Util.sendSMS(order.getUser().getPhone(),String.format(Constants.SMS_ORDER_CREATED_TEXT,order.getUser().getName(), order.getShop().getShopName(), order.getCustomerOrderId()));
		}else if (OrderStates.CANCELLED.equals(order.getOrderState())){
			Util.sendSMS(order.getUser().getPhone(), String.format(Constants.SMS_CANCELLED_TEXT,order.getCustomerOrderId(), orderStatus.getCancelReason()));
		}else if (OrderStates.READY_FOR_PICKUP.equals(order.getOrderState())){
			Util.sendSMS(order.getUser().getPhone(), String.format(Constants.SMS_ORDER_READY_TEXT,order.getUser().getName(), order.getCustomerOrderId()));
		}

		orderStatus.setSuccess(true);

		return orderStatus;
	}

	public FetchOrderTo retrieveOrders(FetchOrderTo fetchOrder) {
		List<Order> orders = orderDao.retrieveOrdersByStates(fetchOrder.getShopId(), fetchOrder.getOrderStates());

		List<OrderVo> orderVos = new ArrayList<OrderVo>();
		fetchOrder.setOrders(orderVos);

		if (orders != null) {
			for (Order order : orders) {
				orderVos.add(OrderTranslator.convert(order, OrderVo.class));
			}
		}

		fetchOrder.setSuccess(true);
		return fetchOrder;
	}

	public OrderVo createWalkInOrder(OrderVo orderVo) {
				
		UserVo user = ServiceLocator.getInstance().getService(LoginServiceImpl.class).login(orderVo.getUser());
		orderVo.setUser(user);
		
		Order order = OrderTranslator.toOrder(orderVo);
		order.setOrderState(OrderStates.PREPARING);
		order.setPaidYn("Y");
		order.setOrderCreator(Constants.ORDER_CREATOR_VENDOR);
		order = ServiceLocator.getInstance().getService(OrderService.class).createOrder(order);
		
		Util.sendSMS(order.getUser().getPhone(),String.format(Constants.SMS_ORDER_CREATED_TEXT,order.getUser().getName(), order.getShop().getShopName(), order.getCustomerOrderId()));	
		
		orderVo = OrderTranslator.toOrderVo(order);
		
		return orderVo;
	}

	public Stock udpateStock(Stock stock) {
		
		Product product = orderDao.getProductByid(stock.getProductId());
		
		product.setStockYn(stock.getStockYN());
		
		orderDao.saveProduct(product);
		stock.setSuccess(true);
		return stock;
	}

}
