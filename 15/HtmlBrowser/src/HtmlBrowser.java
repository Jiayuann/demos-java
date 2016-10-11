import java.io.IOException;
import java.net.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
public class HtmlBrowser extends JFrame {
        private JPanel contentPane;  
        private JPanel mainPanel = new JPanel();  
        private JTextField urlTextField = new JTextField();    
        private JEditorPane htmlPane = new JEditorPane();
        public HtmlBrowser() {
                  try {
                           jbInit();
                  } catch (Exception e) {
                           e.printStackTrace();
                  }
                  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        private void jbInit() throws Exception {
                  contentPane = (JPanel) getContentPane();
                  contentPane.setLayout(new BorderLayout());
                  mainPanel.setLayout(new BorderLayout());
                  JLabel promptLabel = new JLabel("请输入网址：");
                  urlTextField.setText("http://");
                  urlTextField.addActionListener(new java.awt.event.ActionListener() {
                           public void actionPerformed(ActionEvent e) {
                                    setPaneContent(urlTextField.getText());
                           }
                  });
                  htmlPane.setEditable(false);
                  htmlPane.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
                                              public void hyperlinkUpdate(HyperlinkEvent e) {
                                                       hyperLinkUpdate(e);
                                             }
                                    });
                  JScrollPane scrollPane = new JScrollPane();
                  scrollPane.getViewport().add(htmlPane);
                  mainPanel.add(urlTextField, BorderLayout.NORTH);
                  mainPanel.add(scrollPane, BorderLayout.CENTER);
                  contentPane.add(promptLabel, BorderLayout.NORTH);
                  contentPane.add(mainPanel, BorderLayout.CENTER);
                  this.setSize(new Dimension(600, 500));
                  this.setTitle("我的自制浏览器");
                  this.setVisible(true);
        }
        public void setPaneContent(String url) {
                  try {
                           htmlPane.setPage(url);
                  } catch (IOException ex) {
                           JOptionPane.showMessageDialog(this, "你输入的地址"
                                              + urlTextField.getText(), "有误！", 0);
                  }
        }
        public void hyperLinkUpdate(HyperlinkEvent e) {
                  if (e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
                           URL url = e.getURL();
                           setPaneContent(url.toString());
                  }
        }
        public static void main(String[] args) {
                  new HtmlBrowser();
        }
}

