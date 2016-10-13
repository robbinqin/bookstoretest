package com.lce.business.impl;

import java.util.List;
import java.util.UUID;

import com.lce.business.BusinessService;
import com.lce.dao.CategoryDao;
import com.lce.dao.impl.CategoryDaoImpl;
import com.lce.domain.Category;

public class BusinessServiceImpl implements BusinessService {

	CategoryDao categoryDao=new CategoryDaoImpl();
	
	public void addCategory(Category category) {
		category.setId(UUID.randomUUID().toString());
		categoryDao.save(category);
	}

	@Override
	public List<Category> listAllCategories() {
		return categoryDao.findAllCategories();
	}

	@Override
	public boolean isCategoryExist(String categoryName) {
		Category category=categoryDao.findByName(categoryName);
		return category==null?false:true;
	}

	@Override
	public Category findCategoryById(String categoryId) {
		return categoryDao.findCategoryById(categoryId);
	}	
	

	
}
