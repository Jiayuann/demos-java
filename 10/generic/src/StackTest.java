public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        System.out.println("向栈中增加字符串：");
        System.out.println("三国演义");
        System.out.println("西游记");
        System.out.println("水浒传");
        System.out.println("红楼梦");
        stack.push("三国演义");  //向栈中增加字符串
        stack.push("西游记");   //向栈中增加字符串
        stack.push("水浒传"); //向栈中增加字符串
        stack.push("红楼梦"); //向栈中增加字符串
        System.out.println("从栈中取出字符串：");
        while (!stack.empty()) {
            System.out.println((String) stack.pop());//删除栈中全部元素并进行输出
        }
    }
}

