package com.hopline.WebApp.model.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.hopline.WebApp.model.dao.OrderProduct;
import com.hopline.WebApp.model.dao.User;

public class OrderVO {
	
	private int idorder;
	private User user;
	private String orderState;
	private String paidYn;
	private Date orderTime;
	private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();

}
