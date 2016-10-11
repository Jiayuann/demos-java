import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class DataBaseException {
	public static void main(String[] args) {
		String ul = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载驱动程序
		} catch (Exception e) {
			System.out.println("加载驱动出错");
		}
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/", "root", "123456");// 建立链接
			SQLWarning warn = con.getWarnings();// 创建SQLWarning对象
			int num = 1;
			while (warn != null) {
				System.out.println("第" + num + "警告");
				System.out.println("SQL state" + warn.getSQLState());
				System.out.println("警告信息" + warn.getMessage());
				System.out.println("警告代码" + warn.getErrorCode());
				warn = warn.getNextWarning();
				num++;
			}
		} catch (SQLException e) {
			while (e != null) {
				System.out.println("SQL state" + e.getSQLState());
				System.out.println("错误消息" + e.getMessage());
				System.out.println("错误代码" + e.getErrorCode());
				e = e.getNextException();
			}
		}
	}
}
