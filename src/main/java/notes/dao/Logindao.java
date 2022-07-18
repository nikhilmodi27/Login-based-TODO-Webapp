package notes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Logindao {

	public boolean checkuser(String uname, String pass) {
		boolean flag = false;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "Nikhil@8246");
			
            String sql = "SELECT * FROM userlogin WHERE USERNAME=? AND PASSWORD=? ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,uname);
			ps.setString(2,pass);
		    String un = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
			}
			

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
        return flag;
	}
}
