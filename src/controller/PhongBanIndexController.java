package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.PhongBan;
import model.dao.PhongBanDAO;

@WebServlet("/PhongBanIndexController")
public class PhongBanIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PhongBanIndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<PhongBan> listPB;
		PhongBanDAO pbDAO = new PhongBanDAO();
		listPB = pbDAO.getAllItem();
		request.setAttribute("allItem", listPB);
		RequestDispatcher rd = request.getRequestDispatcher("/phongban/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
