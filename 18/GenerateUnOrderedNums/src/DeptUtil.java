import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeptUtil {
    Connection conn = null;    
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
    
public void insertDept(Dept dept) {
    conn = getConn(); // ��ȡ���ݿ�����
    try {
        PreparedStatement statement = conn
                .prepareStatement("insert into deptinfo values(?,?,?)"); // ����������ݿ��Ԥ�������
        statement.setString(1,dept.getDid() ); // ����Ԥ�������Ĳ���ֵ
        statement.setString(2,dept.getdName());
        statement.setString(3, dept.getPriName());      
        statement.executeUpdate(); // ִ��Ԥ�������
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public List selectDept() {
        conn = getConn(); // ��ȡ���ݿ�����
        Statement statment;
        List list = new ArrayList<Dept>();
        try {
            statment = conn.createStatement(); // ��ȡStatement����
            String sql = "select * from deptinfo"; // �����ѯSQL���
            ResultSet rest = statment.executeQuery(sql); // ִ�в�ѯ����ȡ��ѯ�����
            while (rest.next()) { // ѭ��������ѯ�����
              Dept dept = new Dept();
              dept.setDid(rest.getString(1));
              dept.setdName(rest.getString(2));
              dept.setPriName(rest.getString(3));
              list.add(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // ���ز�ѯ���
    }
}
