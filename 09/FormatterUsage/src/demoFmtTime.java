import java.util.*; 
public class demoFmtTime{ 
  public static void main(String[] args) { 
     //�Ա�׼����豸ΪĿ�꣬��������
     Formatter fmt = new Formatter(System.out);
     //��ȡ��ǰʱ��
     Date dt = new Date();
     //�Ը��ָ�ʽ������ں�ʱ��
     fmt.format("���ڵ����ں�ʱ�䣨��Ĭ�ϵ�������ʽ����%tc\n",dt);
     fmt.format("��������ڣ����й�ϰ�ߣ���%1$tY-%1$tm-%1$td\n",dt);
     fmt.format("�����ǣ�%tA\n",dt);
     fmt.format("���ڵ�ʱ�䣨24Сʱ�ƣ�:%tT\n",dt);
     fmt.format("���ڵ�ʱ�䣨12Сʱ�ƣ�:%tr\n",dt);
     fmt.format("�����ǣ�%tH��%1$tM��%1$tS��",dt);     
  }
}