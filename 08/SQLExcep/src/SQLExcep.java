import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLExcep {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mysqltest";				// MySQL���ݿ��URL
        String DRIVER = "com.mysql.jdbc.Driver";						// MySQL���ݿ������
        String USERNAME = "admin";	                              // ���ݿ���û���
        String PASSWORD = "123456";
        Connection conn=null;
        try {
            Class.forName(DRIVER);										// ��������
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// ��������		// ��������
        } catch (SQLException e) {						// ����SQLException
            e.printStackTrace();
        } catch (ClassNotFoundException e) {			// ����ClassNotFoundException
            e.printStackTrace();
        } finally {
            try {
            	conn.close();						// �ͷ���Դ
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
