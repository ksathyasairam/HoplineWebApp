package com.hopline.vendorServices.model;

import java.util.List;

import com.hopline.WebApp.model.dao.OrderProductAddon;

public class OrderProductTo implements java.io.Serializable {

	private Integer idorderProduct;
	private ProductTo product;
	private Integer count;
	private List<OrderProductAddonTo> orderProductAddons;
	
	public Integer getIdorderProduct() {
		return idorderProduct;
	}
	public void setIdorderProduct(Integer idorderProduct) {
		this.idorderProduct = idorderProduct;
	}
	public ProductTo getProduct() {
		return product;
	}
	public void setProduct(ProductTo product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<OrderProductAddonTo> getOrderProductAddons() {
		return orderProductAddons;
	}
	public void setOrderProductAddons(List<OrderProductAddonTo> orderProductAddons) {
		this.orderProductAddons = orderProductAddons;
	}
	
	

	
}
