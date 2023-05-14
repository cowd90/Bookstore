package model;

import java.sql.Date;
import java.sql.Timestamp;

public class KhachHang {
	private String maKhachHang;
	private String tenDangNhap;
	private String matKhau;
	private String tenKH;
	private String gioiTinh;
	private String diaChi;
	private String diaChiNhanHang;
	private String diaChiMuaHang;
	private Date ngaySinh;
	private String sdt;
	private String email;
	private boolean dangKyNhanBangTin;
	private String maXacThuc;
	private Timestamp thoiGianHieuLucMaXacThuc;
	private boolean daXacThuc;
	
	public KhachHang() {
		
	}

	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String tenKH, String gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String sdt, String email,
			boolean dangKyNhanBangTin) {
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.email = email;
		this.dangKyNhanBangTin = dangKyNhanBangTin;
	}

	
	
	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String tenKH, String gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String sdt, String email,
			boolean dangKyNhanBangTin, String maXacThuc, Timestamp thoiGianHieuLucMaXacThuc, boolean xacThucEmail) {
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.email = email;
		this.dangKyNhanBangTin = dangKyNhanBangTin;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
		this.daXacThuc = xacThucEmail;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public String getDiaChiMuaHang() {
		return diaChiMuaHang;
	}

	public void setDiaChiMuaHang(String diaChiMuaHang) {
		this.diaChiMuaHang = diaChiMuaHang;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDangKyNhanBangTin() {
		return dangKyNhanBangTin;
	}

	public void setDangKyNhanBangTin(boolean dangKyNhanBangTin) {
		this.dangKyNhanBangTin = dangKyNhanBangTin;
	}

	public String getMaXacThuc() {
		return maXacThuc;
	}

	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}

	public Timestamp getThoiGianHieuLucMaXacThuc() {
		return thoiGianHieuLucMaXacThuc;
	}

	public void setThoiGianHieuLucMaXacThuc(Timestamp thoiGianHieuLucMaXacThuc) {
		this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
	}

	public boolean isDaXacThuc() {
		return daXacThuc;
	}

	public void setXacThucEmail(boolean xacThucEmail) {
		this.daXacThuc = xacThucEmail;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", tenKH=" + tenKH + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", diaChiNhanHang="
				+ diaChiNhanHang + ", diaChiMuaHang=" + diaChiMuaHang + ", ngaySinh=" + ngaySinh + ", sdt=" + sdt
				+ ", email=" + email + ", dangKyNhanBangTin=" + dangKyNhanBangTin + "]";
	}
	
	
	
}
