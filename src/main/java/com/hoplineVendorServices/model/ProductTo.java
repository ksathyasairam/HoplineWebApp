package com.hoplineVendorServices.model;

import java.math.BigDecimal;
import java.util.List;

public class ProductTo implements java.io.Serializable {

	private Integer productId;
	private String name;
	private String shortDesc;
	private String longDesc;
	private BigDecimal price;
	private String vegYn;
	private String stockYn;
	private List<AddOnTo> addOns;
	
	
	
	
	//For UI frontEnd
	private boolean isExpanded;
	private int quantity = 1;
	
	 
	
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
	public List<AddOnTo> getAddOns() {
		return addOns;
	}
	public void setAddOns(List<AddOnTo> addOns) {
		this.addOns = addOns;
	}
	public boolean isExpanded() {
		return isExpanded;
	}
	public void setExpanded(boolean isExpanded) {
		this.isExpanded = isExpanded;
	}
	
	

}
