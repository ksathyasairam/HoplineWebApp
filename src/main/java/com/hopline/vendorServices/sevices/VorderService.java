package com.hopline.vendorServices.sevices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.hopline.WebApp.constants.OrderStates;
import com.hopline.WebApp.model.dao.OfflineOrderLog;
import com.hopline.WebApp.model.dao.Order;
import com.hopline.WebApp.model.dao.Product;
import com.hopline.WebApp.model.dao.ReqResLog;
import com.hopline.WebApp.model.dao.Shop;
import com.hopline.WebApp.model.vo.OrderProductVo;
import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.model.vo.ShopVo;
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
import com.hopline.vendorServices.model.OfflineOrderLogTo;
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
			order.setOrderTime(Util.getCurrentDateTimeIndia());
		
		if (orderStatus.getOrderCompletionTime() != null)
			order.setOrderCompleteTime(orderStatus.getOrderCompletionTime());

		orderDao.updateOrder(order);
		
		orderDao.saveOrderStatusLog(OrderService.getOrderStatusLog(order));
		
		if (OrderStates.PREPARING.equals(order.getOrderState())){
			Util.sendSMS(order.getUser().getPhone(),String.format(Constants.SMS_ORDER_CREATED_TEXT,order.getUser().getName(), order.getCustomerOrderId(), order.getShop().getShopName()));
		}else if (OrderStates.CANCELLED.equals(order.getOrderState())){
			Util.sendSMS(order.getUser().getPhone(), String.format(Constants.SMS_CANCELLED_TEXT,order.getCustomerOrderId(), orderStatus.getCancelReason()));
		}else if (OrderStates.READY_FOR_PICKUP.equals(order.getOrderState())){
			Util.sendSMS(order.getUser().getPhone(), String.format(Constants.SMS_ORDER_READY_TEXT,order.getUser().getName(), order.getCustomerOrderId(), order.getShop().getShopName()));
		}

		orderStatus.setSuccess(true);

		return orderStatus;
	}

	public FetchOrderTo retrieveOrders(FetchOrderTo fetchOrder) {
		ReqResLog log = new ReqResLog();
		log.setRequest(Util.toJson(fetchOrder));
		
		List<Order> orders = orderDao.retrieveOrdersByStates(fetchOrder.getShopId(), fetchOrder.getOrderStates());

		List<OrderVo> orderVos = new ArrayList<OrderVo>();
		fetchOrder.setOrders(orderVos);

		if (orders != null) {
			for (Order order : orders) {
				OrderVo vo = toOrderVo(order);
				orderVos.add(vo);
			}
		}

		fetchOrder.setSuccess(true);
		log.setResponse(Util.toJson(fetchOrder));
		log.setCreateTimestamp(Util.getCurrentDateTimeIndia());
		log.setActionName("FetchOrdersAction.execute");
		log.setShopId(fetchOrder.getShopId());
		orderDao.saveReqResLog(log);
		return fetchOrder;
	}
	
	private OrderVo toOrderVo(Order order) {
		OrderVo vo = OrderTranslator.convert(order, OrderVo.class);
		Collections.sort(vo.getOrderProducts(), new SortOrderProductByName());
		return vo;
		
	}

	class SortOrderProductByName implements Comparator<OrderProductVo> {
	    @Override
	    public int compare(OrderProductVo a, OrderProductVo b) {
	        return a.getProduct().getName().compareToIgnoreCase(b.getProduct().getName()); 
	    }
	}

	
	public FetchOrderTo retrieveOrderHistory(FetchOrderTo fetchOrder) {
		List<Order> orders = orderDao.retrieveOrderHistory(fetchOrder.getShopId());

		List<OrderVo> orderVos = new ArrayList<OrderVo>();
		fetchOrder.setOrders(orderVos);

		if (orders != null) {
			for (Order order : orders) {
				OrderVo vo = OrderTranslator.convert(order, OrderVo.class);
				Collections.sort(vo.getOrderProducts(), new SortOrderProductByName());
				orderVos.add(vo);
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
		order.setPaymentMethod(Constants.TEMP_PAYMENT);
		order.setOrderCreator(Constants.ORDER_CREATOR_VENDOR);
		order = ServiceLocator.getInstance().getService(OrderService.class).createOrder(order);
		
		Util.sendSMS(order.getUser().getPhone(),String.format(Constants.SMS_ORDER_CREATED_TEXT,order.getUser().getName(), order.getCustomerOrderId(), order.getShop().getShopName()));	
		
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
	
	public OfflineOrderLogTo createOfflineOrderLog(OfflineOrderLogTo offlineOrderLogTo) {
		
		OfflineOrderLog offlineOrderLog = new OfflineOrderLog();
		offlineOrderLog.setInsertTime(Util.getCurrentDateTimeIndia());
		offlineOrderLog.setOrdersJson(offlineOrderLogTo.getOrdersJson());
		
		orderDao.saveOfflineOrderLog(offlineOrderLog);
		offlineOrderLogTo.setSuccess(true);
		return offlineOrderLogTo;
	}

//	public OrderStatusTo markItemsPrepared(OrderStatusTo orderStatus) {
//		Order order = orderDao.getOrder(orderStatus.getOrderId());
//
//		boolean orderReady= true;
//		for (OrderProductVo orderProductVo : orderStatus.getOrderProductVoList()) {
//			if (! ("Y".equals(orderProductVo.getPreparedYN()) || orderProductVo.isChecked() )){
//				orderReady = false;
//				break;
//			}
//		}
//		
//		if (orderReady) {
//			order.setOrderState(OrderStates.READY_FOR_PICKUP);
//		}
//		
//		for (OrderProduct dbProduct : order.getOrderProducts()) 
//			for (OrderProductVo clientProduct : orderStatus.getOrderProductVoList()) {
//				if (dbProduct.getIdorderProduct().equals(clientProduct.getIdorderProduct())) {
//					if ("N".equals(dbProduct.getPreparedYN()) && clientProduct.isChecked()){
//						dbProduct.setPreparedYN("Y");
//					}
//				}
//			}
//		
//		
//		
//		orderDao.updateOrder(order);
//		orderDao.saveOrderStatusLog(OrderService.getOrderStatusLog(order));
//		
//
//		order = orderDao.getOrder(order.getIdorder());
//		OrderVo vo = toOrderVo(order);
//		orderStatus.setOrderProductVoList(vo.getOrderProducts());
//		orderStatus.setOrderStatus(OrderStates.READY_FOR_PICKUP);
//		orderStatus.setSuccess(true);
//
//		
////		if (OrderStates.PREPARING.equals(order.getOrderState())){
////			Util.sendSMS(order.getUser().getPhone(),String.format(Constants.SMS_ORDER_CREATED_TEXT,order.getUser().getName(), order.getShop().getShopName(), order.getCustomerOrderId()));
////		}else if (OrderStates.CANCELLED.equals(order.getOrderState())){
////			Util.sendSMS(order.getUser().getPhone(), String.format(Constants.SMS_CANCELLED_TEXT,order.getCustomerOrderId(), orderStatus.getCancelReason()));
////		}else if (OrderStates.READY_FOR_PICKUP.equals(order.getOrderState())){
////			Util.sendSMS(order.getUser().getPhone(), String.format(Constants.SMS_ORDER_READY_TEXT,order.getUser().getName(), order.getCustomerOrderId()));
////		}
//
//		return orderStatus;
//	}

	public OrderStatusTo notifyUserPartialOrder(OrderStatusTo orderStatus) {
		Order order = orderDao.getOrder(orderStatus.getOrderId());
		Util.sendSMS(order.getUser().getPhone(), String.format(Constants.SMS_ORDER_READY_TEXT,order.getUser().getName(), order.getCustomerOrderId(), order.getShop().getShopName()));
		orderStatus.setSuccess(true);
		return orderStatus;
	}

	public ShopVo loginVendor(ShopVo shopVo) {
		
		Shop shop = orderDao.retrieveShop(shopVo.getUsername(), shopVo.getPassword());
		
		if (shop == null) {
			shopVo.setSuccess(false);
			shopVo.setMsg("Invalind username Password combination");
			return shopVo;
		} else  {
			shopVo = OrderTranslator.convert(shop, ShopVo.class);
			shopVo.setSuccess(true);
		}
		
		return shopVo; 
	}

	public boolean updateFirebaseId(String firebaseId, Integer shopId) {
		Shop shop = orderDao.getShop(shopId);
		shop.setFirebaseId(firebaseId);
		orderDao.updateShop(shop);
		return true;
	}

}
