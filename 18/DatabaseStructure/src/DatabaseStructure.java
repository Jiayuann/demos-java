import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
public class DatabaseStructure {
	
	//显示数据表的元数据，主要是列的信息 con	与数据库的连接 tableName	 数据表名
	public static void Show_Data(Connection con, String tableName){
		String sql = "SELECT * FROM " + tableName;
		Statement sm = null;
		try {
			sm = con.createStatement();
			ResultSet rs = sm.executeQuery(sql);// 首先获得表的所有数据
			ResultSetMetaData md = rs.getMetaData();// 得到结果集的元数据
			System.out.println("数据表" + tableName + "的表结构如下：");
			int columnCount = md.getColumnCount();// 表的列数
			System.out.println();
			StringBuffer sbf = new StringBuffer("");
			sbf.append("序号\t列名\t\t").append("类型\t\t");
			sbf.append("是否为空\t\t");
			System.out.println(sbf);
			sbf.delete(0, sbf.length());
			// 输出列的属性信息
			for (int i=1; i<=columnCount; i++){
				sbf.append(i).append("\t");
				sbf.append(md.getColumnName(i)).append("\t\t");
				sbf.append(md.getColumnTypeName(i)).append("\t\t");
				sbf.append(md.isNullable(i));
				System.out.println(sbf);
				sbf.delete(0, sbf.length());
			}
			System.out.println("此表共有 " + columnCount+" 列");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭Statement
			if (sm != null){
				try {
					sm.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		String tableName = "staff";
		Connection con = null;
		try {
			// 获得数据库连接
			con = getConnection();
			System.out.println();
			// 显示数据表的元信息
		Show_Data(con, tableName);
		} finally {
			// 关闭数据库连接
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysqldemo", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
