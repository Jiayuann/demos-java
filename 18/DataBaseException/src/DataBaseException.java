import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class DataBaseException {
	public static void main(String[] args) {
		String ul = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");// ������������
		} catch (Exception e) {
			System.out.println("������������");
		}
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/", "root", "123456");// ��������
			SQLWarning warn = con.getWarnings();// ����SQLWarning����
			int num = 1;
			while (warn != null) {
				System.out.println("��" + num + "����");
				System.out.println("SQL state" + warn.getSQLState());
				System.out.println("������Ϣ" + warn.getMessage());
				System.out.println("�������" + warn.getErrorCode());
				warn = warn.getNextWarning();
				num++;
			}
		} catch (SQLException e) {
			while (e != null) {
				System.out.println("SQL state" + e.getSQLState());
				System.out.println("������Ϣ" + e.getMessage());
				System.out.println("�������" + e.getErrorCode());
				e = e.getNextException();
			}
		}
	}
}
