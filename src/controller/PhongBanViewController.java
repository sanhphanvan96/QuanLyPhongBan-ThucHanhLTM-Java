package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVien;
import model.bean.PhongBan;
import model.dao.NhanVienDAO;
import model.dao.PhongBanDAO;

@WebServlet("/PhongBanViewController")
public class PhongBanViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PhongBanViewController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idpb = request.getParameter("idpb");
		if (!idpb.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/phongban/view.jsp");
			
			PhongBanDAO pbDAO = new PhongBanDAO();
			PhongBan pb = pbDAO.getItem(idpb);
			request.setAttribute("currentPB", pb);
			
			ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
			NhanVienDAO nvDAO = new NhanVienDAO();
			request.setAttribute("listNV", nvDAO.getAllNhanVienByPhongBan(pb.getIdpb()));
			
			rd.forward(request, response);
			return;
		}
		response.sendRedirect("/phongban/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
