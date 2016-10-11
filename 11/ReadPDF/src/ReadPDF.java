import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.pdfparser.PDFParser;

public class ReadPDF {
	public static void main(String[] args) {
		ReadPDF pdf = new ReadPDF();
		String pdfName = "D:\\Java����֪ʶ�ܽ�.pdf";
		pdf.readFileOfPDF(pdfName);

	}
	// ��ȡָ����PDF�ļ������ݣ����У�pdfName��ʾҪ��ȡ��PDF�ļ���·��
	public void readFileOfPDF(String pdfName) {
		File file = new File(pdfName);// ����һ���ļ�����
		FileInputStream infile = null;
		try {
			infile = new FileInputStream(pdfName);// ����һ���ļ�������
			// �½�һ��PDF����������
			PDFParser parser = new PDFParser(infile);
			// ��PDF�ļ����н���
			parser.parse();
			// ��ȡ������õ���PDF�ĵ�����
			PDDocument pdfdocument = parser.getPDDocument();
			// �½�һ��PDF�ı�������
			PDFTextStripper stripper = new PDFTextStripper();
			// ��PDF�ĵ������а����ı�
			String context = stripper.getText(pdfdocument);
			System.out.println("PDF�ļ�" + file.getAbsolutePath() + "���ı��������£�");
			System.out.println(context);

		} catch (Exception e) {
			System.out.println("��ȡPDF�ļ�" + file.getAbsolutePath() + "ʧ�ܣ�"
					+ e.getMessage());
		} finally {
			if (infile != null) {
				try {
					infile.close();
				} catch (IOException e1) {
				}
			}
		}
	}
}
