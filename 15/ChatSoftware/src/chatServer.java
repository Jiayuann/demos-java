//���Ƿ������˳���
import java.io.*;
import java.net.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class chatServer implements ActionListener,Runnable{
  JTextArea showArea;
  JTextField msgText;
  JFrame mainJframe;
  JButton sentBtn; 
  JScrollPane JSPane;
  JPanel pane;
  Container con;
  Thread thread=null;
  ServerSocket serverSocket;
  Socket connectToClient;
  DataInputStream inFromClient;
  DataOutputStream outToClient;

  public chatServer() {
     //���ý���
     mainJframe=new JFrame("���졪����������");
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
     try{
        //���������׽���
        serverSocket=new ServerSocket(5500);
        showArea.append("���ڵȴ��Ի�����\n");
        //�����ͻ��˵�����
        connectToClient=serverSocket.accept();
        inFromClient=new DataInputStream(connectToClient.getInputStream());
        outToClient=new DataOutputStream(connectToClient.getOutputStream());
        //�����߳��ں�̨�����նԷ�����Ϣ
        thread=new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
     }catch(IOException e){
        showArea.append("�Բ��𣬲��ܴ���������\n");
        msgText.setEditable(false);
        sentBtn.setEnabled(false);
     }
  }

  public static void main(String[] args) {
       new chatServer();
  }
  //��Ӧ��ť�¼���������Ϣ���Է�
  public void actionPerformed(ActionEvent e) {
     String s=msgText.getText();
     if (s.length()>0){
       try{
           outToClient.writeUTF(s);
           outToClient.flush();
           showArea.append("��˵��"+msgText.getText()+"\n");
           msgText.setText(null);
       }catch(IOException el){
           showArea.append("�����Ϣ����"+msgText.getText()+"��δ�ܷ��ͳ�ȥ\n");
       }
     } 

  }
  // ���̸߳��𽫿ͻ�����������Ϣ��ʾ�ڶԻ�����
  public void run() { 
      try{
          while(true){ 
             showArea.append("�Է�˵��"+inFromClient.readUTF()+"\n");
             Thread.sleep(1000);
         }
      }catch(IOException el){ 
      }catch (InterruptedException e) { }
   }
}