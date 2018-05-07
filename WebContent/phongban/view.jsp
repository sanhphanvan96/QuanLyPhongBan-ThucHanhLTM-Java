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
			<% 
				PhongBan currentPB = (PhongBan) request.getAttribute("currentPB");
				boolean isLogin = AuthenUtil.isLogin(request, response);
			%>
				<caption><h3>Danh sách nhân viên - Phòng ban <%= currentPB.getIdpb() %></h3></caption>
			    <tr>
					<th>IDNV</th>
					<th>Họ Tên</th>
					<th>IDPB</th>
					<th>Địa chỉ</th>
					<% if(isLogin) { %>
						<th>Thao Tác</th>
					<% } %>
	             </tr>
			  <%
			  ArrayList<NhanVien> listNV = (ArrayList<NhanVien>) request.getAttribute("listNV");
			  for(NhanVien item : listNV) {
			  %>
			  <tr>
			    <td><%= item.getIdnv() %></td>
			    <td><%= item.getHoten() %></td>
			    <td><%= item.getIdpb() %></td>
			    <td><%= item.getDiachi() %></td>
			    <% if(isLogin) { %>
			    <td>
			    	<button class="button"><a href="<%= request.getContextPath() %>/NhanVienEditController?idnv=<%= item.getIdnv() %>">Sửa</a></button>
			    	<button class="button"><a href="<%= request.getContextPath() %>/NhanVienDelController?idnv=<%= item.getIdnv() %>" onclick="return confirm(`Are you sure you want to delete this item?`);">Xóa</a></button>
			    </td>
			    <% } %>
			  </tr>
			  <% } %>
			</table>
		</div>
	</div>
</body>
</html>