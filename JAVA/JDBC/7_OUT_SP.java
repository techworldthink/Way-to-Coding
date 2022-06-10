import java.sql.*;

public class JdbcTest {
	static final String DB_URL = "jdbc:mysql://localhost:3308/mydb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "sherlock";

	public static void main(String[] args) throws ClassNotFoundException {
		CallableStatement stmt = null;
		String res = null;
		System.out.println("Starting...");
		// Open a connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.prepareCall("{call get_name_by_id(?,?)}");
			stmt.setInt(1, 34);
			stmt.registerOutParameter(2, Types.VARCHAR);

			stmt.execute();
			res = stmt.getString(2);
			System.out.println("New dept name is : " + res);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("End...");
	}
}