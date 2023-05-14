package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.KhachHang;

public class KhachHangDAO implements IDAO<KhachHang> {

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> result = new ArrayList<>();
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "SELECT * FROM khachhang";
			PreparedStatement ps = connect.prepareStatement(sql);
			
			// Execute query
			ResultSet rs = ps.executeQuery();
			
			// Create object from db
			while (rs.next()) {
				String maKhachHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String tenKhachHang = rs.getString("tenkhachhang");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sdt");
				String email = rs.getString("email");
				Boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");
				String maXacThuc = rs.getString("maxacthuc");
				Timestamp thoiGianHieuLucMaXacThuc = rs.getTimestamp("thoigianhieulucmaxacthuc");
				Boolean daXacThuc = rs.getBoolean("daxacthuc");
				
				KhachHang khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, tenKhachHang, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, maXacThuc, thoiGianHieuLucMaXacThuc, daXacThuc);
				result.add(khachHang);
				
			}
			
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang result = null;
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "SELECT * FROM khachhang WHERE makhachhang = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getMaKhachHang());
			
			// Execute query
			ResultSet rs = ps.executeQuery();
			
			// Get data from db

			while (rs.next()) {
				String maKhachHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String tenKhachHang = rs.getString("tenkhachhang");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sdt");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");
				String maXacThuc = rs.getString("maxacthuc");
				Timestamp thoiGianHieuLucMaXacThuc = rs.getTimestamp("thoigianhieulucmaxacthuc");
				boolean daXacThuc = rs.getBoolean("daxacthuc");
				
				result = new KhachHang(maKhachHang, tenDangNhap, matKhau, tenKhachHang, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, maXacThuc, thoiGianHieuLucMaXacThuc, daXacThuc);
			}

			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean checkUsernameExist(String username) {
		boolean result = false;
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "SELECT * FROM khachhang WHERE tendangnhap = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, username);
			
			// Execute query
			ResultSet rs = ps.executeQuery();
			
			// Get data from db

			while (rs.next()) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insert(KhachHang t) {
		int result = 0;
		
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "INSERT INTO khachhang VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getMaKhachHang());
			ps.setString(2, t.getTenDangNhap());
			ps.setString(3, t.getMatKhau());
			ps.setString(4, t.getTenKH());
			ps.setString(5, t.getGioiTinh());
			ps.setString(6, t.getDiaChi());
			ps.setString(7, t.getDiaChiNhanHang());
			ps.setString(8, t.getDiaChiMuaHang());
			ps.setDate(9, t.getNgaySinh());
			ps.setString(10, t.getSdt());
			ps.setString(11, t.getEmail());
			ps.setBoolean(12, t.isDangKyNhanBangTin());
			ps.setString(13, t.getMaXacThuc());
			ps.setTimestamp(14, t.getThoiGianHieuLucMaXacThuc());
			ps.setBoolean(15, t.isDaXacThuc());
			
			// Execute query
			result = ps.executeUpdate();
			
			System.out.println("Query: " + sql);
			System.out.println("Có " + result + " dòng đã bị thay đổi");
			
			// Close connection
			JDBCUtil.closeConnection(connect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insertAll(ArrayList<KhachHang> arr) {
		int count = 0;
		for (KhachHang khachHang : arr) {
			count += this.insert(khachHang);
		}
		return count;
	}

	@Override
	public int delete(KhachHang t) {
		int result = 0;
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "DELETE FROM khachhang WHERE makhachhang = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getMaKhachHang());
			
			// Execute query
			result = ps.executeUpdate();
			
			System.out.println("Query: " + sql);
			System.out.println("Có " + result + " dòng đã bị thay đổi");
			
			// Close connection
			JDBCUtil.closeConnection(connect);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arr) {
		int count = 0;
		for (KhachHang khachHang : arr) {
			count += this.delete(khachHang);
		}
		return count;
	}

	@Override
	public int update(KhachHang t) {
		int result = 0;
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "UPDATE khachhang" +
						" SET " +
						" tendangnhap = ?" +
						", matkhau = ?" +
						", tenkhachhang = ?" +
						", gioitinh = ?" +
						", diachi = ?" +
						", diachinhanhang = ?" +
						", diachimuahang = ?" +
						", ngaysinh = ?" +
						", sdt = ?" +
						", email = ?" +
						", dangkynhanbangtin = ?" +
						", maxacthuc = ?" +
						", thoigianhieulucmaxacthuc = ?" +
						", daxacthuc = ?" +
						" WHERE makhachhang = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getTenDangNhap());
			ps.setString(2, t.getMatKhau());
			ps.setString(3, t.getTenKH());
			ps.setString(4, t.getGioiTinh());
			ps.setString(5, t.getDiaChi());
			ps.setString(6, t.getDiaChiNhanHang());
			ps.setString(7, t.getDiaChiMuaHang());
			ps.setDate(8, t.getNgaySinh());
			ps.setString(9, t.getSdt());
			ps.setString(10, t.getEmail());
			ps.setBoolean(11, t.isDangKyNhanBangTin());
			ps.setString(12, t.getMaXacThuc());
			ps.setTimestamp(13, t.getThoiGianHieuLucMaXacThuc());
			ps.setBoolean(14, t.isDaXacThuc());
			ps.setString(15, t.getMaKhachHang());
			
			// Execute query
			result = ps.executeUpdate();
			
			System.out.println("Có " + result + " dòng được cập nhật");
			
			// Close connection
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public KhachHang selectByUsernameAndPwd(KhachHang t) {
		KhachHang result = null;
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "SELECT * FROM khachhang WHERE tendangnhap = ? AND matkhau = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getTenDangNhap());
			ps.setString(2, t.getMatKhau());
			
			// Execute query
			ResultSet rs = ps.executeQuery();
			
			// Get data from db

			while (rs.next()) {
				String maKhachHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String tenKhachHang = rs.getString("tenkhachhang");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sdt");
				String email = rs.getString("email");
				Boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");
				String maXacThuc = rs.getString("maxacthuc");
				Timestamp thoiGianHieuLucMaXacThuc = rs.getTimestamp("thoigianhieulucmaxacthuc");
				Boolean daXacThuc = rs.getBoolean("daxacthuc");
				
				result = new KhachHang(maKhachHang, tenDangNhap, matKhau, tenKhachHang, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, maXacThuc, thoiGianHieuLucMaXacThuc, daXacThuc);
				break;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean changePassword(KhachHang t) {
		int result = 0;
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "UPDATE khachhang SET matkhau = ? WHERE makhachhang = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getMatKhau());
			ps.setString(2, t.getMaKhachHang());
			
			// Execute query
			result = ps.executeUpdate();
			
			System.out.println("Có " + result + " dòng được cập nhật");
			
			// Close connection
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result>0;
	}
	
	public int updateInfor(KhachHang t) {
		int result = 0;
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "UPDATE khachhang " +
						" SET " +
						" tenkhachhang = ?" +
						", gioitinh = ?" +
						", diachi = ?" +
						", diachinhanhang = ?" +
						", diachimuahang = ?" +
						", ngaysinh = ?" +
						", sdt = ?" +
						", email = ?" +
						", dangkynhanbangtin = ?" +
						", maxacthuc = ?" +
						", thoigianhieulucmaxacthuc = ?" +
						", daxacthuc = ?" +
						" WHERE makhachhang = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getTenKH());
			ps.setString(2, t.getGioiTinh());
			ps.setString(3, t.getDiaChi());
			ps.setString(4, t.getDiaChiNhanHang());
			ps.setString(5, t.getDiaChiMuaHang());
			ps.setDate(6, t.getNgaySinh());
			ps.setString(7, t.getSdt());
			ps.setString(8, t.getEmail());
			ps.setBoolean(9, t.isDangKyNhanBangTin());
			ps.setString(10, t.getMaXacThuc());
			ps.setTimestamp(11, t.getThoiGianHieuLucMaXacThuc());
			ps.setBoolean(12, t.isDaXacThuc());
			ps.setString(13, t.getMaKhachHang());
			
			// Execute query
			result = ps.executeUpdate();
			
			System.out.println("Có " + result + " dòng được cập nhật");
			
			// Close connection
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateVerifyInformation(KhachHang t) {
		int result = 0;
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "UPDATE khachhang " +
						" SET " +
						" maxacthuc = ?" +
						", thoigianhieulucmaxacthuc = ?" +
						", daxacthuc = ?" +
						" WHERE makhachhang = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getMaXacThuc());
			ps.setTimestamp(2, t.getThoiGianHieuLucMaXacThuc());
			ps.setBoolean(3, t.isDaXacThuc());
			ps.setString(4, t.getMaKhachHang());
			
			// Execute query
			result = ps.executeUpdate();
			
			System.out.println("Có " + result + " dòng được cập nhật");
			
			// Close connection
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
