<%@page import="model.bean.User"%>
<%@page import="util.AuthenUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="logo">
	<img src="./template/logo.jpg" alt="">
	<% if(AuthenUtil.isLogin(request, response)) { %>
		<p> You are <b><%= ((User) request.getSession().getAttribute("currentUser")).getUsername().toUpperCase() %></b></p>
	<% } %>
</div>