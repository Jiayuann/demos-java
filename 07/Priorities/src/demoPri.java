public class demoPri{
  public static void main(String argv[]){
    clicker trHigh,trLow;
    //���������̶߳���
    trHigh=new clicker();
    trLow=new clicker();
    //�ֱ��������ȼ�
    trHigh.setPriority(Thread.NORM_PRIORITY+2);
    trLow.setPriority(Thread.NORM_PRIORITY-2);
    //�����������߳�
    trLow.start();
    trHigh.start();
    try{
      Thread.sleep(1000); //�ȴ�1����
    }catch(InterruptedException e){  }
    //���������߳�
    trHigh.normalStop();
    trLow.normalStop();
    //�ȴ�������������
    try{
      trHigh.join();
      trLow.join();
    }catch(InterruptedException e){  }
    //��������̵߳�ѭ������
    System.out.println("trHigh��ѭ������Ϊ��"+trHigh.getClick());
    System.out.println("trLow��ѭ������Ϊ��"+trLow.getClick());
  }
}