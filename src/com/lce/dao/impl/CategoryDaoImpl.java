package com.lce.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lce.dao.CategoryDao;
import com.lce.domain.Category;
import com.lce.util.C3P0Util;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.Select;

public class CategoryDaoImpl implements CategoryDao {

	/**
	 * dbutils:\15期-cloud\day18_jdbc\
	 * commons-dbutils-1.4.jar:/WebRoot/WEB-INF/lib/
	 * c3p0-0.9.1.2.jar
	 * mysql-connector-java-5.0.8-bin.jar
	 */
	//1. open connection
	private QueryRunner queryRunner=new QueryRunner(C3P0Util.getDataSource());
	public void save(Category category) {
		//2. save in db
		try{
		queryRunner.update("INSERT INTO categoies (id,name,description) values (?,?,?)", 
				category.getId(),category.getName(),category.getDescription());
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	@Override
	public List<Category> findAllCategories() {

		try {
			return queryRunner.query("Select * from categories", new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public Category findByName(String categoryName) {

		try {
			return queryRunner.query("select * from categories where name=?",new BeanHandler<Category>(Category.class), categoryName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public Category findCategoryById(String categoryId) {
		try {
			return queryRunner.query("select * from categories where id=?", new BeanHandler<Category>(Category.class), categoryId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
