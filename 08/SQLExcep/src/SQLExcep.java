import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLExcep {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mysqltest";				// MySQL数据库的URL
        String DRIVER = "com.mysql.jdbc.Driver";						// MySQL数据库的驱动
        String USERNAME = "admin";	                              // 数据库的用户名
        String PASSWORD = "123456";
        Connection conn=null;
        try {
            Class.forName(DRIVER);										// 加载驱动
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 建立连接		// 建立连接
        } catch (SQLException e) {						// 捕获SQLException
            e.printStackTrace();
        } catch (ClassNotFoundException e) {			// 捕获ClassNotFoundException
            e.printStackTrace();
        } finally {
            try {
            	conn.close();						// 释放资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
