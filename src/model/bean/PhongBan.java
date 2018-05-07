package model.bean;

public class PhongBan {
	private String idpb;
	private String mota;
	private String thoigian;

	public String getIdpb() {
		return idpb;
	}

	public void setIdpb(String idpb) {
		this.idpb = idpb;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getThoigian() {
		return thoigian;
	}

	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}

	public PhongBan(String idpb, String mota, String thoigian) {
		super();
		this.idpb = idpb;
		this.mota = mota;
		this.thoigian = thoigian;
	}

	public PhongBan() {
		super();
	}

}
