import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CopyDate {
    private Connection conn;
    
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
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // ����Connection����
    }
    
    public List getExcellenceStu() {
        conn = getConn(); // ��ȡ�����ݿ������
        ResultSet rest;
        List list = new ArrayList();
        try {
            Statement statement = conn.createStatement(); // ��ȡStatement����
            String sql = "select * from student"; // �����ѯ���
            rest = statement.executeQuery(sql); // ִ�в�ѯ����ȡ��ѯ�����
            while (rest.next()) { // ѭ��������ѯ�����
            	Student2 Stu = new Student2();
                Stu.setStudentid(rest.getInt(1));
                Stu.setName(rest.getString(2));
                Stu.setSex(rest.getString(3));
                Stu.setSpecialty(rest.getString(4));
                Stu.setGrade(rest.getString(5));
                list.add(Stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // ���ؼ���
    }
    
    public void insertStu(int id) {
        conn = getConn(); // ��ȡ�����ݿ������
        try {
            Statement statement = conn.createStatement(); // ��ȡStatement����
            String sql = "insert into student2 select name,sex,specialty,grade from student where studentid = "
                    + id; // ����������ݵ�SQL���
            statement.executeUpdate(sql); // ִ�в������
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
