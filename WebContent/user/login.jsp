<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.bean.PhongBan"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Quản lý phòng ban</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="./template/style.css">
	<style type="text/css">

	</style>
</head>
<body>
	<div class="container">
		<%@include file="../template/menu.jsp"%>
		<jsp:include page="../template/menu.jsp" />
		<div class="content">
			<%@include file="../template/logo.jsp"%>
			<form action="" class="form" method="post">
				<label for="username">Username</label><br/>
				<input type="text" id="username" name="username" placeholder="admin">
				<br/>
				<label for="password">Password</label><br/>
				<input type="password" id="password" name="password" placeholder="123456">
			
				<input type="submit" value="Login" name="login">
			</form>
		</div>
	</div>
</body>
</html>