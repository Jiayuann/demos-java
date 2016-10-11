import java.net.MalformedURLException;
import java.net.URL;
public class URLComponents {
	public static void main(String[] args){
		for(int i=0;i<args.length;i++){
			try {
				URL url = new URL(args[i]);
				System.out.println("URL的地址是："+url);
				System.out.println("URL的协议是："+url.getProtocol());
				System.out.println("用户信息是："+url.getUserInfo());
				String s = url.getHost();
				if(s!=null){
					int it = s.indexOf('@');
					if(it!=-1){
						s= s.substring(it+1);
						System.out.println(s);
					}
				}else{
					System.out.println(args[i]+"域名为空！");
				}
				System.out.println("端口是："+url.getPort());
				System.out.println("路径是："+url.getPath());
				System.out.println("文件类型是："+url.getFile());
				System.out.println("主机名是："+url.getHost());
			} catch (MalformedURLException e) {
				System.out.println("不是一个URL地址！");
			}
		}
	}
}
