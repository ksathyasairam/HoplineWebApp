package com.hopline.WebApp.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.google.gson.Gson;
import com.hopline.WebApp.dao.CategoryDao;
import com.hopline.WebApp.model.dao.Category;
import com.hopline.WebApp.model.vo.CategoryVo;
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
		
		return categoryVos;
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	
}
