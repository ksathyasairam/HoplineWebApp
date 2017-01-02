package com.hopline.WebApp.model.dao;

import java.util.Date;

// default package
// Generated 31 Dec, 2016 1:55:15 AM by Hibernate Tools 5.2.0.Beta1

/**
 * OnlineTransaction generated by hbm2java
 */
public class OnlineTransaction implements java.io.Serializable {

	private String txnid;
	private String firstName;
	private String phone;
	private String key;
	private String mode;
	private String status;
	private String unmappedstatus;
	private String cardCategory;
	private String addedon;
	private String paymentSoucre;
	private String pgType;
	private String bankRefNo;
	private String bankCode;
	private String error;
	private String errorMsg;
	private String nameOnCard;
	private String cardNum;
	private String issuingBank;
	private String cardType;
	private String easePayId;
	private String amount;
	private String netAmountDebit;
	private String cashBackPercentage;
	private String deductionPercentage;
	private String surl;
	private String furl;
	private String hash;
	private int orderId;
	private Date createTimestamp;

	public OnlineTransaction() {
	}

	public OnlineTransaction(String txnid, int orderId) {
		this.txnid = txnid;
		this.orderId = orderId;
	}

	public OnlineTransaction(String txnid, String firstName, String phone, String key, String mode, String status,
			String unmappedstatus, String cardCategory, String addedon, String paymentSoucre, String pgType,
			String bankRefNo, String bankCode, String error, String errorMsg, String nameOnCard, String cardNum,
			String issuingBank, String cardType, String easePayId, String amount, String netAmountDebit,
			String cashBackPercentage, String deductionPercentage, String surl, String furl, String hash, int orderId, Date createTimestamp) {
		this.txnid = txnid;
		this.firstName = firstName;
		this.phone = phone;
		this.key = key;
		this.mode = mode;
		this.status = status;
		this.unmappedstatus = unmappedstatus;
		this.cardCategory = cardCategory;
		this.addedon = addedon;
		this.paymentSoucre = paymentSoucre;
		this.pgType = pgType;
		this.bankRefNo = bankRefNo;
		this.bankCode = bankCode;
		this.error = error;
		this.errorMsg = errorMsg;
		this.nameOnCard = nameOnCard;
		this.cardNum = cardNum;
		this.issuingBank = issuingBank;
		this.cardType = cardType;
		this.easePayId = easePayId;
		this.amount = amount;
		this.netAmountDebit = netAmountDebit;
		this.cashBackPercentage = cashBackPercentage;
		this.deductionPercentage = deductionPercentage;
		this.surl = surl;
		this.furl = furl;
		this.hash = hash;
		this.orderId = orderId;
		this.setCreateTimestamp(createTimestamp);
	}

	public String getTxnid() {
		return this.txnid;
	}

	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUnmappedstatus() {
		return this.unmappedstatus;
	}

	public void setUnmappedstatus(String unmappedstatus) {
		this.unmappedstatus = unmappedstatus;
	}

	public String getCardCategory() {
		return this.cardCategory;
	}

	public void setCardCategory(String cardCategory) {
		this.cardCategory = cardCategory;
	}

	public String getAddedon() {
		return this.addedon;
	}

	public void setAddedon(String addedon) {
		this.addedon = addedon;
	}

	public String getPaymentSoucre() {
		return this.paymentSoucre;
	}

	public void setPaymentSoucre(String paymentSoucre) {
		this.paymentSoucre = paymentSoucre;
	}

	public String getPgType() {
		return this.pgType;
	}

	public void setPgType(String pgType) {
		this.pgType = pgType;
	}

	public String getBankRefNo() {
		return this.bankRefNo;
	}

	public void setBankRefNo(String bankRefNo) {
		this.bankRefNo = bankRefNo;
	}

	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorMsg() {
		return this.errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getNameOnCard() {
		return this.nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNum() {
		return this.cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getIssuingBank() {
		return this.issuingBank;
	}

	public void setIssuingBank(String issuingBank) {
		this.issuingBank = issuingBank;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getEasePayId() {
		return this.easePayId;
	}

	public void setEasePayId(String easePayId) {
		this.easePayId = easePayId;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getNetAmountDebit() {
		return this.netAmountDebit;
	}

	public void setNetAmountDebit(String netAmountDebit) {
		this.netAmountDebit = netAmountDebit;
	}

	public String getCashBackPercentage() {
		return this.cashBackPercentage;
	}

	public void setCashBackPercentage(String cashBackPercentage) {
		this.cashBackPercentage = cashBackPercentage;
	}

	public String getDeductionPercentage() {
		return this.deductionPercentage;
	}

	public void setDeductionPercentage(String deductionPercentage) {
		this.deductionPercentage = deductionPercentage;
	}

	public String getSurl() {
		return this.surl;
	}

	public void setSurl(String surl) {
		this.surl = surl;
	}

	public String getFurl() {
		return this.furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

}
