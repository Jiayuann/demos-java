import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class GetFieldInfo {
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
    //定义获取字段的描述信息方法
public List getDescribe(String tableName) {
    conn = getConn();           //获取数据库连接
    List list = new ArrayList();    //定义List集合对象
    try {
        Statement stmt = conn.createStatement();    //获取Statement对象
        ResultSet rest = stmt
                .executeQuery("select a.name,b.votecount FROM student a,ballot b " +
                		" where  a.studentid=b.userid ");   //执行查询语句
        while(rest.next()){ //循环遍历查询结果集
        	FieldInfo describe = new FieldInfo(); //定义定义的JavaBean对象
            describe.setName(rest.getString(1));    //设置对象属性
            describe.setValue(rest.getString(2));   
            list.add(describe);             //向集合中添加对象
        }
    } catch (Exception e) {
        e.printStackTrace();
    } 
    return list;
}    
    //主方法
    public static void main(String[] args) {
        GetFieldInfo getDescribe = new GetFieldInfo();
        List list = getDescribe.getDescribe("得票情况");
        System.out.println("数据表的字段与描述信息对应如下：");
        for(int i = 0;i<list.size();i++){
        	FieldInfo describe = (FieldInfo)list.get(i);
            System.out.println("姓名为："+describe.getName()+"   得票数为："+describe.getValue());
        }
    }
}
