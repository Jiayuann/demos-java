import java.io.*;
import java.util.*;
public class MatrixTrace
{
	public static void main(String args[]) throws IOException
	{
		int n=0;
		System.out.print("����������ά�����������ݣ�");
		Scanner reader = new Scanner(System.in);
		n=reader.nextInt();
		String[] s=new String[n];
		Scanner[] scan=new Scanner[n];
		long[][] a=new long[n][n];
		long sum=0;
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<n;i++)
		{
			s[i]=stdin.readLine();  //�����������
		}
		System.out.println("������ľ���Ϊ��");
		for(int i=0;i<n;i++){
			scan[i]=new Scanner(s[i]);
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j]=scan[i].nextLong();
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(a[i][j]+" ");
				if(i==j)
				{
					sum=sum+a[i][j];
				}
			}
			System.out.println("");
		}	
		System.out.println("����ļ�Ϊ��"+sum);
	}
}
