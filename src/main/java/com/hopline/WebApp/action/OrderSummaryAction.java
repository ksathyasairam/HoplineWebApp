package com.hopline.WebApp.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.hopline.WebApp.interceptors.SecurityInterceptor;
import com.hopline.WebApp.model.vo.OrderVo;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.Config;
import com.hopline.WebApp.rest.framework.Constants;
import com.hopline.WebApp.rest.framework.ServiceLocator;
import com.hopline.WebApp.rest.framework.Util;
import com.hopline.WebApp.service.OrderService;
import com.opensymphony.xwork2.Action;

public class OrderSummaryAction extends BaseAction {
	private OrderVo order;

	private String lastPaymentFailed;

	@Override
	public boolean loginRequired() {
		return true;
	}

	public String executeOrderSummaryOnLoadGetRequest() {
		disableBrowserCache();
		if (getSession().get("order") == null)
			return REDIRECT_HOME;
		order = (OrderVo) getSession().get("order");

		return Action.SUCCESS;
	}

	public String executeOrderSummaryOnLoad() {
		disableBrowserCache();
		if (!validateOnLoad())
			return REDIRECT_HOME;
		UserVo user = (UserVo) getSession().get(SecurityInterceptor.SESSION_USER);
		order.setUser(user);
		// TODO : use user from session add.
		setOrder(ServiceLocator.getInstance().getService(OrderService.class).createTempOrder(getOrder()));
		getSession().put("order", getOrder());
		return Action.SUCCESS;
	}

	public String executeOrderSummaryNext() {
		OrderService service = ServiceLocator.getInstance().getService(OrderService.class);
		if (getSession().get("order") == null)
			return REDIRECT_HOME;

		if (isOnlinePayment()) {
			service.saveOnlineTransaction();

			if (!paymentSucessful())
				return "paymentFailed";

			setOrder(service.submitOrder((OrderVo) getSession().get("order"), Constants.PAYMENT_METHOD_ONLINE));
		} else	{
			setOrder(service.submitOrder((OrderVo) getSession().get("order"), Constants.PAYMENT_METHOD_PICKUP_CASH));
		}

		getSession().put("order", null);

		return service.getReturnPage();
	}

	private boolean paymentSucessful() {
		 Map<String, String[]> parameters =  ServletActionContext.getRequest().getParameterMap();


		String hashSequence = "status|udf10|udf9|udf8|udf7|udf6|udf5|udf4|udf3|udf2|udf1|email|firstname|productinfo|amount|txnid|key";

		String hashString = Config.EZEBUZZ_SALT + "|";
		String[] hashVarSeq = hashSequence.split("\\|");

		for (String part : hashVarSeq) {
			String val = parameters.get(part)[0].toString();
			hashString = (Util.empty(val)) ? hashString.concat("") : hashString.concat(val);
			hashString = hashString.concat("|");
		}
		hashString = hashString.substring(0, hashString.length() - 1);

		String hash = Util.hashCal("SHA-512", hashString);

		
		return (hash.equals(parameters.get("hash")[0].toString()) && "success".equals(parameters.get("status")[0].toString()));
//			response.sendRedirect("/orderSummaryNext?lastPaymentFailed=false");
//		} else {
//			response.sendRedirect("/orderSummaryOnLoadGet?lastPaymentFailed=true");
//		} 

	}

	private boolean isOnlinePayment() {
		 Map<String, String[]> parameters =  ServletActionContext.getRequest().getParameterMap();
		 return parameters.containsKey("txnid");
	}

	public String executeOnlinePaymentNext() {
		if (getSession().get("order") == null)
			return REDIRECT_HOME;
		order = (OrderVo) getSession().get("order");
		return SUCCESS;
	}

	private boolean validateOnLoad() {
		boolean valid = Util.validateOrder(order);
		setInvalidInput(!valid);
		return valid;

	}

	public OrderVo getOrder() {
		return order;
	}

	public void setOrder(OrderVo order) {
		this.order = order;
	}

	public String getLastPaymentFailed() {
		return lastPaymentFailed;
	}

	public void setLastPaymentFailed(String lastPaymentFailed) {
		this.lastPaymentFailed = lastPaymentFailed;
	}


}
