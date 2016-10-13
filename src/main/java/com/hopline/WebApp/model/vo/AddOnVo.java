package com.hopline.WebApp.model.vo;

public class AddOnVo implements java.io.Serializable {

	private Integer idaddOn;
	private String name;
	private Double price;
	private String stockYn;

	
	//For UI frontend
	private String selected;
	
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStockYn() {
		return stockYn;
	}
	public void setStockYn(String stockYn) {
		this.stockYn = stockYn;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	
}
