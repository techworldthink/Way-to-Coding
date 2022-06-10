import java.sql.*;

public class JdbcTest {
	static final String DB_URL = "jdbc:mysql://localhost:3308/mydb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "sherlock";

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Starting...");
		// Open a connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			// Metadata
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			
			// Display info about databases
			System.out.println("Product name : " + databaseMetaData.getDatabaseProductName());
			System.out.println("Product version : " + databaseMetaData.getDatabaseProductVersion());
			System.out.println();
			
			// Display info about JDBC driver
			System.out.println("JDBC Driver name : " + databaseMetaData.getDriverName());
			System.out.println("JDBC Driver version : " + databaseMetaData.getDriverVersion());
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("End...");
	}
}