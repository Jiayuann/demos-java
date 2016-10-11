import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee();//创建Employee对象并为其赋值
        employee.setName("Lester");
        employee.setSalary(1800);
        employee.setDate(new Date());
        Manager manager = new Manager();//创建Manager对象并为其赋值
        manager.setName("李默");
        manager.setSalary(3000);
        manager.setDate(new Date());
        manager.setBonus(2000);
        //输出经理和员工的属性值
        System.out.println("员工的姓名：" + employee.getName());
        System.out.println("员工的工资：" + employee.getSalary());
        System.out.println("员工的入厂时间：" + employee.getDate());
        System.out.println("经理的姓名：" + manager.getName());
        System.out.println("经理的工资：" + manager.getSalary());
        System.out.println("经理的入厂时间：" + manager.getDate());
        System.out.println("经理的奖金：" + manager.getBonus());
    }
}
