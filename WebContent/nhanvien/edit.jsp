<%@page import="model.bean.NhanVien"%>
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
</head>
<body>
	<div class="container">
		<%@include file="../template/menu.jsp"%>
		<jsp:include page="../template/menu.jsp" />
		<div class="content">
			<%@include file="../template/logo.jsp"%>
			<%
				NhanVien nv = (NhanVien) request.getAttribute("nv");
			%>
			<form action="" method="post" class="form">
		        <strong>ID </strong>(*) <br>
		        <input type="hidden" value="<%= nv.getIdnv() %>" name="idnv" required>
		        <input type="text" value="<%= nv.getIdnv() %>" name="idnv" required disabled readonly>
		        <br>
		        <strong>Họ tên </strong>(*) <br>
		        <input type="text" value="<%= nv.getHoten() %>" name="hoten" required>
		        <br>
		        <strong>IDPB </strong>(*) <br>
		        <input type="text" value="<%= nv.getIdpb() %>" name="idpb" required>
		        <br>
		        <strong>Địa chỉ </strong>(*) <br>
		        <input type="text" value="<%= nv.getDiachi() %>" name="diachi" required>
		        <br>
		        <input type="submit" name="submit" value="Submit">
		    </form>
		</div>
	</div>
</body>
</html>