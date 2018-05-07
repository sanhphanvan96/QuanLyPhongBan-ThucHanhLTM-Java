package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVien;
import model.dao.NhanVienDAO;
import util.AuthenUtil;

@WebServlet("/NhanVienAddController")
public class NhanVienAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NhanVienAddController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!AuthenUtil.isLogin(request, response)) {
			response.sendRedirect("UserLoginController");
			return;
		}

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/nhanvien/add.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!AuthenUtil.isLogin(request, response)) {
			response.sendRedirect("UserLoginController");
			return;
		}

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rd = request.getRequestDispatcher("/nhanvien/add.jsp");

		String idnv = request.getParameter("idnv");
		String hoten = request.getParameter("hoten");
		String idpb = request.getParameter("idpb");
		String diachi = request.getParameter("diachi");

		System.out.println(idnv + hoten + idpb + diachi);
		System.out.println(request.getCharacterEncoding());

		if (idnv.isEmpty() || hoten.isEmpty() || idpb.isEmpty() || diachi.isEmpty()) {
			rd.forward(request, response);
			return;
		}

		NhanVien nv = new NhanVien(idnv, hoten, idpb, diachi);
		NhanVienDAO nvDAO = new NhanVienDAO();
		nvDAO.addItem(nv);

		rd.forward(request, response);
	}

}
