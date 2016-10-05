package com.hopline.WebApp.model.dao;
// Generated 6 Oct, 2016 1:14:11 AM by Hibernate Tools 5.2.0.Beta1

import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private Integer iduser;
	private String phone;
	private String name;
	private Set<Order> orders = new HashSet<Order>(0);
	private Set<SecurityToken> securityTokens = new HashSet<SecurityToken>(0);

	public User() {
	}

	public User(String phone) {
		this.phone = phone;
	}

	public User(String phone, String name, Set<Order> orders, Set<SecurityToken> securityTokens) {
		this.phone = phone;
		this.name = name;
		this.orders = orders;
		this.securityTokens = securityTokens;
	}

	public Integer getIduser() {
		return this.iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<SecurityToken> getSecurityTokens() {
		return this.securityTokens;
	}

	public void setSecurityTokens(Set<SecurityToken> securityTokens) {
		this.securityTokens = securityTokens;
	}

}
