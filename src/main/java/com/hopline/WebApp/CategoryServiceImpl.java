package com.hopline.WebApp;

import java.util.List;

import com.google.gson.Gson;
import com.hopline.WebApp.model.dao.Category;
import com.hopline.WebApp.model.dao.Product;
import com.hopline.WebApp.rest.framework.IService;

public class CategoryServiceImpl extends IService{
	private CategoryDao categoryDao;
	
	public List<Category> retrieveAllCategory() {
		List<Category> categories =  getCategoryDao().retriveAllCategory();
		
		
		for(Category category : categories) {
			if (category.getProducts() == null) continue;
			for (Product product : category.getProducts()) {
				product.setCategories(null);
				product.setAddOns(null);
			}
		}
		

		Gson gson = new Gson();

		String s = gson.toJson(categories);

		
		
//		for (Product product : categories.get(0).getProducts()) {
//			product.getName();
//			product.getPrice();
//		}
		
		return categories;
		
		
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

}
