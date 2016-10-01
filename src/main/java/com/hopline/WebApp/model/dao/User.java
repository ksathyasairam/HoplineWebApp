package com.hopline.WebApp.model.dao;
// Generated 1 Oct, 2016 11:23:02 PM by Hibernate Tools 5.2.0.Beta1

import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private int iduser;
	private String phone;
	private String name;
	private Set<Order> orders = new HashSet<Order>();

	public User() {
	}

	public User(int iduser, String phone) {
		this.iduser = iduser;
		this.phone = phone;
	}

	public User(int iduser, String phone, String name, Set<Order> orders) {
		this.iduser = iduser;
		this.phone = phone;
		this.name = name;
		this.orders = orders;
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
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

}
