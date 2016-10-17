package com.hopline.vendorServices.sevices;

import java.util.ArrayList;
import java.util.List;

import com.hopline.WebApp.model.dao.Order;
import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.rest.framework.IService;
import com.hopline.WebApp.translator.OrderTranslator;
import com.hopline.vendorServices.dao.VorderDao;
import com.hopline.vendorServices.model.FetchOrderTo;
import com.hopline.vendorServices.model.OrderStatusTo;
import com.hopline.vendorServices.model.OrderTo;

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

		orderDao.updateOrder(order);

		orderStatus.setSuccess(true);

		return orderStatus;
	}

	public FetchOrderTo retrieveOrders(FetchOrderTo fetchOrder) {
		List<Order> orders = orderDao.retrieveOrdersByStates(fetchOrder.getShopId(), fetchOrder.getOrderStates());

		List<OrderTo> orderTos = new ArrayList<OrderTo>();
		fetchOrder.setOrders(orderTos);

		if (orders != null) {
			for (Order order : orders) {
				orderTos.add(OrderTranslator.convert(order, OrderTo.class));
			}
		}

		fetchOrder.setSuccess(true);
		return fetchOrder;
	}

}
