import java.util.Scanner;
public class PersonalIncomeTax {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);// ����ɨ����
        System.out.println("���������Ĺ��ʶȥ������һ��󣩣�");
        int i = scan.nextInt();// �����û�����ĵȼ�
        if(i<=3500)
			System.out.println("������Ҫ��˰");
		else if(0<i-3500&&i-3500<=1500)
			System.out.println("������˰���Ϊ:"+((i-3500)*0.03));
		else if(1500<i-3500&&i-3500<=4500)
			System.out.println("������˰���Ϊ:"+((i-3500)*0.1-105));
		else if(4500<i-3500&&i-3500<=9000)
			System.out.println("������˰���Ϊ:"+((i-3500)*0.2-555));
		else if(9000<i-3500&&i-3500<=35000)
			System.out.println("������˰���Ϊ:"+((i-3500)*0.25-1005));
		else if(35000<i-3500&&i-3500<=55000)
			System.out.println("������˰���Ϊ:"+((i-3500)*0.3-2755));
		else if(55000<i-3500&&i-3500<=80000)
			System.out.println("������˰���Ϊ:"+((i-3500)*0.35-5505));
		else
			System.out.println("������˰���Ϊ:"+((i-3500)*0.45-13505));
	}

}