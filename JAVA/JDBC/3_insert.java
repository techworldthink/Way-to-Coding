import java.sql.*;

public class JdbcTest {
	static final String DB_URL = "jdbc:mysql://localhost:3308/mydb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "sherlock";
	static final String QUERY = "INSERT INTO "+
								"mytable(id,name,mark1,mark2,subject)" +
								"VALUES(1,'A',12,23,'CHEM')";

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Starting...");
		// Open a connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			int rowsAffected = stmt.executeUpdate(QUERY);
			System.out.println("Rows affected : " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("End...");
	}
}