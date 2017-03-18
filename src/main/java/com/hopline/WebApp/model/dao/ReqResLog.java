package com.hopline.WebApp.model.dao;
// Generated 11 Jan, 2017 6:23:51 PM by Hibernate Tools 5.2.0.Beta1

import java.util.Date;

/**
 * ReqResLog generated by hbm2java
 */
public class ReqResLog implements java.io.Serializable {

	private int idReqResLog;
	private String request;
	private String response;
	private String actionName;
	private Date createTimestamp;
	private Integer shopId;


	public ReqResLog() {
	}

	public ReqResLog(int idReqResLog, Date createTimestamp) {
		this.idReqResLog = idReqResLog;
		this.createTimestamp = createTimestamp;
	}

	public ReqResLog(int idReqResLog, String request, String response, String actionName, Date createTimestamp) {
		this.idReqResLog = idReqResLog;
		this.request = request;
		this.response = response;
		this.actionName = actionName;
		this.createTimestamp = createTimestamp;
	}

	public int getIdReqResLog() {
		return this.idReqResLog;
	}

	public void setIdReqResLog(int idReqResLog) {
		this.idReqResLog = idReqResLog;
	}

	public String getRequest() {
		return this.request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getActionName() {
		return this.actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public Date getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

}