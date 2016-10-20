package com.lce.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lce.business.BusinessService;
import com.lce.business.impl.BusinessServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ManageServlet extends HttpServlet {
	BusinessService businessService=new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op=request.getParameter("op");
		if("checkCategory".equals(op)){
			checkCategory(request,response);
		}
	}

	private void checkCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		boolean exist=businessService.isCategoryExist(name);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}
}
