public class Student {
    private String name; // 定义姓名
    private String sex; // 定义性别
    private int age; // 定义年龄

    public Student(String name, String sex, int age) {// 利用构造方法初始化域
        this.name = name;
        this.sex= sex;
        this.age = age;
    }

    public String getName() { // 获得姓名
        return name;
    }

    public String getSex() { // 获得性别
        return sex;
    }

    public int getAge() { // 获得年龄
        return age;
    }
}