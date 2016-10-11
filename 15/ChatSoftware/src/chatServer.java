//这是服务器端程序
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
     //设置界面
     mainJframe=new JFrame("聊天——服务器端");
     con=mainJframe.getContentPane();
     showArea=new JTextArea();
     showArea.setEditable(false);
     showArea.setLineWrap(true);
     JSPane=new JScrollPane(showArea);
     msgText=new JTextField();
     msgText.setColumns(30);
     msgText.addActionListener(this);
     sentBtn=new JButton("发送");
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
        //创建服务套接字
        serverSocket=new ServerSocket(5500);
        showArea.append("正在等待对话请求\n");
        //侦听客户端的连接
        connectToClient=serverSocket.accept();
        inFromClient=new DataInputStream(connectToClient.getInputStream());
        outToClient=new DataOutputStream(connectToClient.getOutputStream());
        //启动线程在后台来接收对方的消息
        thread=new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
     }catch(IOException e){
        showArea.append("对不起，不能创建服务器\n");
        msgText.setEditable(false);
        sentBtn.setEnabled(false);
     }
  }

  public static void main(String[] args) {
       new chatServer();
  }
  //响应按钮事件，发送消息给对方
  public void actionPerformed(ActionEvent e) {
     String s=msgText.getText();
     if (s.length()>0){
       try{
           outToClient.writeUTF(s);
           outToClient.flush();
           showArea.append("我说："+msgText.getText()+"\n");
           msgText.setText(null);
       }catch(IOException el){
           showArea.append("你的消息：“"+msgText.getText()+"”未能发送出去\n");
       }
     } 

  }
  // 本线程负责将客户机传来的信息显示在对话区域
  public void run() { 
      try{
          while(true){ 
             showArea.append("对方说："+inFromClient.readUTF()+"\n");
             Thread.sleep(1000);
         }
      }catch(IOException el){ 
      }catch (InterruptedException e) { }
   }
}