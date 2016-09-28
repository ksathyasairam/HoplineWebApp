package com.hopline.WebApp;

import java.util.List;

import com.hopline.WebApp.model.dao.Category;
import com.hopline.WebApp.rest.framework.ServiceLocator;

public class HelloWorldAction {
	private String name;

public String execute() throws Exception {
	List<Category> categories = ServiceLocator.getInstance()
			.getService(CategoryServiceImpl.class).retrieveAllCategory();

   return "success";
}

public String getName() {
   return name;
}

public void setName(String name) {
   this.name = name;
}
}
