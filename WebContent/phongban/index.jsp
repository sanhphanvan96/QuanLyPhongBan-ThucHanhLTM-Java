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
			<table id="table-view">
			<caption><h3>Danh sách Phòng ban </h3></caption>
			  <tr>
			    <th>IDPB</th>
			    <th>Mô tả</th>
			    <th>Thời gian</th>
			    <th>Thao tác</th>
			  </tr>
			  <%
			  ArrayList<PhongBan> allItem = (ArrayList<PhongBan>) request.getAttribute("allItem");
			  for(PhongBan item : allItem) {
			  %>
			  <tr>
			    <td><a href="#"><%= item.getIdpb() %></a></td>
			    <td><%= item.getMota() %></td>
			    <td><%= item.getThoigian() %></td>
			    <td><button class="button"><a href="<%= request.getContextPath() + "/PhongBanViewController?idpb=" + item.getIdpb() %>">Xem nhân viên</a></button></td>
			  </tr>
			  <% } %>
			</table>
		</div>
	</div>
</body>
</html>