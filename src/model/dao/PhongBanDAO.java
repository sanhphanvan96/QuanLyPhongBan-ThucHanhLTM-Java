package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.PhongBan;
import util.DatabaseConnection;

public class PhongBanDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	private DatabaseConnection dc;
	private PhongBan pb = null;

	public PhongBanDAO() {
		super();
		try {
			dc = new DatabaseConnection();
			conn = dc.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PhongBan> getAllItem() {
		ArrayList<PhongBan> l = new ArrayList<PhongBan>();
		String sql = "SELECT idpb, mota, thoigian FROM phongban";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				pb = new PhongBan();
				pb.setIdpb(rs.getString("idpb"));
				pb.setMota(rs.getString("mota"));
				pb.setThoigian(rs.getString("thoigian"));
				l.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l;
	}

	public PhongBan getItem(String idpb) {
		String sql = "SELECT idpb, mota, thoigian FROM phongban WHERE idpb='" + idpb + "' LIMIT 1";
		System.out.println(sql);
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				pb = new PhongBan();
				pb.setIdpb(rs.getString("idpb"));
				pb.setMota(rs.getString("mota"));
				pb.setThoigian(rs.getString("thoigian"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pb;
	}
}
