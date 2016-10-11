public class Test {
    public static void main(String[] args) {
        Student student = new Student("李默", "男", 23);// 创建对象
        System.out.println("姓名：" + student.getName()); // 输出姓名
        System.out.println("性别：" + student.getSex()); // 输出性别
        System.out.println("年龄：" + student.getAge() + "岁"); // 输出年龄
    }
}
