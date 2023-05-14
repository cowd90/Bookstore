package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO implements IDAO<TheLoai> {

	@Override
	public ArrayList<TheLoai> selectAll() {
		ArrayList<TheLoai> result = new ArrayList<>();
		try {
			// Create database connection
			Connection connection = JDBCUtil.getConnection();
			
			// Create statements
			String sql = "SELECT * FROM theloai";
			PreparedStatement st = connection.prepareStatement(sql);
			
			// execute SQL statement
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String matheloai = rs.getString("matheloai");
				String tentheloai = rs.getString("tentheloai");
				
				TheLoai theloai = new TheLoai(matheloai, tentheloai);
				result.add(theloai);
			}
			
			// Close connection
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		TheLoai result = null;
		try {
			// Create database connection
			Connection connection = JDBCUtil.getConnection();
			
			// Create statements
			String sql = "SELECT * FROM theloai WHERE matheloai = ?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, t.getMaTheLoai());
			
			// Execute Statement
			ResultSet rs = pStatement.executeQuery();
			
			while (rs.next()) {
				String matheloai = rs.getString("matheloai");
				String tentheloai = rs.getString("tentheloai");
				
				result = new TheLoai(matheloai, tentheloai);
				break;
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(TheLoai t) {
		int result = 0;
		try {
			// Create database connection
			Connection connection = JDBCUtil.getConnection();
			
			// Create SQL statement
			String sql = "INSERT INTO theloai (matheloai, tentheloai) " + 
			"VALUES (?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getMaTheLoai());
			ps.setString(2, t.getTenTheLoai());
			
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
	public int insertAll(ArrayList<TheLoai> arr) {
		int count = 0;
		for (TheLoai theLoai : arr) {
			count += this.insert(theLoai);
		}
		return count;
	}

	@Override
	public int delete(TheLoai t) {
		int result = 0;
		try {
			// Create db connection
			Connection connection = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "DELETE FROM theloai WHERE matheloai = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getMaTheLoai());
			
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
	public int deleteAll(ArrayList<TheLoai> arr) {
		int count = 0;
		for (TheLoai theLoai : arr) {
			count += this.delete(theLoai);
		}
		return count;
	}

	@Override
	public int update(TheLoai t) {
		int result = 0;
		try {
			// Create db connection
			Connection connect = JDBCUtil.getConnection();
			
			// Create sql statement
			String sql = "UPDATE theloai " + 
						" SET " +
						" tentheloai = ?" + 
						" WHERE matheloai = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getTenTheLoai());
			ps.setString(2, t.getMaTheLoai());
			
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
