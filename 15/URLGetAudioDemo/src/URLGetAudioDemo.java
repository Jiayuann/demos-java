import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
public class URLGetAudioDemo extends Applet implements ActionListener {
        AudioClip ac;
        Button button_play, button_loop, button_stop;
        public void init() {
                  this.setSize(260, 130);                      //设置Applet的窗口大小,260与130分别宽度和高度
                  try {
                           URL url = new URL("http://r01.mmstoon.com/ring/953404.mid");                         //音乐URL 地址
                           ac = getAudioClip(url);           //创建音频对象，远程获取音频数据
                  } catch (MalformedURLException e) {
                           e.printStackTrace();
                  }
                  Label label = new Label("远程音乐载入成功!点击按钮开始播放!");
                  add(label);
                  button_play = new Button("开始播放");     //添加按钮控制
                  button_loop = new Button("循环播放");
                  button_stop = new Button("停止播放");
                  button_play.addActionListener(this);          //按钮添加事件监听器
                  button_stop.addActionListener(this);
                  button_loop.addActionListener(this);
                  add(button_play);
                  add(button_loop);
                  add(button_stop);
        }
        public void actionPerformed(ActionEvent e) {            //实现监听器方法
                  if (e.getSource() == button_play) {
                           ac.play();                            //开始播放
                  } else if (e.getSource() == button_loop) {

                           ac.loop();                             //循环播放
                  }
                  if (e.getSource() == button_stop) {
                           ac.stop();                             //停止播放
                  }
        }
}

