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
					flag++;   //������ٴε�����������4����
				}
				else
					break;			
			}
			if(flag==monkeyNum)   //ÿ�ε������������ܱ�4����
				break;
			n++;
		}
		System.out.println("��ʼ�������������ǣ�"+m);
		System.out.print("��ʱ��������ӵõ����������ǣ�"+n);
	}
}
