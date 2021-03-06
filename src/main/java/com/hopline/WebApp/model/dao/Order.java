package com.hopline.WebApp.model.dao;
// Generated 6 Oct, 2016 1:14:11 AM by Hibernate Tools 5.2.0.Beta1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Order generated by hbm2java
 */
public class Order implements java.io.Serializable {

	private Integer idorder;
	private Shop shop;
	private User user;
	private int customerOrderId;
	private String orderState;
	private String paidYn;
	private Date orderTime;
	private String cancelReason;
	private int totalItemCount;
	private BigDecimal totalPrice;
	private String orderCreator;
	private Integer ordersInQueue;
	private Integer orderCompleteTime;
	private String paymentMethod;
	private String paymentSettledYN;
	private Date settledDate;
	private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>(0);

	public Order() {
	}

	public Integer getIdorder() {
		return this.idorder;
	}

	public void setIdorder(Integer idorder) {
		this.idorder = idorder;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCustomerOrderId() {
		return this.customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getPaidYn() {
		return this.paidYn;
	}

	public void setPaidYn(String paidYn) {
		this.paidYn = paidYn;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getCancelReason() {
		return this.cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Set<OrderProduct> getOrderProducts() {
		return this.orderProducts;
	}

	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public int getTotalItemCount() {
		return totalItemCount;
	}

	public void setTotalItemCount(int totalItemCount) {
		this.totalItemCount = totalItemCount;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderCreator() {
		return orderCreator;
	}

	public void setOrderCreator(String orderCreator) {
		this.orderCreator = orderCreator;
	}

	/**
	 * Number of orders including current and previous orders at the time of
	 * order creation.
	 * 
	 * @return
	 */
	public Integer getOrdersInQueue() {
		return ordersInQueue;
	}

	/**
	 * Number of orders including current and previous orders at the time of
	 * order creation.
	 * 
	 * @return
	 */
	public void setOrdersInQueue(Integer ordersInQueue) {
		this.ordersInQueue = ordersInQueue;
	}

	public Integer getOrderCompleteTime() {
		return orderCompleteTime;
	}

	public void setOrderCompleteTime(Integer orderCompleteTime) {
		this.orderCompleteTime = orderCompleteTime;
	}

	public String getPaymentSettledYN() {
		return paymentSettledYN;
	}

	public void setPaymentSettledYN(String paymentSettledYN) {
		this.paymentSettledYN = paymentSettledYN;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getSettledDate() {
		return settledDate;
	}

	public void setSettledDate(Date settledDate) {
		this.settledDate = settledDate;
	}

}
