import java.io.*;
public class StatisticsChar {
	public static void main(String[] agrs) throws IOException
	{
		String zifuchuan=new String("");
		int hanzishu=0;int zimu=0;int kongge=0;int shuzi=0;int qita=0;
		System.out.print("������һ���ַ���");
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		zifuchuan=stdin.readLine();
		byte[] bytes=zifuchuan.getBytes();
		for(int i=0;i<bytes.length;i++)
		{
			if((bytes[i]>=65&&bytes[i]<=90)||(bytes[i]>=97&&bytes[i]<=122))
					zimu++;
			else if(bytes[i]==32)
					kongge++;
			else if(bytes[i]>=48&&bytes[i]<=57)
					shuzi++;
			else if(bytes[i]<0)
					hanzishu++;
			else
					qita++;
		}
		System.out.println("�ַ�����ռ�ֽڸ���Ϊ��"+bytes.length);
		System.out.println("���ָ���Ϊ��"+hanzishu/2);
		System.out.println("Ӣ����ĸ����Ϊ��"+zimu);
		System.out.println("�ո����Ϊ��"+kongge);
		System.out.println("���ָ���Ϊ��"+shuzi);
		System.out.println("�����ַ�����Ϊ��"+qita);
	}
}
