package com.hopline.WebApp.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hopline.WebApp.constants.OrderStates;
import com.hopline.WebApp.dao.OrderDao;
import com.hopline.WebApp.endpoint.model.OrderStatus;
import com.hopline.WebApp.endpoint.model.OrderStatusList;
import com.hopline.WebApp.model.dao.AddOn;
import com.hopline.WebApp.model.dao.Order;
import com.hopline.WebApp.model.dao.OrderProduct;
import com.hopline.WebApp.model.dao.OrderProductAddon;
import com.hopline.WebApp.model.dao.OrderStatusLog;
import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.Constants;
import com.hopline.WebApp.rest.framework.IService;
import com.hopline.WebApp.rest.framework.Util;
import com.hopline.WebApp.translator.OrderTranslator;
import com.mysql.fabric.xmlrpc.base.Array;

public class OrderService extends IService {
//TODO : testing defaulter function and testng overall submit order.
	private OrderDao orderDao;

	private String returnPage;

	public OrderVo submitOrder(OrderVo orderVo) {

		Order order = orderDao.getOrder(orderVo.getIdorder());

		Double activeOrderPrice = activeOrderPrice(orderVo.getUser().getIduser());

		if (activeOrderPrice + orderVo.getTotalPrice() > Constants.BIG_ORDER_PAY_PRICE) {
			order.setOrderState(OrderStates.BIG_ORDER_PAY);
			setReturnPage(Constants.BIG_ORDER_PAY);
		} else if (activeOrderPrice + orderVo.getTotalPrice() > Constants.BIG_ORDER_CALL_PRICE) {
			order.setOrderState(OrderStates.BIG_ORDER_CALL);
			setReturnPage(Constants.YOUR_ORDER);
		} else if (isDefaulter(orderVo)) {
			order.setOrderState(OrderStates.DEFAULTER_CALL);
			setReturnPage(Constants.YOUR_ORDER);
		} else {
			order.setOrderState(OrderStates.OK_ORDER);
			setReturnPage(Constants.YOUR_ORDER);
		}								

		order.setOrderTime(new Date());
		order.setOrderCompleteTime(getOrderCompleteTime(order));
		order.setOrdersInQueue(orderDao.getNumbeOrdersInQueue(order.getIdorder()));
		orderDao.updateOrder(order);

		orderDao.saveOrderStatusLog(getOrderStatusLog(order));

		return OrderTranslator.toOrderVo(order);
	}



	private boolean isDefaulter(OrderVo orderVo) {

		Order lastOrder = orderDao.getLastUserOrder(orderVo.getUser().getIduser());

		if (lastOrder == null)
			return false;

		if (lastOrder.getPaidYn() == "Y")
			return false;

		return (lastOrder.getOrderState().equals(OrderStates.UNPICKED)
				|| lastOrder.getOrderState().equals(OrderStates.DEFAULTER_CALL)
				|| (lastOrder.getOrderState().equals(OrderStates.READY_FOR_PICKUP)
						&& lastOrder.getOrderTime().compareTo(Util.getUserSessionStartTime()) < 0));
	}

	private Double activeOrderPrice(int userId) {

		List<Order> orders = orderDao.getActiveUnpaidOrders(userId);

		Double sum = 0.0;
		for (Order order : orders) {
			sum += order.getTotalPrice().doubleValue();
		}
		return sum;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public OrderVo createTempOrder(OrderVo orderVo) {
		Order order = OrderTranslator.toOrder(orderVo);
		order.setOrderState(OrderStates.TEMP_SUBMIT);
		order.setPaidYn("N");
		order.setOrderCreator(Constants.ORDER_CREATOR_WEBSITE_CUSTOMER);
		order = createOrder(order);
		
		return OrderTranslator.toOrderVo(order);
	}
	
	public Order createOrder(Order order) {
		order.setOrderTime(new Date());
		order.setTotalItemCount(0);
		order.setTotalPrice(BigDecimal.valueOf(0));
		order.setOrdersInQueue(0);
		order.setOrderCompleteTime(0);
		Integer orderId = orderDao.saveOrder(order);
		
		for (OrderProduct op : order.getOrderProducts()) {
			Order tmpOrder = new Order();
			tmpOrder.setIdorder(orderId);
			op.setOrder(tmpOrder);
			Integer opId = orderDao.saveOrderProduct(op);
		
			
			//save addon
			OrderProduct tmpOp = new OrderProduct();
			tmpOp.setIdorderProduct(opId);
			if (op.getOrderProductAddons() != null) {
				for (OrderProductAddon orderProductAddon : op.getOrderProductAddons()) {
					orderProductAddon.setOrderProduct(tmpOp);
					orderDao.saveOrderProductAddon(orderProductAddon);
					
				}
			}
		
		
		}
		
		orderDao.refresh(order);
		order = orderDao.retrieveOrderById(orderId);
		order.setCustomerOrderId(orderId % 1000);

		order.setOrdersInQueue(orderDao.getNumbeOrdersInQueue(order.getIdorder()));
		order.setOrderCompleteTime(getOrderCompleteTime(order));
		
		populateItemCountAndPrice(order);
		orderDao.updateOrder(order);
		
		order.getOrderProducts().iterator().next().getProduct().getPrice();
		order = orderDao.retrieveOrderById(orderId);
		
		orderDao.saveOrderStatusLog(getOrderStatusLog(order));

		return order;
	}
	
	private Integer getOrderCompleteTime(Order order) {
		return 5;
	}



	public static OrderStatusLog getOrderStatusLog(Order order) {
		OrderStatusLog orderStatusLog = new OrderStatusLog();
		orderStatusLog.setOrderId(order.getIdorder());
		orderStatusLog.setOrderStatus(order.getOrderState());
		orderStatusLog.setTimestamp(new Date());
		return orderStatusLog;
	}

	private void populateItemCountAndPrice(Order order) {
		int totalItemCount = 0 ;
		double totalPrice = 0;
		for (OrderProduct orderProduct : order.getOrderProducts()) {
			orderDao.refresh(orderProduct);
			totalItemCount += orderProduct.getCount();
			
			double addonPrice = 0;
			if (orderProduct.getOrderProductAddons() != null) {
				for (OrderProductAddon orderProductAddon : orderProduct.getOrderProductAddons()) {
					orderDao.refresh(orderProductAddon);
					addonPrice += orderProductAddon.getAddOn().getPrice().doubleValue();
				}
			}
			
			totalPrice += orderProduct.getCount() * (orderProduct.getProduct().getPrice().doubleValue() + addonPrice ) ;
		}
		
		order.setTotalItemCount(totalItemCount);
		order.setTotalPrice(BigDecimal.valueOf(totalPrice));

	}
	
	public List<OrderVo> retrieveActiveOrders(UserVo userVo) {
		List<Order> orders = orderDao.getAllOrders(userVo.getIduser());
		
		List<OrderVo> orderVos = new ArrayList<OrderVo>();
		if (orders == null) return orderVos;
		
		for (Order order : orders){
			OrderVo orderVo = OrderTranslator.toOrderVo(order);
			orderVo.setNumUnitInProgressBar(order.getOrdersInQueue());
			
			Integer currentProgress = orderVo.getNumUnitInProgressBar() - orderDao.getNumbeOrdersInQueue(order.getIdorder());
			if (OrderStates.READY_FOR_PICKUP.equals(order.getOrderState()) || OrderStates.COMPLETED.equals(order.getOrderState()) ||
					OrderStates.CANCELLED.equals(order.getOrderState()) || OrderStates.UNPICKED.equals(order.getOrderState()) ){
				currentProgress = orderVo.getNumUnitInProgressBar();
			}
			
			orderVo.setCurrentProgress(currentProgress);
			orderVos.add(orderVo);
		}
		return orderVos;
	}
	
	public OrderStatusList retrieveOrdersStatus(Integer userId) {
		List<Order> orders = orderDao.getAllOrders(userId);
		
		OrderStatusList result = new OrderStatusList();
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		result.setOrderStatus(orderStatusList);
		
		if (orders == null) return result;
		
		for (Order order : orders){
			OrderStatus os = OrderTranslator.toOrderStatus(order);
			os.setNumUnitInProgressBar(order.getOrdersInQueue());
			os.setCurrentProgress(orderDao.getNumbeOrdersInQueue(order.getIdorder()));
			orderStatusList.add(os);
		}
		
		return result;
	}
	
	
	public String retrieveSingleOrderStatus(Integer orderId) {
		Order order = orderDao.retrieveOrderById(orderId);
		return order.getOrderState();
	}
	



	public String getReturnPage() {
		return returnPage;
	}



	public void setReturnPage(String returnPage) {
		this.returnPage = returnPage;
	}







}

