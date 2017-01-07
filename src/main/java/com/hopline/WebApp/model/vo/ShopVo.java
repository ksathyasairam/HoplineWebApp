package com.hopline.WebApp.model.vo;

public class ShopVo implements java.io.Serializable {

	private Integer idshop;
	private String shopName;
	private String phone;
	private String imgUrl;
	private String activeYn;
	private String username;
	private String password;
	private String onlinePayYn;
	private String description;
	private double ourCutOnline;
	private double ourCutCash;
	private String firebaseId;
	
	
	private Boolean success;
	private String msg;

	public ShopVo() {
	}

	public ShopVo(String shopName, String activeYn, String username, String password, String onlinePayYn) {
		this.shopName = shopName;
		this.activeYn = activeYn;
		this.username = username;
		this.password = password;
		this.onlinePayYn = onlinePayYn;
	}

	public ShopVo(String shopName, String phone, String imgUrl, String activeYn, String username, String password,
			String onlinePayYn) {
		this.shopName = shopName;
		this.phone = phone;
		this.imgUrl = imgUrl;
		this.activeYn = activeYn;
		this.username = username;
		this.password = password;
		this.onlinePayYn = onlinePayYn;
	}

	public Integer getIdshop() {
		return this.idshop;
	}

	public void setIdshop(Integer idshop) {
		this.idshop = idshop;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getActiveYn() {
		return this.activeYn;
	}

	public void setActiveYn(String activeYn) {
		this.activeYn = activeYn;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOnlinePayYn() {
		return this.onlinePayYn;
	}

	public void setOnlinePayYn(String onlinePayYn) {
		this.onlinePayYn = onlinePayYn;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getOurCutOnline() {
		return ourCutOnline;
	}

	public void setOurCutOnline(double ourCutOnline) {
		this.ourCutOnline = ourCutOnline;
	}

	public double getOurCutCash() {
		return ourCutCash;
	}

	public void setOurCutCash(double ourCutCash) {
		this.ourCutCash = ourCutCash;
	}

	public String getFirebaseId() {
		return firebaseId;
	}

	public void setFirebaseId(String firebaseId) {
		this.firebaseId = firebaseId;
	}
	
}
