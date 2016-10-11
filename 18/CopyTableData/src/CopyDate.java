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
            Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    	String url = "jdbc:mysql://localhost:3306/mysqldemo"; // 定义与连接数据库的url
        String user = "root"; // 定义连接数据库的用户名
        String passWord = "123456"; // 定义连接数据库的密码
        try {
            conn = DriverManager.getConnection(url, user, passWord); // 获取数据库连接
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 返回Connection对象
    }
    
    public List getExcellenceStu() {
        conn = getConn(); // 获取与数据库的连接
        ResultSet rest;
        List list = new ArrayList();
        try {
            Statement statement = conn.createStatement(); // 获取Statement对象
            String sql = "select * from student"; // 定义查询语句
            rest = statement.executeQuery(sql); // 执行查询语句获取查询结果集
            while (rest.next()) { // 循环遍历查询结果集
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
        return list; // 返回集合
    }
    
    public void insertStu(int id) {
        conn = getConn(); // 获取与数据库的连接
        try {
            Statement statement = conn.createStatement(); // 获取Statement对象
            String sql = "insert into student2 select name,sex,specialty,grade from student where studentid = "
                    + id; // 定义插入数据的SQL语句
            statement.executeUpdate(sql); // 执行插入语句
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
