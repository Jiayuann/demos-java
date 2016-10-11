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
			System.out.println("��ȡʧ��:" + path + "�ļ�������" + e.getMessage());
		}
	}
	public void readDocFile(String origFileName) throws IOException {
		System.out.println("D:\\test.doc�е��������£�\n");		
		FileInputStream in = new FileInputStream(new File(origFileName));// �����ļ�������
		WordExtractor extractor = null;
		String text = null;		
		extractor = new WordExtractor(in);// ����WordExtractor		
		text = extractor.getText();// ��DOC�ļ�������ȡ
		System.out.println(text);
	}
}
