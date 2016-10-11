import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CNFExcep {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rst = null;
		String s = "";
		Class.forName("com.mysql.jdbc.Driver");
		// 注册驱动程序
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/myuser", "root", "root");
		// 获得数据库的连接
		stmt = conn.createStatement();
		// 创建会话声明
		rst = stmt.executeQuery("select * from user");
		while (rst.next()) {
			System.out.print(s = new String(rst.getString(1).getBytes(
					"ISO-8859-1"), "GBK")
					+ "--");
			System.out.print(s = new String(rst.getString(2).getBytes(
					"ISO-8859-1"), "GBK")
					+ "--");
			System.out.print(s = new String(rst.getString(3).getBytes(
					"ISO-8859-1"), "GBK")
					+ "--");
			System.out.print(s = new String(rst.getString(4).getBytes(
					"ISO-8859-1"), "GBK"));
			System.out.println();
		}
	}
}
