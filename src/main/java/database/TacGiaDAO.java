package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO implements IDAO<TacGia> {

	@Override
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> result = new ArrayList<>();
		try {
			// Create database connection
			Connection connection = JDBCUtil.getConnection();
			
			// Create statements
			String sql = "SELECT * FROM tacgia";
			PreparedStatement st = connection.prepareStatement(sql);
			
			// execute SQL statement
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String matacgia = rs.getString("matacgia");
				String tentacgia = rs.getString("tentacgia");
				Date ngaysinh = rs.getDate("ngaysinh");
				String tieusu = rs.getString("tieusu");
				
				TacGia tacgia = new TacGia(matacgia, tentacgia, ngaysinh, tieusu);
				result.add(tacgia);
			}
			
			// Close connection
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public TacGia selectById(TacGia t) {
		TacGia result = null;
		try {
			// Create database connection
			Connection connection = JDBCUtil.getConnection();
			
			// Create statements
			String sql = "SELECT * FROM tacgia WHERE matacgia = ?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, t.getMaTacGia());
			
			// Execute Statement
			ResultSet rs = pStatement.executeQuery();
			
			while (rs.next()) {
				String matacgia = rs.getString("matacgia");
				String tentacgia = rs.getString("tentacgia");
				Date ngaysinh = rs.getDate("ngaysinh");
				String tieusu = rs.getString("tieusu");
				
				result = new TacGia(matacgia, tentacgia, ngaysinh, tieusu);
				break;
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(TacGia t) {
		int result = 0;
		try {
			// Create database connection
			Connection connection = JDBCUtil.getConnection();
			
			// Create SQL statement
			String sql = "INSERT INTO tacgia (matacgia, tentacgia, ngaysinh, tieusu) " + 
			"VALUES (?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getMaTacGia());
			ps.setString(2, t.getHoVaTen());
			ps.setDate(3, t.getNgaySinh());
			ps.setString(4, t.getTieuSu());
			
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
	public int insertAll(ArrayList<TacGia> arr) {
		int count = 0;
		for (TacGia tacgia : arr) {
			count += this.insert(tacgia);
		}
		return count;
	}

	@Override
	public int delete(TacGia t) {
		int result = 0;
		try {
			// Create db connection
			Connection connection = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "DELETE FROM tacgia WHERE matacgia = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getMaTacGia());
			
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
	public int deleteAll(ArrayList<TacGia> arr) {
		int count = 0;
		for (TacGia tacgia : arr) {
			count += this.delete(tacgia);
		}
		return count;
	}

	@Override
	public int update(TacGia t) {
		int result = 0;
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "UPDATE tacgia " + 
						" SET " +
						" tentacgia = ?" + 
						" ngaysinh = ?" + 
						" tieusu = ?" + 
						" WHERE matacgia = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getHoVaTen());
			ps.setDate(2, t.getNgaySinh());
			ps.setString(3, t.getTieuSu());
			ps.setString(4, t.getMaTacGia());
			
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
