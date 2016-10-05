package com.hopline.WebApp.model.dao;
// Generated 5 Oct, 2016 11:03:23 PM by Hibernate Tools 5.2.0.Beta1

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
	private String orderState;
	private String paidYn;
	private Date orderTime;
	private String cancelReason;
	private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>(0);

	public Order() {
	}

	public Order(Shop shop, User user, String orderState, String paidYn, Date orderTime) {
		this.shop = shop;
		this.user = user;
		this.orderState = orderState;
		this.paidYn = paidYn;
		this.orderTime = orderTime;
	}

	public Order(Shop shop, User user, String orderState, String paidYn, Date orderTime, String cancelReason,
			Set<OrderProduct> orderProducts) {
		this.shop = shop;
		this.user = user;
		this.orderState = orderState;
		this.paidYn = paidYn;
		this.orderTime = orderTime;
		this.cancelReason = cancelReason;
		this.orderProducts = orderProducts;
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

}
