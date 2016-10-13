package com.hopline.WebApp.model.vo;

import java.util.Date;
import java.util.List;

public class OrderVo implements java.io.Serializable {

	private Integer idorder;
	private ShopVo shop;
	private UserVo user;
	private Integer customerOrderId;
	private String orderState;
	private String paidYn;
	private Date orderTime;
	private String cancelReason;
	private Integer totalItemCount;
	private Double totalPrice;
	private List<OrderProductVo> orderProducts;
	public Integer getIdorder() {
		return idorder;
	}
	public void setIdorder(Integer idorder) {
		this.idorder = idorder;
	}
	public ShopVo getShop() {
		return shop;
	}
	public void setShop(ShopVo shop) {
		this.shop = shop;
	}
	public UserVo getUser() {
		return user;
	}
	public void setUser(UserVo user) {
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
	public List<OrderProductVo> getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(List<OrderProductVo> orderProducts) {
		this.orderProducts = orderProducts;
	}
		
}
