package com.hoplineVendorServices.model;

import java.util.Date;
import java.util.List;

public class OrderTo implements java.io.Serializable {

	private Integer idorder;
	private ShopTo shop;
	private UserTo user;
	private Integer customerOrderId;
	private String orderState;
	private String paidYn;
	private Date orderTime;
	private String cancelReason;
	private Integer totalItemCount;
	private Double totalPrice;
	private List<OrderProductTo> orderProducts;
	public Integer getIdorder() {
		return idorder;
	}
	public void setIdorder(Integer idorder) {
		this.idorder = idorder;
	}
	public ShopTo getShop() {
		return shop;
	}
	public void setShop(ShopTo shop) {
		this.shop = shop;
	}
	public UserTo getUser() {
		return user;
	}
	public void setUser(UserTo user) {
		this.user = user;
	}
	public Integer getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(Integer customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public String getPaidYn() {
		return paidYn;
	}
	public void setPaidYn(String paidYn) {
		this.paidYn = paidYn;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public Integer getTotalItemCount() {
		return totalItemCount;
	}
	public void setTotalItemCount(Integer totalItemCount) {
		this.totalItemCount = totalItemCount;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<OrderProductTo> getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(List<OrderProductTo> orderProducts) {
		this.orderProducts = orderProducts;
	}
		
}
