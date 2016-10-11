public class demoPri{
  public static void main(String argv[]){
    clicker trHigh,trLow;
    //创建两个线程对象
    trHigh=new clicker();
    trLow=new clicker();
    //分别设置优先级
    trHigh.setPriority(Thread.NORM_PRIORITY+2);
    trLow.setPriority(Thread.NORM_PRIORITY-2);
    //启动这两个线程
    trLow.start();
    trHigh.start();
    try{
      Thread.sleep(1000); //等待1秒钟
    }catch(InterruptedException e){  }
    //结束两个线程
    trHigh.normalStop();
    trLow.normalStop();
    //等待它们真正结束
    try{
      trHigh.join();
      trLow.join();
    }catch(InterruptedException e){  }
    //输出两个线程的循环次数
    System.out.println("trHigh的循环次数为："+trHigh.getClick());
    System.out.println("trLow的循环次数为："+trLow.getClick());
  }
}