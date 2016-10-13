package com.lce.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sun.print.resources.serviceui;

import com.lce.business.BusinessService;
import com.lce.business.impl.BusinessServiceImpl;
import com.lce.domain.Category;

public class BusinessServiceImplTest {

	private BusinessService bs=new BusinessServiceImpl();
	@Test
	public void testAddCategory() {
		Category category=new Category();
		category.setName("JAVA STL");
		category.setDescription("JAVA SSSSS");
		bs.addCategory(category);
	}

}
