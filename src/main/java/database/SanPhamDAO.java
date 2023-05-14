package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.SanPham;
import model.TacGia;
import model.TheLoai;

public class SanPhamDAO implements IDAO<SanPham> {

	@Override
	public ArrayList<SanPham> selectAll() {
		ArrayList<SanPham> result = new ArrayList<>();
		try {
			// Create database connection
			Connection connection = JDBCUtil.getConnection();
			
			// Create statements
			String sql = "SELECT * FROM sanpham";
			PreparedStatement st = connection.prepareStatement(sql);
			
			// execute SQL statement
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String maSanPham = rs.getString("masanpham");
				String tenSanPham = rs.getString("tensanpham");
				String maTacGia = rs.getString("matacgia");
				int namXuatBan = rs.getInt("namxuatban");
				double giaNhap = rs.getDouble("gianhap");
				double giaGoc = rs.getDouble("giagoc");
				double giaBan = rs.getDouble("giaban");
				int soLuong = rs.getInt("soluong");
				String maTheLoai = rs.getString("matheloai");
				String ngonNgu = rs.getNString("ngonngu");
				String moTa = rs.getString("mota");
				
				TacGia tacGia = new TacGiaDAO().selectById(new TacGia(maTacGia, null, null, null));
				TheLoai theLoai = new TheLoaiDAO().selectById(new TheLoai(maTheLoai, null));
				SanPham sanPham = new SanPham(maSanPham, tenSanPham, tacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong, theLoai, ngonNgu, moTa);
				
				result.add(sanPham);
			}
			
			// Close connection
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public SanPham selectById(SanPham t) {
		SanPham result = null;
		try {
			// Create database connection
			Connection connection = JDBCUtil.getConnection();
			
			// Create statements
			String sql = "SELECT * FROM sanpham WHERE masanpham = ?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, t.getMaSanPham());
			
			// Execute Statement
			ResultSet rs = pStatement.executeQuery();
			
			while (rs.next()) {
				String maSanPham = rs.getString("masanpham");
				String tenSanPham = rs.getString("tensanpham");
				String maTacGia = rs.getString("matacgia");
				int namXuatBan = rs.getInt("namxuatban");
				double giaNhap = rs.getDouble("gianhap");
				double giaGoc = rs.getDouble("giagoc");
				double giaBan = rs.getDouble("giaban");
				int soLuong = rs.getInt("soluong");
				String maTheLoai = rs.getString("matheloai");
				String ngonNgu = rs.getNString("ngonngu");
				String moTa = rs.getString("mota");
				
				TacGia tacGia = new TacGiaDAO().selectById(new TacGia(maTacGia, null, null, null));
				TheLoai theLoai = new TheLoaiDAO().selectById(new TheLoai(maTheLoai, null));
				
				result = new SanPham(maSanPham, tenSanPham, tacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong, theLoai, ngonNgu, moTa);
				break;
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(SanPham t) {
		int result = 0;
		try {
			// Create database connection
			Connection connection = JDBCUtil.getConnection();
			
			// Create SQL statement
			String sql = "INSERT INTO sanpham (masanpham, tensanpham, matacgia, namxuatban, gianhap, giagoc, giaban, soluong, matheloai, ngonngu, mota) " + 
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getMaSanPham());
			ps.setString(2, t.getTenSanPham());
			ps.setString(3, t.getMaTacGia().getMaTacGia());
			ps.setInt(4, t.getNamXB());
			ps.setDouble(5, t.getGiaNhap());
			ps.setDouble(6, t.getGiaGoc());
			ps.setDouble(7, t.getGiaBan());
			ps.setInt(8, t.getSoLuong());
			ps.setString(9, t.getTheLoai().getMaTheLoai());
			ps.setString(10, t.getNgonNgu());
			ps.setString(11, t.getMoTa());
			
			// Execute query
			result = ps.executeUpdate();
			
			System.out.println("Query: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi.");
			
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertAll(ArrayList<SanPham> arr) {
		int count = 0;
		for (SanPham sanPham : arr) {
			count += this.insert(sanPham);
		}
		return count;
	}

	@Override
	public int delete(SanPham t) {
		int result = 0;
		try {
			// Create db connection
			Connection connection = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "DELETE FROM sanpham WHERE masanpham = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getMaSanPham());
			
			// Execute query
			result = ps.executeUpdate();
			
			System.out.println("Query: " + sql);
			System.out.println("Có " + result + " dòng đã bị thay đổi");
			
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteAll(ArrayList<SanPham> arr) {
		int count = 0;
		for (SanPham sanPham : arr) {
			count += this.delete(sanPham);
		}
		return count;
	}

	@Override
	public int update(SanPham t) {
		int result = 0;
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "UPDATE sanpham " + 
						" SET " +
						" tensanpham = ?" + 
						" matacgia = ?" + 
						" namxuatban = ?" + 
						" gianhap = ?" +
						" giagoc = ?" +
						" giaban = ?" +
						" soluong = ?" +
						" matheloai = ?" +
						" ngonngu = ?" +
						" mota = ?" +
						" WHERE masanpham = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getTenSanPham());
			ps.setString(2, t.getMaTacGia().getMaTacGia());
			ps.setInt(3, t.getNamXB());
			ps.setDouble(4, t.getGiaNhap());
			ps.setDouble(5, t.getGiaGoc());
			ps.setDouble(6, t.getGiaBan());
			ps.setInt(7, t.getSoLuong());
			ps.setString(8, t.getTheLoai().getMaTheLoai());
			ps.setString(9, t.getNgonNgu());
			ps.setString(10, t.getMoTa());
			ps.setString(11, t.getMaSanPham());
			
			// Execute query
			result = ps.executeUpdate();
			
			System.out.println("Query: " + sql);
			System.out.println("Có " + result + " dòng đã bị thay đổi");
			
			JDBCUtil.closeConnection(connect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
