package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.AuthenUtil;

@WebServlet("/UserLogoutController")
public class UserLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLogoutController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!AuthenUtil.isLogin(request, response)) {
			response.sendRedirect("UserLoginController");
			return;
		}

		HttpSession session = request.getSession();
		session.invalidate(); // remove session

		response.sendRedirect("UserLoginController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
