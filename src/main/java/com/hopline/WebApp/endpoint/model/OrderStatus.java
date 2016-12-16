package com.hopline.WebApp.endpoint.model;

import java.util.List;

import com.hopline.WebApp.model.vo.OrderProductVo;

public class OrderStatus {
	
	private Integer idorder;
	private String orderState;
	private String cancelReason;
	private Integer numUnitInProgressBar;
	private Integer currentProgress;
	
	private List<OrderProductVo> products;
	
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
	public Integer getNumUnitInProgressBar() {
		return numUnitInProgressBar;
	}
	public void setNumUnitInProgressBar(Integer numUnitInProgressBar) {
		this.numUnitInProgressBar = numUnitInProgressBar;
	}
	public Integer getCurrentProgress() {
		return currentProgress;
	}
	public void setCurrentProgress(Integer currentProgress) {
		this.currentProgress = currentProgress;
	}
	public List<OrderProductVo> getProducts() {
		return products;
	}
	public void setProducts(List<OrderProductVo> products) {
		this.products = products;
	}


}
