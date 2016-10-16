package com.hopline.vendorServices.model;
// Generated 6 Oct, 2016 1:14:11 AM by Hibernate Tools 5.2.0.Beta1

import java.util.List;


public class CategoryTo implements java.io.Serializable {

	private Integer idcategory;
	private ShopTo shop;
	private String name;
	private String subCategoryName;
	private int sortId;
	private String imgUrl;
	private List<ProductTo> products;
	
	public Integer getIdcategory() {
		return idcategory;
	}
	public void setIdcategory(Integer idcategory) {
		this.idcategory = idcategory;
	}
	public ShopTo getShop() {
		return shop;
	}
	public void setShop(ShopTo shop) {
		this.shop = shop;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public List<ProductTo> getProducts() {
		return products;
	}
	public void setProducts(List<ProductTo> products) {
		this.products = products;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



}