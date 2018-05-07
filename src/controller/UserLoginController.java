package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.dao.UserDAO;
import util.AuthenUtil;

@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (AuthenUtil.isLogin(request, response)) {
			response.sendRedirect("PhongBanIndexController");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/user/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.isEmpty() || password.isEmpty()) {
			doGet(request, response);
			return;
		}

		User u = new User(username, password);
		UserDAO uDAO = new UserDAO();

		if (!uDAO.checkLogin(u)) {
			doGet(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("currentUser", uDAO.getCurrentUser());

		response.sendRedirect("PhongBanIndexController");
	}

}
