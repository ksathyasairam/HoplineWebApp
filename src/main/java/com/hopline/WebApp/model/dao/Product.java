package com.hopline.WebApp.model.dao;
// Generated 1 Oct, 2016 11:23:02 PM by Hibernate Tools 5.2.0.Beta1

import java.util.HashSet;
import java.util.Set;

/**
 * Product generated by hbm2java
 */
public class Product implements java.io.Serializable {

	private Integer productId;
	private String name;
	private String shortDesc;
	private String longDesc;
	private long price;
	private String vegYn;
	private String stockYn;
	private Set<AddOn> addOns = new HashSet<AddOn>();
	private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();
	private Set<Category> categories = new HashSet<Category>();

	public Product() {
	}

	public Product(String name, long price, String vegYn, String stockYn) {
		this.name = name;
		this.price = price;
		this.vegYn = vegYn;
		this.stockYn = stockYn;
	}

	public Product(String name, String shortDesc, String longDesc, long price, String vegYn, String stockYn, Set<AddOn> addOns,
			Set<OrderProduct> orderProducts, Set<Category> categories) {
		this.name = name;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.price = price;
		this.vegYn = vegYn;
		this.stockYn = stockYn;
		this.addOns = addOns;
		this.orderProducts = orderProducts;
		this.categories = categories;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return this.longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public long getPrice() {
		return this.price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getVegYn() {
		return this.vegYn;
	}

	public void setVegYn(String vegYn) {
		this.vegYn = vegYn;
	}

	public String getStockYn() {
		return this.stockYn;
	}

	public void setStockYn(String stockYn) {
		this.stockYn = stockYn;
	}

	public Set<AddOn> getAddOns() {
		return addOns;
	}

	public void setAddOns(Set<AddOn> addOns) {
		this.addOns = addOns;
	}

	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}



}
