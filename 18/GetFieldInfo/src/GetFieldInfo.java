import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class GetFieldInfo {
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
    //�����ȡ�ֶε�������Ϣ����
public List getDescribe(String tableName) {
    conn = getConn();           //��ȡ���ݿ�����
    List list = new ArrayList();    //����List���϶���
    try {
        Statement stmt = conn.createStatement();    //��ȡStatement����
        ResultSet rest = stmt
                .executeQuery("select a.name,b.votecount FROM student a,ballot b " +
                		" where  a.studentid=b.userid ");   //ִ�в�ѯ���
        while(rest.next()){ //ѭ��������ѯ�����
        	FieldInfo describe = new FieldInfo(); //���嶨���JavaBean����
            describe.setName(rest.getString(1));    //���ö�������
            describe.setValue(rest.getString(2));   
            list.add(describe);             //�򼯺�����Ӷ���
        }
    } catch (Exception e) {
        e.printStackTrace();
    } 
    return list;
}    
    //������
    public static void main(String[] args) {
        GetFieldInfo getDescribe = new GetFieldInfo();
        List list = getDescribe.getDescribe("��Ʊ���");
        System.out.println("���ݱ���ֶ���������Ϣ��Ӧ���£�");
        for(int i = 0;i<list.size();i++){
        	FieldInfo describe = (FieldInfo)list.get(i);
            System.out.println("����Ϊ��"+describe.getName()+"   ��Ʊ��Ϊ��"+describe.getValue());
        }
    }
}
