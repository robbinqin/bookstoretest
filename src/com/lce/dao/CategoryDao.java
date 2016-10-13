package com.lce.dao;

import java.util.List;

import com.lce.domain.Category;

public interface CategoryDao {

	void save(Category category);

	List<Category> findAllCategories();

	Category findByName(String categoryName);

	Category findCategoryById(String categoryId);

}
