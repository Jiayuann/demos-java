public class SameNameMethod {
    public void info() {// 定义没有参数的info()方法
        System.out.println("普通方法：小明今年1岁了！");
    }

    public void info(int age) {// 定义包含整型参数的info()方法
        System.out.println("重载方法：小明今年" + age + "岁了！");
    }

    public static void main(String[] args) {
    	SameNameMethod ot = new SameNameMethod();// 创建OverloadingTest类对象
        ot.info();// 测试无参数info()方法
        for (int i = 1; i < 5; i++) {// 测试有参数info()方法
            ot.info(i);
        }
    }
}
