<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <br/><br/>
  <h1>后台管理</h1>
  <br/>
  <a href="${pageContext.request.contextPath}/manage/addCategory.jsp">添加分类</a>
  <a href="javascript::">查询分类</a>
  <a href="javascript::">添加图书</a>
  <a href="javascript::">查询图书</a>
  