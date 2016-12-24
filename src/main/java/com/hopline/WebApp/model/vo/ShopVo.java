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
	
}
