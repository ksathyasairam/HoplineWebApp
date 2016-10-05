package com.hopline.WebApp.model.dao;
// Generated 5 Oct, 2016 11:03:23 PM by Hibernate Tools 5.2.0.Beta1

import java.util.Date;

/**
 * OrderStatusLog generated by hbm2java
 */
public class OrderStatusLog implements java.io.Serializable {

	private String orderStatusLogid;
	private Date timestamp;
	private int orderId;
	private String orderStatus;

	public OrderStatusLog() {
	}

	public OrderStatusLog(String orderStatusLogid, int orderId, String orderStatus) {
		this.orderStatusLogid = orderStatusLogid;
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}

	public String getOrderStatusLogid() {
		return this.orderStatusLogid;
	}

	public void setOrderStatusLogid(String orderStatusLogid) {
		this.orderStatusLogid = orderStatusLogid;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
