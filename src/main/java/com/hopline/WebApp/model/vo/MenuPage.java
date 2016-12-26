package com.hopline.WebApp.model.vo;

import java.util.ArrayList;
import java.util.List;

public class MenuPage {
	
	private List<CategoryVo> categories;
	private List<Integer> favourites;
	private ShopVo shop;
	private List<String> categoriesName;
	
	public List<CategoryVo> getCategories() {
		return categories;
	}
	public void setCategories(List<CategoryVo> categories) {
		this.categories = categories;
	}
	public List<Integer> getFavourites() {
		return favourites;
	}
	public void setFavourites(List<Integer> favourites) {
		this.favourites = favourites;
	}
	public ShopVo getShop() {
		return shop;
	}
	public void setShop(ShopVo shop) {
		this.shop = shop;
	}
	public List<String> getCategoriesName() {
		return categoriesName;
	}
	public void setCategoriesName(List<String> categoriesName) {
		this.categoriesName = categoriesName;
	}
	

}
