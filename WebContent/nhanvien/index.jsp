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
	<script src="./template/jquery-2.2.4.min.js"></script>
</head>
<body>
	<%
		ArrayList<NhanVien> allItem = (ArrayList<NhanVien>) request.getAttribute("allItem");
		boolean isLogin = AuthenUtil.isLogin(request, response);
	%>
	<div class="container">
		<%@include file="../template/menu.jsp"%>
		<jsp:include page="../template/menu.jsp" />
		<div class="content">
			<%@include file="../template/logo.jsp"%>
			<form id= "search-form" action="javascript:void(0)" method="get" class="form">
                <input type="checkbox" name="filter[]" value="idnv"> <label for="idnv">IDNV</label>
                <input type="checkbox" name="filter[]" value="hoten" checked> <label for="name">Tên</label>
                <input type="checkbox" name="filter[]" value="idpb"> <label for="idpb">IDPB</label>
                <br/>
                <input type="text" name="keyword">
                <input type="submit" name="submit" value="Tìm kiếm">
            </form>
	        <table id="table-view">
			    <caption><h3>Danh sách nhân viên</h3></caption>
			    <tr>
			        <th>IDNV</th>
			        <th>Họ Tên</th>
			        <th>IDPB</th>
			        <th>Địa chỉ</th>
			        <% if(isLogin) { %>
	           			<th>Thao Tác</th>
	           		<% } %>
			    </tr>
			    <% for(NhanVien item : allItem) { %>
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
	<script>
        $(document).ready(function () {
            var searchForm = $("#search-form");
            searchForm.on("submit", function (e) {
                e.preventDefault();
                var data = searchForm.serializeArray();
                console.log(searchForm.serializeArray());
                $.ajax({
                    url: "./NhanVienIndexController",
                    type: "POST",
                    cache: false,
                    data: data,
                    success: function(res) {
                        $("#table-view").html(res);
                    },
                    error: function () {
                        console.log("error: search form");
                    }
                });
            });
        });
    </script>
</body>
</html>