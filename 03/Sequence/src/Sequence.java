import java.io.*;
import java.util.*;
public class Sequence {
	public static void main(String[] args) throws IOException {
		String m=new String("");
		int[] a={0,0,0};
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("输入三个数（以一个空格隔开）：");
		m=stdin.readLine();
		Scanner scan=new Scanner(m);
		for(int i=0;i<3;i++)
		{
			a[i]=scan.nextInt();
		}
		Arrays.sort(a);
		System.out.print("三个数的升序排列为：");
		for(int i=0;i<3;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}
