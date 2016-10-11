import java.io.*;
public class PhoneEncryption {
	public static void main(String[] args) throws Exception {
		System.out.println("请输入需要加密的电话号码：");
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s=stdin.readLine();
		char[] a=s.toCharArray();
		int[] b=new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			b[i]=((a[i]-'0')+5)%10;			
		}
		System.out.println("加密后的数字为：");
		for(int i=b.length-1;i>=0;i--)
		{
			System.out.print(b[i]);
		}
	}
}

