package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.bean.User;
import util.DatabaseConnection;

public class UserDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	private DatabaseConnection dc;
	private User user = null;

	public UserDAO() {
		super();
		try {
			dc = new DatabaseConnection();
			conn = dc.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkLogin(User u) {
		String sql = "SELECT * FROM admin WHERE username = ? AND password = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPassword());
			
			System.out.println(pst);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("username"), rs.getString("password"));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public User getCurrentUser() {
		return user;
	}

}
