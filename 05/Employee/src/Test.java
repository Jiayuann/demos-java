import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee();//����Employee����Ϊ�丳ֵ
        employee.setName("Lester");
        employee.setSalary(1800);
        employee.setDate(new Date());
        Manager manager = new Manager();//����Manager����Ϊ�丳ֵ
        manager.setName("��Ĭ");
        manager.setSalary(3000);
        manager.setDate(new Date());
        manager.setBonus(2000);
        //��������Ա��������ֵ
        System.out.println("Ա����������" + employee.getName());
        System.out.println("Ա���Ĺ��ʣ�" + employee.getSalary());
        System.out.println("Ա�����볧ʱ�䣺" + employee.getDate());
        System.out.println("�����������" + manager.getName());
        System.out.println("����Ĺ��ʣ�" + manager.getSalary());
        System.out.println("������볧ʱ�䣺" + manager.getDate());
        System.out.println("����Ľ���" + manager.getBonus());
    }
}
