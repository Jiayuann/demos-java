import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class GeneratePDF {//����pdf����
	public static void main(String[] args) {
		GeneratePDF s = new GeneratePDF();
          s.createPDF();
	}
	public void createPDF(){
		try {
			//����documentʵ��
			Document document = new Document();//�����ĵ����ļ���Ĭ�ϴ�С A4        
			//����һ����д��(Writer)��document���������ͨ����д��(Writer)���Խ��ĵ�д�뵽�����С�
			PdfWriter.getInstance(document, new FileOutputStream("D:\\Helloworld.PDF"));
			//���ĵ���֮ǰ�趨�ĵ�����
			document.addCreator("Lester"); //�ĵ�������    
			document.open(); //���ĵ�
			//���ĵ����������  ---->�������ĵ���ӵ����ݶ����Զ���Ϊ��λ��
			document.add(new Paragraph("�ҵ�PDF�ĵ�"));  	
            //�ı���������һ������ΪHELVETICA����СΪ10�����»��ߵ��ַ�����
			Chunk chunk1 = new Chunk("����һ�����", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.UNDERLINE));
			document.add(chunk1);
			Table table = new Table(3,2); //��������
			table.setBorderWidth(1); 
			table.setBorderColor(new Color(0, 0, 255)); 
			Cell cell = new Cell("�������"); //���ñ������
			cell.setRowspan(2); 
			cell.setBorderColor(new Color(255, 0, 0)); 
			table.addCell(cell); 	
			table.addCell("1.1"); 
			table.addCell("2.1"); 
			table.addCell("1.2"); 
			table.addCell("2.2"); 
			table.addCell("HelloWorld"); 
			cell = new Cell("HelloWorld"); 
			cell.setRowspan(2); 
			cell.setColspan(2); 
			table.addCell(cell); 
			table.addCell("HelloWorld"); 
			document.add(table);		
			//��д����
			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font FontChinese = new Font(bfChinese, 12, com.lowagie.text.Font.NORMAL); 
			Paragraph pragraph=new Paragraph("���", FontChinese); 
			
	        document.add(pragraph);    
			document.close(); //�ر��ĵ�	
			System.out.println("PDF�������");				
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} 
		 catch (DocumentException e) {
			e.printStackTrace();
		} 
	}
}
