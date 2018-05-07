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
			<form action="" method="post" class="form" accept-charset="utf-8">
		        <strong>ID </strong>(*) <br>
		        <input type="text" name="idnv" required>
		        <br>
		        <strong>Họ tên </strong>(*) <br>
		        <input type="text" name="hoten" required>
		        <br>
		        <strong>IDPB </strong>(*) <br>
		        <input type="text" name="idpb" required>
		        <br>
		        <strong>Địa chỉ </strong>(*) <br>
		        <input type="text" name="diachi" required>
		        <br>
		        <input type="submit" name="submit" value="Submit">
		    </form>
		</div>
	</div>
</body>
</html>