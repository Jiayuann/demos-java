import java.io.*;
import java.util.*;
public class MatrixTrace
{
	public static void main(String args[]) throws IOException
	{
		int n=0;
		System.out.print("请输入矩阵的维数及数组内容：");
		Scanner reader = new Scanner(System.in);
		n=reader.nextInt();
		String[] s=new String[n];
		Scanner[] scan=new Scanner[n];
		long[][] a=new long[n][n];
		long sum=0;
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<n;i++)
		{
			s[i]=stdin.readLine();  //连续输入多行
		}
		System.out.println("您输入的矩阵为：");
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
		System.out.println("矩阵的迹为："+sum);
	}
}
