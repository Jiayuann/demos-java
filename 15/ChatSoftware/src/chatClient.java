import java.io.*;
import java.net.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class chatClient implements ActionListener,Runnable{
   JTextArea showArea;
   JTextField msgText;
   JFrame mainJframe;
   JButton sentBtn; 
   JScrollPane JSPane;
   JPanel pane;
   Container con;
   Thread thread=null;
   Socket connectToServer;
   DataInputStream inFromServer;
   DataOutputStream outToServer;

   public chatClient() {
     mainJframe=new JFrame("���졪���ͻ���");
     con=mainJframe.getContentPane();
     showArea=new JTextArea();
     showArea.setEditable(false);
     showArea.setLineWrap(true);
     JSPane=new JScrollPane(showArea);
     msgText=new JTextField();
     msgText.setColumns(30);
     msgText.addActionListener(this);
     sentBtn=new JButton("����");
     sentBtn.addActionListener(this);
     pane=new JPanel();
     pane.setLayout(new FlowLayout());
     pane.add(msgText);
     pane.add(sentBtn);
     con.add(JSPane,BorderLayout.CENTER);
     con.add(pane,BorderLayout.SOUTH);
     mainJframe.setSize(300,200);
     mainJframe.setVisible(true);
     mainJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //�����׽������ӵ�������
     try{
        connectToServer=new Socket("localhost",5500);
        inFromServer=new DataInputStream(connectToServer.getInputStream());
        outToServer=new DataOutputStream(connectToServer.getOutputStream());
        showArea.append("���ӳɹ�����˵��\n");
        //�����߳��ں�̨����Է�����Ϣ
        thread=new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
     }catch(IOException e){
        showArea.append("�Բ���û�����ӵ�������\n");
        msgText.setEditable(false);
        sentBtn.setEnabled(false);
     }
  }

  public static void main(String[] args) {
      new chatClient();
  }
  //��Ӧ��ť�¼���������Ϣ���Է�
  public void actionPerformed(ActionEvent e) {
     String s=msgText.getText();
     if (s.length()>0){
        try{
            outToServer.writeUTF(s);
            outToServer.flush();
            showArea.append("��˵��"+msgText.getText()+"\n");
            msgText.setText(null);
        }catch(IOException el){
            showArea.append("�����Ϣ����"+msgText.getText()+"��δ�ܷ��ͳ�ȥ\n");
        }
     } 
  }
  // ���̸߳��𽫷�������������Ϣ��ʾ�ڶԻ�����
  public void run() { 
     try{
         while(true){ 
            showArea.append("�Է�˵��"+inFromServer.readUTF()+"\n");
            Thread.sleep(1000);
         }
     }catch(IOException el){ 
     }catch (InterruptedException e) { }
   }
}