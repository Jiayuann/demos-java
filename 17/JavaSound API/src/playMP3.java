import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class playMP3 implements ActionListener{
  protected JTextField fileField;
  protected JButton openBtn,startBtn,pauseBtn,resumBtn,stopBtn;
  protected Container con;
  protected JFrame mainJframe;
  protected SoundBase as;
  protected String filename;

  public playMP3(){
     mainJframe=new JFrame("播放声音");
     con=mainJframe.getContentPane();
     con.setLayout(new FlowLayout());
     fileField=new JTextField();
     fileField.setColumns(30);
     openBtn=new JButton("选择文件");
     startBtn=new JButton("开始播放");
     pauseBtn=new JButton("暂停播放");
     resumBtn=new JButton("继续播放");
     stopBtn=new JButton("停止播放");
     openBtn.addActionListener(this);
     startBtn.addActionListener(this);
     pauseBtn.addActionListener(this);
     resumBtn.addActionListener(this);
     stopBtn.addActionListener(this);
     con.add(fileField);
     con.add(openBtn);
     con.add(startBtn);
     con.add(pauseBtn);
     con.add(resumBtn);
     con.add(stopBtn);
     mainJframe.setSize(400,200);
     mainJframe.setVisible(true);
     mainJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     as = new SoundBase();
   }

   public void actionPerformed(ActionEvent e) {
     Object obj;
     obj=e.getSource();
     try{
          if(obj==openBtn){
               openfile();
          }else if(obj==startBtn){
               as.playFile(filename);
          }else if(obj==pauseBtn){
               as.pause();
          }else if(obj==resumBtn){
               as.resume();
          }else if(obj==stopBtn){
               as.stop();
          }
     }catch(Exception el){
          JOptionPane.showMessageDialog(mainJframe,"无法播放文件！");
     }
  }

  private void openfile(){
     try{ 
          JFileChooser chooser = new JFileChooser();
          if(chooser.showOpenDialog(mainJframe)==JFileChooser.APPROVE_OPTION){
               File tempfile= chooser.getSelectedFile();
               filename = tempfile.toString();
               fileField.setText(filename) ;
          }
     }catch(Exception el){
          JOptionPane.showMessageDialog(mainJframe,"无法加载文件！"); 
     }
  }

  public static void main(String args[]){
     new playMP3();
  }
} 