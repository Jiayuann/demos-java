public class MonkeyPeach{
	public static void main(String[] args) {
		int n=1;
		int m=0;
		int flag=1;
		int monkeyNum=5;
		while(true)
		{
			flag=1;
			m=monkeyNum*n+1;
			for(int i=monkeyNum;i>=1;i--)
			{
				if(m%(monkeyNum-1)==0)
				{
					m=m/(monkeyNum-1)*monkeyNum+1;
					flag++;   //计算多少次的桃子数量被4整除
				}
				else
					break;			
			}
			if(flag==monkeyNum)   //每次的桃子数量都能被4整除
				break;
			n++;
		}
		System.out.println("开始的桃子数至少是："+m);
		System.out.print("此时第五个猴子得到的桃子数是："+n);
	}
}
