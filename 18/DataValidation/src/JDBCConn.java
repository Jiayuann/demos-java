import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCConn {
    static Connection conn = null;
    
    // ��ȡ���ݿ�����
    public Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�����
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    	String url = "jdbc:mysql://localhost:3306/mysqldemo"; // �������������ݿ��url
        String user = "root"; // �����������ݿ���û���
        String passWord = "123456"; // �����������ݿ������
        try {
            conn = DriverManager.getConnection(url, user, passWord); // ��ȡ���ݿ�����
            if (conn != null) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // ����Connection����
    }
    
    public void insertEmp(student emp) {
        conn = getConn(); // ��ȡ���ݿ�����
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into student values(?,?,?,?,?)"); // ����������ݿ��Ԥ�������
            statement.setInt(2, emp.getStudentid());// ����Ԥ�������Ĳ���ֵ
            statement.setString(1, emp.getName()); 
            statement.setString(3, emp.getSex());
            statement.setInt(4, emp.getAge());
            statement.setString(5, emp.getDept());
            statement.executeUpdate(); // ִ��Ԥ�������
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int selectEmpUseName(String name) {
        conn = getConn(); // ��ȡ���ݿ�����
        Statement statment;
        int id = 0; // ���屣�淵��ֵ��int����
        try {
            statment = conn.createStatement(); // ��ȡStatement����
            String sql = "select studentid from student where name = '" + name + "'"; // �����ѯSQL���
            ResultSet rest = statment.executeQuery(sql); // ִ�в�ѯ����ȡ��ѯ�����
            while (rest.next()) { // ѭ��������ѯ�����
                id = rest.getInt(1); // ��ȡ��ѯ���
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id; // ���ز�ѯ���
    }
}
