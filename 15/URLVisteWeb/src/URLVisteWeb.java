import java.applet.Applet;
import java.awt.GridLayout;
import java.awt.Label;
import java.net.MalformedURLException;
import java.net.URL;

public class URLVisteWeb extends Applet{
	public void init(){
		URL url = this.getDocumentBase();
		try {
			URL url1 = new URL(url,"a.html"); 	//实例化一个URL对象
			this.setLayout(new GridLayout(2,1));//设置布局
			//添加标签
			this.add(new Label(url.toString()));
			this.add(new Label(url1.toString()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
	}
}
