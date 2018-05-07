package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NhanVienDAO;
import util.AuthenUtil;

@WebServlet("/NhanVienDelController")
public class NhanVienDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NhanVienDelController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!AuthenUtil.isLogin(request, response)) {
			response.sendRedirect("UserLoginController");
			return;
		}

		String idnv = request.getParameter("idnv");

		if (idnv.isEmpty()) {
			response.sendRedirect("PhongBanIndexController");
			return;
		}

		NhanVienDAO nvDAO = new NhanVienDAO();
		if (nvDAO.delItem(idnv)) {
			response.sendRedirect("PhongBanIndexController");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
