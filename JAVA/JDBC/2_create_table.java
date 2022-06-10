import java.sql.*;

public class JdbcTest {
	static final String DB_URL = "jdbc:mysql://localhost:3308/mydb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "sherlock";
	static final String QUERY = "CREATE TABLE mytable(id int,name varchar(20),mark1 int,mark2 int,subject varchar(10))";

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Starting...");
		// Open a connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(QUERY);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("End...");
	}
}