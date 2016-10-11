import java.io.*;
public class StatisticsChar {
	public static void main(String[] agrs) throws IOException
	{
		String zifuchuan=new String("");
		int hanzishu=0;int zimu=0;int kongge=0;int shuzi=0;int qita=0;
		System.out.print("请输入一行字符：");
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
		System.out.println("字符串所占字节个数为："+bytes.length);
		System.out.println("汉字个数为："+hanzishu/2);
		System.out.println("英文字母个数为："+zimu);
		System.out.println("空格个数为："+kongge);
		System.out.println("数字个数为："+shuzi);
		System.out.println("其他字符个数为："+qita);
	}
}
