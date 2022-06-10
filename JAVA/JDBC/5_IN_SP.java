import java.sql.*;

public class JdbcTest {
	static final String DB_URL = "jdbc:mysql://localhost:3308/mydb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "sherlock";

	public static void main(String[] args) throws ClassNotFoundException {
		PreparedStatement stmt = null;
		System.out.println("Starting...");
		// Open a connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt = conn.prepareCall("{call increase_mark(?,?)}");
			stmt.setInt(1, 34);
			stmt.setInt(2, 120);
			
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("End...");
	}
}