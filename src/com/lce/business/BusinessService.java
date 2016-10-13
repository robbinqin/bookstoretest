package com.lce.business;

import java.util.List;

import com.lce.domain.Category;

public interface BusinessService {
	/**
	 * add category
	 */
	void addCategory(Category category);

	/**
	 * list of categories
	 * @param category
	 */
	List<Category> listAllCategories();
	/**
	 * check the category is exist or not
	 * @param categoryId
	 */
	boolean isCategoryExist(String categoryName);
	/**
	 * 
	 * @param categoryId
	 * @return
	 */			
	Category findCategoryById(String categoryId);
}
