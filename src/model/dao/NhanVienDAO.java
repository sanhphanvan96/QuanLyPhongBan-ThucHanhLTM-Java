package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.NhanVien;
import model.bean.PhongBan;
import sun.security.pkcs11.Secmod.DbMode;
import util.DatabaseConnection;

public class NhanVienDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	private DatabaseConnection dc;
	private PhongBan pb;
	private NhanVien nv = null;

	public NhanVienDAO() {
		super();
		try {
			dc = new DatabaseConnection();
			conn = dc.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<NhanVien> getAllNhanVienByPhongBan(String idpb) {
		ArrayList<NhanVien> l = new ArrayList<>();
		String sql = "SELECT * FROM nhanvien WHERE idpb = '" + idpb + "'";
		System.out.println(sql);
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				nv = new NhanVien();
				nv.setIdnv(rs.getString("idnv"));
				nv.setHoten(rs.getString("hoten"));
				nv.setDiachi(rs.getString("diachi"));
				nv.setIdpb(rs.getString("idpb"));
				l.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	public boolean addItem(NhanVien nv) {
		String sql = "INSERT INTO nhanvien(idnv,hoten,idpb,diachi) values(?,?,?,?)";
		try {
			conn = dc.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, nv.getIdnv());
			pst.setString(2, nv.getHoten());
			pst.setString(3, nv.getIdpb());
			pst.setString(4, nv.getDiachi());

			System.out.println(pst);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public NhanVien getItem(String idnv) {
		String sql = "SELECT * FROM nhanvien WHERE idnv = '" + idnv + "' LIMIT 1";
		System.out.println(sql);
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				nv = new NhanVien();
				nv.setIdnv(rs.getString("idnv"));
				nv.setHoten(rs.getString("hoten"));
				nv.setDiachi(rs.getString("diachi"));
				nv.setIdpb(rs.getString("idpb"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}

	public boolean editItem(NhanVien nv) {
		String sql = "UPDATE nhanvien SET hoten = ?, idpb = ? , diachi = ? WHERE idnv = ?";
		try {
			conn = dc.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, nv.getHoten());
			pst.setString(2, nv.getIdpb());
			pst.setString(3, nv.getDiachi());
			pst.setString(4, nv.getIdnv());

			System.out.println(pst);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delItem(String idnv) {
		String sql = "DELETE FROM nhanvien WHERE idnv = ?";
		try {
			conn = dc.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, idnv);

			System.out.println(pst);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<NhanVien> getAllItem() {
		ArrayList<NhanVien> l = new ArrayList<NhanVien>();
		String sql = "SELECT * FROM nhanvien";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				nv = new NhanVien();
				nv.setIdnv(rs.getString("idnv"));
				nv.setHoten(rs.getString("hoten"));
				nv.setDiachi(rs.getString("diachi"));
				nv.setIdpb(rs.getString("idpb"));
				l.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	public ArrayList<NhanVien> getItemsByKeyWord(String keyword, String[] filter) {
		if (keyword.trim().isEmpty()) {
			return getAllItem();
		}
		ArrayList<NhanVien> l = new ArrayList<NhanVien>();

		String sql = "SELECT * FROM nhanvien";
		String clause = " WHERE ";

		for (String c : filter) {
			if (!c.isEmpty() && c.equals("idnv") || c.equals("idpb") || c.equals("hoten")) {
				sql += clause + c + " LIKE ?";
				clause = " OR "; // change to OR after first
			}
		}
		
		try {
			pst = conn.prepareStatement(sql);
			for (int i = 1; i <= filter.length; i++) {
				pst.setString(i, "%" + keyword + "%");
			}
			System.out.println(pst);
			rs = pst.executeQuery();
			while (rs.next()) {
				nv = new NhanVien();
				nv.setIdnv(rs.getString("idnv"));
				nv.setHoten(rs.getString("hoten"));
				nv.setDiachi(rs.getString("diachi"));
				nv.setIdpb(rs.getString("idpb"));
				l.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
}
