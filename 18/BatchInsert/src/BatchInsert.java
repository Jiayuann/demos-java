import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BatchInsert {
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
    
public void insertStu(String sql){
    conn = getConn();                       //��ȡ���ݿ�����
    try {
        Statement statement = conn.createStatement();   //����Statement����
        statement.executeUpdate(sql);       //ִ�в���SQL���
	System.out.println("�������ݳɹ�");
    } catch (Exception e) {           
        e.printStackTrace();
    }        
}

public static void main(String[] args) {
    BatchInsert insert = new BatchInsert();     //�����������
    String sql = "insert student select '7','˫˫','Ů','21','�����ѧ','85' " +
    		"union all select '8','��ˬ','Ů','20','�����Ӧ��','93' " +
    		"union all select '9','����','Ů','19','Ӣ��','84'";     //��������SQL���
    insert.insertStu(sql);          //���ò������ݷ���
}
}
