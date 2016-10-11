import java.io.*;
public class Bonus {
	public static void main(String[] args) throws IOException {
		float lirun=0;double jiangjin=0;
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("输入当月利润（万）：");
		lirun=(new Float(stdin.readLine()));
		if(lirun<=10)
			jiangjin=lirun*0.1;
		else if(lirun<=20)
			jiangjin=(lirun-10)*0.075+10*0.1;
		else if(lirun<=40)
			jiangjin=(lirun-20)*0.05+10*0.075+10*0.1;
		else if(lirun<=60)
			jiangjin=(lirun-40)*0.03+20*0.05+10*0.075+10*0.1;
		else if(lirun<=100)
			jiangjin=(lirun-60)*0.015+20*0.3+20*0.05+10*0.075+10*0.1;
		else
			jiangjin=(lirun-100)*0.01+40*0.015+20*0.3+20*0.05+10*0.075+10*0.1;
		System.out.println("当月奖金为（万）：\n"+jiangjin);	
	}
}
