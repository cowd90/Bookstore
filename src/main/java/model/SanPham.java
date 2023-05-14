package model;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private TacGia maTacGia;
	private int namXB;
	private double giaNhap;
	private double giaGoc;
	private double giaBan;
	private int soLuong;
	private TheLoai theLoai;
	private String ngonNgu;
	private String moTa;
	
	public SanPham() {
		
	}

	public SanPham(String maSanPham, String tenSanPham, TacGia maTacGia, int namXB, double giaNhap, double giaGoc,
			double giaBan, int soLuong, TheLoai theLoai, String ngonNgu, String moTa) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.maTacGia = maTacGia;
		this.namXB = namXB;
		this.giaNhap = giaNhap;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.theLoai = theLoai;
		this.ngonNgu = ngonNgu;
		this.moTa = moTa;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public TacGia getMaTacGia() {
		return maTacGia;
	}

	public void setMaTacGia(TacGia maTacGia) {
		this.maTacGia = maTacGia;
	}

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaGoc() {
		return giaGoc;
	}

	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public TheLoai getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", maTacGia=" + maTacGia + ", namXB="
				+ namXB + ", giaNhap=" + giaNhap + ", giaGoc=" + giaGoc + ", giaBan=" + giaBan + ", soLuong=" + soLuong
				+ ", theLoai=" + theLoai + ", ngonNgu=" + ngonNgu + ", moTa=" + moTa + "]";
	}
	
	
	
}
