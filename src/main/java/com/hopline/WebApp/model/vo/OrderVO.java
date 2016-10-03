package com.hopline.WebApp.model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hopline.WebApp.model.dao.OrderProduct;
import com.hopline.WebApp.model.dao.User;

public class OrderVO {
	
	private Integer idorder;
	private String paidYn;
	private Date orderTime;
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
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
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
	
	
	

}
