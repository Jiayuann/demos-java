import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class CatchExceptions {
    private static String URL = "jdbc:mysql://localhost:3306/mysqltest";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USERNAME = "root";
    private static String PASSWORD = "123456";
    private static Connection conn;
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);// ������������
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// ��������
            return conn;
        } catch (ClassNotFoundException e) {// ������Ϊ�����쳣
            e.printStackTrace();
        } catch (SQLException e) {// ����SQL�쳣
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        CatchExceptions.getConnection();
    }
}
