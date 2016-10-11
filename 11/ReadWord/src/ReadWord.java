import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.POITextExtractor; 
import org.apache.poi.hwpf.extractor.WordExtractor;
public class ReadWord {
	public static void main(String[] args) {
		ReadWord s = new ReadWord();
		String path = "D:\\test.doc";
		try {
			s.readDocFile(path);
		} catch (IOException e) {
			System.out.println("读取失败:" + path + "文件不存在" + e.getMessage());
		}
	}
	public void readDocFile(String origFileName) throws IOException {
		System.out.println("D:\\test.doc中的内容如下：\n");		
		FileInputStream in = new FileInputStream(new File(origFileName));// 创建文件输入流
		WordExtractor extractor = null;
		String text = null;		
		extractor = new WordExtractor(in);// 创建WordExtractor		
		text = extractor.getText();// 对DOC文件进行提取
		System.out.println(text);
	}
}
