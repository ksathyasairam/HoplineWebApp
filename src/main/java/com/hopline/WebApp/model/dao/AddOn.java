package com.hopline.WebApp.model.dao;
// Generated 6 Oct, 2016 1:14:11 AM by Hibernate Tools 5.2.0.Beta1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * AddOn generated by hbm2java
 */
public class AddOn implements java.io.Serializable {

	private Integer idaddOn;
	private String name;
	private BigDecimal price;
	private String stockYn;
	private Set<OrderProductAddon> orderProductAddons = new HashSet<OrderProductAddon>(0);
	private Set<AddonGroup> addonGroups = new HashSet<AddonGroup>(0);
	public Integer getIdaddOn() {
		return idaddOn;
	}
	public void setIdaddOn(Integer idaddOn) {
		this.idaddOn = idaddOn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getStockYn() {
		return stockYn;
	}
	public void setStockYn(String stockYn) {
		this.stockYn = stockYn;
	}
	public Set<OrderProductAddon> getOrderProductAddons() {
		return orderProductAddons;
	}
	public void setOrderProductAddons(Set<OrderProductAddon> orderProductAddons) {
		this.orderProductAddons = orderProductAddons;
	}
	public Set<AddonGroup> getAddonGroups() {
		return addonGroups;
	}
	public void setAddonGroups(Set<AddonGroup> addonGroups) {
		this.addonGroups = addonGroups;
	}
	


}
