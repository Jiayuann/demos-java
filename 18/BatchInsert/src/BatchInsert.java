import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BatchInsert {
  Connection conn = null;
    
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
    
public void insertStu(String sql){
    conn = getConn();                       //获取数据库连接
    try {
        Statement statement = conn.createStatement();   //创建Statement对象
        statement.executeUpdate(sql);       //执行插入SQL语句
	System.out.println("插入数据成功");
    } catch (Exception e) {           
        e.printStackTrace();
    }        
}

public static void main(String[] args) {
    BatchInsert insert = new BatchInsert();     //创建本类对象
    String sql = "insert student select '7','双双','女','21','生物科学','85' " +
    		"union all select '8','王爽','女','20','计算机应用','93' " +
    		"union all select '9','朱莉','女','19','英语','84'";     //定义插入的SQL语句
    insert.insertStu(sql);          //调用插入数据方法
}
}
