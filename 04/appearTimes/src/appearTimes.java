import java.util.Scanner;
public class appearTimes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);		
        System.out.println("��������Ҫ���в��Ե��ַ���");
        String str = scan.nextLine();
        Scanner scan1 = new Scanner(System.in);		
        System.out.println("��������Ҫ���ҵ����ַ���");
        
		String str1 = scan1.nextLine();
		int count = 0;
		int start = 0;
		while (str.indexOf(str1, start) >= 0 && start < str.length()) {
			count++;
			start = str.indexOf(str1, start) + str1.length();
		}
		System.out.println(str1 + "��" + str + "���ֵĴ���Ϊ" + count);
	}

}