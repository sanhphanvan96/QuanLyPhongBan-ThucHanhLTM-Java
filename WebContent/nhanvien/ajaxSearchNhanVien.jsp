<%@page import="util.AuthenUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ArrayList<NhanVien> allItem = (ArrayList<NhanVien>) request.getAttribute("allItem");
	boolean isLogin = AuthenUtil.isLogin(request, response);
%>
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