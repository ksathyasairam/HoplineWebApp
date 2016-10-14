package com.hopline.WebApp.endpoint.model;

public class OrderStatus {
	
	private Integer idorder;
	private String orderState;
	private String cancelReason;
	public Integer getIdorder() {
		return idorder;
	}
	public void setIdorder(Integer idorder) {
		this.idorder = idorder;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}


}
