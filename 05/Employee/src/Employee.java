import java.util.Date;		
public class Employee {
    
    private String name;		//Ա��������
    private double salary;		//Ա���Ĺ���
    private Date date;		//Ա�����볧ʱ��
    
    public String getName() {		//��ȡԱ��������
        return name;
    }
    
    public void setName(String name) {	//����Ա��������
        this.name = name;
    }
    
    public double getSalary() {		//��ȡԱ���Ĺ���
        return salary;
    }
    
    public void setSalary(double salary) {	//����Ա���Ĺ���
        this.salary = salary;
    }
    
    public Date getDate() {		//��ȡԱ�����볧ʱ��
        return date;
    }
    
    public void setDate(Date date) {		//����Ա�����볧ʱ��
        this.date = date;
    }
    
}
