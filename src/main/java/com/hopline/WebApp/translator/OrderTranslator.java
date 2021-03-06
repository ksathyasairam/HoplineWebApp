package com.hopline.WebApp.translator;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.hopline.WebApp.endpoint.model.OrderStatus;
import com.hopline.WebApp.model.dao.Order;
import com.hopline.WebApp.model.vo.OrderVo;

public class OrderTranslator {

	public static Order toOrder(OrderVo orderVo) {
		Mapper mapper = new DozerBeanMapper();
		Order destObject =  
		    mapper.map(orderVo, Order.class);
		return destObject;
	}

	public static OrderVo toOrderVo(Order order) {
		Mapper mapper = new DozerBeanMapper();
		OrderVo destObject =  
		    mapper.map(order, OrderVo.class);
		return destObject;
	}

	public static OrderStatus toOrderStatus(Order order) {
		Mapper mapper = new DozerBeanMapper();
		OrderStatus destObject =  
		    mapper.map(order, OrderStatus.class);
		return destObject;
	}
	
	public static <T> T convert(Object object, Class<T> type) {
		Mapper mapper = new DozerBeanMapper();
		T destObject =  
		    mapper.map(object, type);
		return destObject;
	}
	

}
