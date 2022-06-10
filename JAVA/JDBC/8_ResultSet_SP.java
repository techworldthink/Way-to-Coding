import java.sql.*;

public class JdbcTest {
	static final String DB_URL = "jdbc:mysql://localhost:3308/mydb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "sherlock";

	public static void main(String[] args) throws ClassNotFoundException {
		CallableStatement stmt = null;
		ResultSet res = null;
		System.out.println("Starting...");
		// Open a connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.prepareCall("{call get_names()}");
			stmt.execute();
			res = stmt.getResultSet();
			while (res.next()) {
				System.out.println("Name : "+res.getString("name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("End...");
	}
}