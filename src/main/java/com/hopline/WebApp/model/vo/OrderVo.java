package com.hopline.WebApp.model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hopline.WebApp.model.dao.OrderProduct;
import com.hopline.WebApp.model.dao.User;

public class OrderVo {
	
	private Integer idorder;
	private Integer shopId;
	private Integer userId;
	private String paidYn;
	private Date orderSubmittedTime;
	private Integer totalItem;
	private Integer totalPrice;
	private List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
	
	
	public Integer getIdorder() {
		return idorder;
	}
	public void setIdorder(Integer idorder) {
		this.idorder = idorder;
	}
	public String getPaidYn() {
		return paidYn;
	}
	public void setPaidYn(String paidYn) {
		this.paidYn = paidYn;
	}
	
	public Integer getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	
	public Date getOrderSubmittedTime() {
		return orderSubmittedTime;
	}
	public void setOrderSubmittedTime(Date orderSubmittedTime) {
		this.orderSubmittedTime = orderSubmittedTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	

}
