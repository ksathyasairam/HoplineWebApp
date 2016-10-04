package com.hopline.WebApp.model.dao;
// Generated 4 Oct, 2016 1:44:13 AM by Hibernate Tools 5.2.0.Beta1

import java.util.Date;

/**
 * SecurityToken generated by hbm2java
 */
public class SecurityToken implements java.io.Serializable {

	private int idSecurityToken;
	private User user;
	private String securityToken;
	private Date createTs;

	public SecurityToken() {
	}

	public SecurityToken(int idSecurityToken, User user, String securityToken, Date createTs) {
		this.idSecurityToken = idSecurityToken;
		this.user = user;
		this.securityToken = securityToken;
		this.createTs = createTs;
	}

	public int getIdSecurityToken() {
		return this.idSecurityToken;
	}

	public void setIdSecurityToken(int idSecurityToken) {
		this.idSecurityToken = idSecurityToken;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSecurityToken() {
		return this.securityToken;
	}

	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}

	public Date getCreateTs() {
		return this.createTs;
	}

	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}

}
