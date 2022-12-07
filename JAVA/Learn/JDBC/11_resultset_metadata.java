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

			ResultSetMetaData rslt = res.getMetaData();
			int columnCount = rslt.getColumnCount();

			System.out.println("Column count : " + columnCount);

			for (int col = 1; col <= columnCount; col++) {
				System.out.println("Column name : " + rslt.getColumnName(col));
				System.out.println("Column type name : " + rslt.getColumnTypeName(col));
				System.out.println("Is nullable : " + rslt.isNullable(col));
				System.out.println("Is auto increment : " + rslt.isAutoIncrement(col));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("End...");
	}
}