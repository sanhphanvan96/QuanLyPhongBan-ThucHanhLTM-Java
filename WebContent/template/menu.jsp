<%@page import="util.AuthenUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="menu">
	<ul>
		<li><a href="<%= request.getContextPath() %>/PhongBanIndexController">Trang chủ</a></li>
		<li><a href="<%= request.getContextPath() %>/PhongBanIndexController">Phòng ban</a></li>
		<li><a href="<%= request.getContextPath() %>/NhanVienIndexController">Nhân viên</a></li>
		<% if(AuthenUtil.isLogin(request, response)) { %>
			<li><a href="<%= request.getContextPath() %>/NhanVienAddController">Thêm nhân viên</a></li>
			<li><a href="<%= request.getContextPath() %>/UserLogoutController">Đăng Xuất</a></li>
		<% } else { %>
			<li><a href="<%= request.getContextPath() %>/UserLoginController">Đăng nhập</a></li>
		<% } %>
	</ul>
</div>