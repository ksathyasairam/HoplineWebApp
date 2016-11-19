package com.hopline.WebApp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.google.gson.Gson;
import com.hopline.WebApp.dao.CategoryDao;
import com.hopline.WebApp.model.dao.Category;
import com.hopline.WebApp.model.dao.Product;
import com.hopline.WebApp.model.vo.CategoryVo;
import com.hopline.WebApp.model.vo.ProductVo;
import com.hopline.WebApp.rest.framework.IService;

public class CategoryServiceImpl extends IService{
	private CategoryDao categoryDao;
	
	public String retrieveAllCategoryJson() {
		
		List<CategoryVo> categoryVos = retrieveAllCategory();

		Gson gson = new Gson();
		String s = gson.toJson(categoryVos);

		return s;
	}
	
	public List<CategoryVo> retrieveAllCategory() {
		List<Category> categories =  getCategoryDao().retriveAllCategory();
		
		List<CategoryVo> categoryVos = new ArrayList<CategoryVo>();
		
		for(Category category : categories) {
			Mapper mapper = new DozerBeanMapper();
			CategoryVo destObject =  
			    mapper.map(category, CategoryVo.class);
			categoryVos.add(destObject);
		}
		
		for (CategoryVo categoryVo : categoryVos) {
	        Collections.sort(categoryVo.getProducts(), new ProductVenNvegComparator());
		}
		
		return categoryVos;
	}
	
	class ProductVenNvegComparator implements Comparator<ProductVo> {
	    @Override
	    public int compare(ProductVo a, ProductVo b) {
	        return a.getVegYn().compareToIgnoreCase(b.getVegYn()) * -1 ;
	    }
	}


	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	
}
