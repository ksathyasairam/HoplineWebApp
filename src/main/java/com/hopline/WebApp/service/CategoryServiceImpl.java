package com.hopline.WebApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.google.gson.Gson;
import com.hopline.WebApp.dao.CategoryDao;
import com.hopline.WebApp.model.dao.Category;
import com.hopline.WebApp.model.dao.Product;
import com.hopline.WebApp.model.dao.Shop;
import com.hopline.WebApp.model.vo.AddOnVo;
import com.hopline.WebApp.model.vo.CategoryDropdownItem;
import com.hopline.WebApp.model.vo.CategoryVo;
import com.hopline.WebApp.model.vo.MenuPage;
import com.hopline.WebApp.model.vo.ProductGroupVo;
import com.hopline.WebApp.model.vo.ProductVo;
import com.hopline.WebApp.model.vo.ShopVo;
import com.hopline.WebApp.model.vo.UserVo;
import com.hopline.WebApp.rest.framework.IService;
import com.hopline.WebApp.rest.framework.Util;
import com.hopline.WebApp.translator.OrderTranslator;

public class CategoryServiceImpl extends IService {
	private CategoryDao categoryDao;

	public String retrieveMenuPageJson(UserVo user, Integer shopId) {

		List<CategoryVo> categoryVos = retrieveAllCategory(shopId);

		setProductUnavailibility(categoryVos);
		// List<Integer> favourites = null;
		//
		// if (user != null) {
		// favourites = categoryDao.getFavouriteItems(user.getIduser(),shopId);
		// } else {
		// favourites = new ArrayList<Integer>();
		// }

		MenuPage menuPage = new MenuPage();
		menuPage.setShop(OrderTranslator.convert(categoryDao.retrieveShop(shopId), ShopVo.class));
		menuPage.setCategories(categoryVos);

		List<CategoryDropdownItem> dropdown = new ArrayList<CategoryDropdownItem>();
		for (CategoryVo category : categoryVos) {

			CategoryDropdownItem dropdownItem = new CategoryDropdownItem();
			dropdownItem.setImgUrl(category.getImgUrl());
			dropdownItem.setName(category.getName());

			if (!dropdown.contains(dropdownItem)) {
				dropdown.add(dropdownItem);
			}
		}

		menuPage.setCategoryDropdown(dropdown);

		// menuPage.setFavourites(favourites);

		Gson gson = new Gson();
		String s = gson.toJson(menuPage);

		return s;
	}

	// 11-14,1-20
	private void setProductUnavailibility(List<CategoryVo> categoryVos) {

		if (categoryVos == null)
			return;

		for (CategoryVo category : categoryVos) {
			for (ProductGroupVo productGroup : category.getProductGroups()) {
				for (ProductVo product : productGroup.getProducts()) {

					if (product.getTimeUnavailable() != null && !product.getTimeUnavailable().isEmpty()) {

						product.setTimeUnavailable(product.getTimeUnavailable().trim());

						List<String> times;

						if (product.getTimeUnavailable().contains(","))
							times = Arrays.asList(product.getTimeUnavailable().split(","));
						else {
							times = new ArrayList<String>();
							times.add(product.getTimeUnavailable());
						}

						Integer currentHour = Util.getCurrentDateTimeIndia().getHours();

						for (String time : times) {
							Integer startTime = Integer.parseInt(time.split("-")[0]);
							Integer endTime = Integer.parseInt(time.split("-")[1]);

							if (currentHour >= startTime && currentHour < endTime) {
								product.setUnavailableNow(true);
								// Integer twelveHrs = endTime > 12 ? endTime-12
								// : endTime;
								product.setUnavailableMsg("Will be available next at " + endTime + " hrs.");
							}

						}
					}

				}

			}
		}

	}

	public List<CategoryVo> retrieveAllCategory(Integer shopId) {
		List<Category> categories = getCategoryDao().retriveAllCategory(shopId);

		List<CategoryVo> categoryVos = new ArrayList<CategoryVo>();

		Mapper mapper = new DozerBeanMapper();
		for (Category category : categories) {
			CategoryVo destObject = mapper.map(category, CategoryVo.class);
			categoryVos.add(destObject);

			
			HashMap<Integer, ProductGroupVo> groupIdMap = new HashMap<Integer, ProductGroupVo>();
			
			Iterator iterator = category.getProducts().iterator();
			
			int dummyId = 100000;

			while (iterator.hasNext()){
				   Product product = (Product) iterator.next();
				   ProductVo productVo = mapper.map(product, ProductVo.class);

				   if (productVo.getVariationGroupId() == null) {
					   productVo.setMenuDisplayName(productVo.getName());

					   ProductGroupVo productGroupVo = new ProductGroupVo();
					   productGroupVo.setProducts(new ArrayList<ProductVo>());
					   productGroupVo.getProducts().add(productVo);
					   groupIdMap.put(dummyId++, productGroupVo);
					   continue;
				   }
				   
				   if (groupIdMap.containsKey(productVo.getVariationGroupId()))
					   groupIdMap.get(productVo.getVariationGroupId()).getProducts().add(productVo);
				   else {
					   ProductGroupVo productGroupVo = new ProductGroupVo();
					   productGroupVo.setGroupName("Select size");
					   productGroupVo.setProducts(new ArrayList<ProductVo>());
					   productGroupVo.getProducts().add(productVo);
					   groupIdMap.put(productVo.getVariationGroupId(), productGroupVo);
				   }
			   }
			
			
			List<ProductGroupVo> productGroupVoList = new ArrayList<ProductGroupVo>(groupIdMap.values());
			destObject.setProductGroups(productGroupVoList);
		}

		for (CategoryVo categoryVo : categoryVos) {
			Collections.sort(categoryVo.getProductGroups(), new ProductVenNvegComparator());

			
			for (ProductGroupVo productGroup : categoryVo.getProductGroups()) {
				Collections.sort(productGroup.getProducts(), new PriceComparator());

				for (ProductVo product : productGroup.getProducts()) {
					Collections.sort(product.getAddOns(), new AddonPriceComprator());
				}
			}
		}

		return categoryVos;
	}

	

	class ProductVenNvegComparator implements Comparator<ProductGroupVo> {
		@Override
		public int compare(ProductGroupVo a, ProductGroupVo b) {
			return a.getProducts().get(0).getVegYn().compareToIgnoreCase(b.getProducts().get(0).getVegYn()) == 0
					? a.getProducts().get(0).getName().compareToIgnoreCase(b.getProducts().get(0).getName())
					: a.getProducts().get(0).getVegYn().compareToIgnoreCase(b.getProducts().get(0).getVegYn()) * -1;
		}
	}
	
	class PriceComparator implements Comparator<ProductVo> {
		@Override
		public int compare(ProductVo a, ProductVo b) {
			return a.getPrice().compareTo(b.getPrice());
		}
	}

	class AddonPriceComprator implements Comparator<AddOnVo> {
		@Override
		public int compare(AddOnVo a, AddOnVo b) {
			return a.getPrice().compareTo(b.getPrice());
		}
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<ShopVo> retrieveAllShops() {
		List<Shop> shops = categoryDao.retrieveAllShops();
		List<ShopVo> shopVos = new ArrayList<ShopVo>();

		for (Shop shop : shops) {
			shopVos.add(OrderTranslator.convert(shop, ShopVo.class));
		}

		return shopVos;

	}

}
