package com.hopline.WebApp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.struts2.ServletActionContext;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.hopline.WebApp.action.BaseAction;
import com.hopline.WebApp.action.LoginAction;
import com.hopline.WebApp.constants.OrderStates;
import com.hopline.WebApp.dao.OrderDao;
import com.hopline.WebApp.endpoint.model.OrderStatus;
import com.hopline.WebApp.endpoint.model.OrderStatusList;
import com.hopline.WebApp.model.dao.Feedback;
import com.hopline.WebApp.model.dao.OnlineTransaction;
import com.hopline.WebApp.model.dao.Order;
import com.hopline.WebApp.model.dao.OrderProduct;
import com.hopline.WebApp.model.dao.OrderProductAddon;
import com.hopline.WebApp.model.dao.OrderStatusLog;
import com.hopline.WebApp.model.vo.FeedbackVo;
import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.Config;
import com.hopline.WebApp.rest.framework.Constants;
import com.hopline.WebApp.rest.framework.IService;
import com.hopline.WebApp.rest.framework.Util;
import com.hopline.WebApp.translator.OrderTranslator;

public class OrderService extends IService {
	// TODO : testing defaulter function and testng overall submit order.
	private OrderDao orderDao;

	private String returnPage;

	public OrderVo submitOrder(OrderVo orderVo, String paymentMethod) {

		Order order = orderDao.getOrder(orderVo.getIdorder());

		if (Constants.PAYMENT_METHOD_ONLINE.equals(paymentMethod)) {
			order.setPaymentMethod(Constants.PAYMENT_METHOD_ONLINE);
			order.setPaidYn("Y");
			order.setOrderState(OrderStates.OK_ORDER);
			setReturnPage(Constants.YOUR_ORDER);
		} else {
			order.setPaymentMethod(Constants.PAYMENT_METHOD_PICKUP_CASH);
			order.setPaidYn("N");

			Double activeOrderPrice = activeOrderPrice(orderVo.getUser().getIduser(), order.getShop().getIdshop());

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

		}
		
		
		order.setOrderTime(Util.getCurrentDateTimeIndia());
		order.setOrderCompleteTime(null);
		order.setOrdersInQueue(orderDao.getNumbeOrdersInQueue(order.getIdorder(), order.getShop().getIdshop()));
		orderDao.updateOrder(order);

		orderDao.saveOrderStatusLog(getOrderStatusLog(order));
		sendPost(order.getShop().getFirebaseId());

		return OrderTranslator.toOrderVo(order);
	}

	// HTTP POST request
	private void sendPost(String to){
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost("https://fcm.googleapis.com/fcm/send");

			StringEntity input = new StringEntity("{ \n    \"data\": {\n    \"score\": \"5x1\",\n    \"time\": \"15:10\"\n  },\n  \"to\" : \""+ to +"\"\n}");
			input.setContentType("application/json");
			postRequest.setEntity(input);
			postRequest.addHeader("Authorization", Config.FIREBASE_API_KEY);

			HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	

	private boolean isDefaulter(OrderVo orderVo) {

		Order lastOrder = orderDao.getLastUserOrder(orderVo.getUser().getIduser(), orderVo.getShop().getIdshop());

		if (lastOrder == null)
			return false;

		if (lastOrder.getPaidYn() == "Y")
			return false;

		return (lastOrder.getOrderState().equals(OrderStates.UNPICKED)
				|| lastOrder.getOrderState().equals(OrderStates.DEFAULTER_CALL)
				|| (lastOrder.getOrderState().equals(OrderStates.READY_FOR_PICKUP)
						&& lastOrder.getOrderTime().compareTo(Util.getUserSessionStartTime()) < 0));
	}

	private Double activeOrderPrice(int userId, Integer shopId) {

		List<Order> orders = orderDao.getActiveUnpaidOrders(userId, shopId);

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
		order.setPaymentMethod(Constants.TEMP_PAYMENT);
		order.setPaidYn("N");
		order.setOrderCreator(Constants.ORDER_CREATOR_WEBSITE_CUSTOMER);
		order = createOrder(order);

		return OrderTranslator.toOrderVo(order);
	}

	public Order createOrder(Order order) {
		order.setOrderTime(Util.getCurrentDateTimeIndia());
		order.setTotalItemCount(0);
		order.setTotalPrice(BigDecimal.valueOf(0));
		order.setOrdersInQueue(0);
		order.setOrderCompleteTime(null);
		order.setPaymentSettledYN("N");
		Integer orderId = orderDao.saveOrder(order);

		for (OrderProduct op : order.getOrderProducts()) {
			Order tmpOrder = new Order();
			tmpOrder.setIdorder(orderId);
			op.setOrder(tmpOrder);
			op.setPreparedYN("N");
			Integer opId = orderDao.saveOrderProduct(op);

			// save addon
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

		order.setOrdersInQueue(orderDao.getNumbeOrdersInQueue(order.getIdorder(), order.getShop().getIdshop()));
		order.setOrderCompleteTime(null);

		populateItemCountAndPrice(order);
		orderDao.updateOrder(order);

		order.getOrderProducts().iterator().next().getProduct().getPrice();
		order = orderDao.retrieveOrderById(orderId);

		orderDao.saveOrderStatusLog(getOrderStatusLog(order));

		return order;
	}

	private Integer getOrderCompleteTime(Order order) {
		int itemsCount = orderDao.getItemsToPerpareInQueue(order.getIdorder());

		int time = (int) (itemsCount * 1.5);

		time = (time / 5) * 5 + (time % 5 == 0 ? 0 : 5);
		return time;
	}

	public static OrderStatusLog getOrderStatusLog(Order order) {
		OrderStatusLog orderStatusLog = new OrderStatusLog();
		orderStatusLog.setOrderId(order.getIdorder());
		orderStatusLog.setOrderStatus(order.getOrderState());
		orderStatusLog.setTimestamp(Util.getCurrentDateTimeIndia());
		return orderStatusLog;
	}

	private void populateItemCountAndPrice(Order order) {
		int totalItemCount = 0;
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

			totalPrice += orderProduct.getCount() * (orderProduct.getProduct().getPrice().doubleValue() + addonPrice);
		}

		order.setTotalItemCount(totalItemCount);
		order.setTotalPrice(BigDecimal.valueOf(totalPrice));

	}

	public List<OrderVo> retrieveActiveOrders(UserVo userVo) {
		List<Order> orders = orderDao.getAllOrders(userVo.getIduser());

		List<OrderVo> orderVos = new ArrayList<OrderVo>();
		if (orders == null)
			return orderVos;

		for (Order order : orders) {
			OrderVo orderVo = OrderTranslator.toOrderVo(order);
			orderVo.setNumUnitInProgressBar(order.getOrdersInQueue());
			orderVo.setCurrentProgress(getCurrentProgressBar(order));
			orderVos.add(orderVo);
		}
		return orderVos;
	}

	private Integer getCurrentProgressBar(Order order) {
		Integer currentProgress = order.getOrdersInQueue()
				- orderDao.getNumbeOrdersInQueue(order.getIdorder(), order.getShop().getIdshop());
		if (OrderStates.READY_FOR_PICKUP.equals(order.getOrderState())
				|| OrderStates.COMPLETED.equals(order.getOrderState())
				|| OrderStates.CANCELLED.equals(order.getOrderState())
				|| OrderStates.UNPICKED.equals(order.getOrderState())) {
			currentProgress = order.getOrdersInQueue();
		}
		return currentProgress;
	}

	public OrderStatusList retrieveOrdersStatus(Integer userId) {
		List<Order> orders = orderDao.getAllOrders(userId);

		OrderStatusList result = new OrderStatusList();
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		result.setOrderStatus(orderStatusList);

		if (orders == null)
			return result;

		for (Order order : orders) {
			OrderStatus os = OrderTranslator.toOrderStatus(order);
			os.setNumUnitInProgressBar(order.getOrdersInQueue());
			os.setCurrentProgress(getCurrentProgressBar(order));
			orderStatusList.add(os);
		}

		return result;
	}

	public String retrieveSingleOrderStatus(Integer orderId) {
		Order order = orderDao.retrieveOrderById(orderId);
		return order.getOrderState();
	}

	public void saveOnlineTransaction() throws ParseException {
		Map<String, String[]> parameters = ServletActionContext.getRequest().getParameterMap();

		// DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// Date addedOnd = Util.gmtToAsia(df.parse(
		// parameters.get("addedon")[0].toString()));

		OnlineTransaction transaction = new OnlineTransaction(parameters.get("txnid")[0].toString(),
				parameters.get("firstname")[0].toString(), parameters.get("phone")[0].toString(),
				parameters.get("key")[0].toString(), parameters.get("mode")[0].toString(),
				parameters.get("status")[0].toString(), parameters.get("unmappedstatus")[0].toString(),
				parameters.get("cardCategory")[0].toString(), parameters.get("addedon")[0].toString(),
				parameters.get("payment_source")[0].toString(), parameters.get("PG_TYPE")[0].toString(),
				parameters.get("bank_ref_num")[0].toString(), parameters.get("bankcode")[0].toString(),
				parameters.get("error")[0].toString(), parameters.get("error_Message")[0].toString(),
				parameters.get("name_on_card")[0].toString(), parameters.get("cardnum")[0].toString(),
				parameters.get("issuing_bank")[0].toString(), parameters.get("card_type")[0].toString(),
				parameters.get("easepayid")[0].toString(), parameters.get("amount")[0].toString(),
				parameters.get("net_amount_debit")[0].toString(), parameters.get("cash_back_percentage")[0].toString(),
				parameters.get("deduction_percentage")[0].toString(), parameters.get("surl")[0].toString(),
				parameters.get("furl")[0].toString(), parameters.get("hash")[0].toString(),
				Integer.valueOf(parameters.get("productinfo")[0]), Util.getCurrentDateTimeIndia());

		orderDao.saveOnlineTransaction(transaction);
	}

	public String getReturnPage() {
		return returnPage;
	}

	public void setReturnPage(String returnPage) {
		this.returnPage = returnPage;
	}

	public void createFeedback(FeedbackVo feedbackVo) {
		Mapper mapper = new DozerBeanMapper();
		Feedback feedback = mapper.map(feedbackVo, Feedback.class);

		orderDao.saveFeedback(feedback);
	}

}
