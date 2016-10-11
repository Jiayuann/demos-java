import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
public class DatabaseStructure {
	
	//��ʾ���ݱ��Ԫ���ݣ���Ҫ���е���Ϣ con	�����ݿ������ tableName	 ���ݱ���
	public static void Show_Data(Connection con, String tableName){
		String sql = "SELECT * FROM " + tableName;
		Statement sm = null;
		try {
			sm = con.createStatement();
			ResultSet rs = sm.executeQuery(sql);// ���Ȼ�ñ����������
			ResultSetMetaData md = rs.getMetaData();// �õ��������Ԫ����
			System.out.println("���ݱ�" + tableName + "�ı�ṹ���£�");
			int columnCount = md.getColumnCount();// �������
			System.out.println();
			StringBuffer sbf = new StringBuffer("");
			sbf.append("���\t����\t\t").append("����\t\t");
			sbf.append("�Ƿ�Ϊ��\t\t");
			System.out.println(sbf);
			sbf.delete(0, sbf.length());
			// ����е�������Ϣ
			for (int i=1; i<=columnCount; i++){
				sbf.append(i).append("\t");
				sbf.append(md.getColumnName(i)).append("\t\t");
				sbf.append(md.getColumnTypeName(i)).append("\t\t");
				sbf.append(md.isNullable(i));
				System.out.println(sbf);
				sbf.delete(0, sbf.length());
			}
			System.out.println("�˱��� " + columnCount+" ��");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر�Statement
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
			// ������ݿ�����
			con = getConnection();
			System.out.println();
			// ��ʾ���ݱ��Ԫ��Ϣ
		Show_Data(con, tableName);
		} finally {
			// �ر����ݿ�����
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
