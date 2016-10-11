import java.net.MalformedURLException;
import java.net.URL;
public class URLComponents {
	public static void main(String[] args){
		for(int i=0;i<args.length;i++){
			try {
				URL url = new URL(args[i]);
				System.out.println("URL�ĵ�ַ�ǣ�"+url);
				System.out.println("URL��Э���ǣ�"+url.getProtocol());
				System.out.println("�û���Ϣ�ǣ�"+url.getUserInfo());
				String s = url.getHost();
				if(s!=null){
					int it = s.indexOf('@');
					if(it!=-1){
						s= s.substring(it+1);
						System.out.println(s);
					}
				}else{
					System.out.println(args[i]+"����Ϊ�գ�");
				}
				System.out.println("�˿��ǣ�"+url.getPort());
				System.out.println("·���ǣ�"+url.getPath());
				System.out.println("�ļ������ǣ�"+url.getFile());
				System.out.println("�������ǣ�"+url.getHost());
			} catch (MalformedURLException e) {
				System.out.println("����һ��URL��ַ��");
			}
		}
	}
}
