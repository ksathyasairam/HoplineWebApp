package com.hopline.WebApp.model.vo;

import java.math.BigDecimal;
import java.util.List;

public class ProductVo implements java.io.Serializable {

	private Integer productId;
	private String name;
	private String shortDesc;
	private String longDesc;
	private BigDecimal price;
	private String vegYn;
	private String stockYn;
	private List<AddOnVo> addOns;
	private String singleAddonYN;	
	private String timeUnavailable;
	
	private boolean unavailableNow;
	private String unavailableMsg;
	
	//For UI frontEnd
	private boolean isExpanded;
	private int quantity = 1;
	private String menuDisplayName;
	private String variationName;
	private Integer variationGroupId;
	 
	public String getMenuDisplayName() {
		return menuDisplayName;
	}

	public void setMenuDisplayName(String menuDisplayName) {
		this.menuDisplayName = menuDisplayName;
	}

	public String getVariationName() {
		return variationName;
	}

	public void setVariationName(String variationName) {
		this.variationName = variationName;
	}

	public Integer getVariationGroupId() {
		return variationGroupId;
	}

	public void setVariationGroupId(Integer variationGroupId) {
		this.variationGroupId = variationGroupId;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getVegYn() {
		return vegYn;
	}
	public void setVegYn(String vegYn) {
		this.vegYn = vegYn;
	}
	public String getStockYn() {
		return stockYn;
	}
	public void setStockYn(String stockYn) {
		this.stockYn = stockYn;
	}
	public List<AddOnVo> getAddOns() {
		return addOns;
	}
	public void setAddOns(List<AddOnVo> addOns) {
		this.addOns = addOns;
	}
	public boolean isExpanded() {
		return isExpanded;
	}
	public void setExpanded(boolean isExpanded) {
		this.isExpanded = isExpanded;
	}
	public String getSingleAddonYN() {
		return singleAddonYN;
	}
	public void setSingleAddonYN(String singleAddonYN) {
		this.singleAddonYN = singleAddonYN;
	}
	public String getTimeUnavailable() {
		return timeUnavailable;
	}
	public void setTimeUnavailable(String timeUnavailable) {
		this.timeUnavailable = timeUnavailable;
	}
	public boolean isUnavailableNow() {
		return unavailableNow;
	}
	public void setUnavailableNow(boolean unavailableNow) {
		this.unavailableNow = unavailableNow;
	}
	public String getUnavailableMsg() {
		return unavailableMsg;
	}
	public void setUnavailableMsg(String unavailableMsg) {
		this.unavailableMsg = unavailableMsg;
	}
	
	
	

}
