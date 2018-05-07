package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;

public class AuthenUtil {
	public static boolean isLogin(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("currentUser");

		return user == null ? false : true;

	}
}
