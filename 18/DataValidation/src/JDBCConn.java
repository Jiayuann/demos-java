import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCConn {
    static Connection conn = null;
    
    // 获取数据库连接
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
            if (conn != null) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 返回Connection对象
    }
    
    public void insertEmp(student emp) {
        conn = getConn(); // 获取数据库连接
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into student values(?,?,?,?,?)"); // 定义插入数据库的预处理语句
            statement.setInt(2, emp.getStudentid());// 设置预处理语句的参数值
            statement.setString(1, emp.getName()); 
            statement.setString(3, emp.getSex());
            statement.setInt(4, emp.getAge());
            statement.setString(5, emp.getDept());
            statement.executeUpdate(); // 执行预处理语句
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int selectEmpUseName(String name) {
        conn = getConn(); // 获取数据库连接
        Statement statment;
        int id = 0; // 定义保存返回值的int对象
        try {
            statment = conn.createStatement(); // 获取Statement对象
            String sql = "select studentid from student where name = '" + name + "'"; // 定义查询SQL语句
            ResultSet rest = statment.executeQuery(sql); // 执行查询语句获取查询结果集
            while (rest.next()) { // 循环遍历查询结果集
                id = rest.getInt(1); // 获取查询结果
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id; // 返回查询结果
    }
}
