package com.hopline.WebApp.endpoint.model;

public class OrderStatus {
	
	private Integer idorder;
	private String orderState;
	private String cancelReason;
	private Integer numUnitInProgressBar;
	private Integer currentProgress;
	
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


}
