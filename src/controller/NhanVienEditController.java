package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVien;
import model.dao.NhanVienDAO;
import util.AuthenUtil;

@WebServlet("/NhanVienEditController")
public class NhanVienEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NhanVienEditController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (!AuthenUtil.isLogin(request, response)) {
			response.sendRedirect("UserLoginController");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/nhanvien/edit.jsp");

		String idnv = request.getParameter("idnv");
		if (idnv.isEmpty()) {
			response.sendRedirect("PhongBanIndexController");
			return;
		}
		NhanVienDAO nvDAO = new NhanVienDAO();
		NhanVien nv = nvDAO.getItem(idnv);
		request.setAttribute("nv", nv);
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (!AuthenUtil.isLogin(request, response)) {
			response.sendRedirect("UserLoginController");
			return;
		}

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String idnv = request.getParameter("idnv");
		String hoten = request.getParameter("hoten");
		String idpb = request.getParameter("idpb");
		String diachi = request.getParameter("diachi");
		
		if (idnv.isEmpty() || hoten.isEmpty() || idpb.isEmpty() || diachi.isEmpty()) {
			return;
		}

		NhanVien nv = new NhanVien(idnv, hoten, idpb, diachi);
		NhanVienDAO nvDAO = new NhanVienDAO();
		nvDAO.editItem(nv);
		
		doGet(request, response);
	}

}
