import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class GeneratePDF {//创建pdf案例
	public static void main(String[] args) {
		GeneratePDF s = new GeneratePDF();
          s.createPDF();
	}
	public void createPDF(){
		try {
			//创建document实例
			Document document = new Document();//创建文档，文件的默认大小 A4        
			//建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
			PdfWriter.getInstance(document, new FileOutputStream("D:\\Helloworld.PDF"));
			//在文档打开之前设定文档属性
			document.addCreator("Lester"); //文档创建者    
			document.open(); //打开文档
			//向文档中添加内容  ---->所有向文档添加的内容都是以对象为单位的
			document.add(new Paragraph("我的PDF文档"));  	
            //文本处理：产生一个字体为HELVETICA、大小为10、带下划线的字符串：
			Chunk chunk1 = new Chunk("这是一个表格：", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.UNDERLINE));
			document.add(chunk1);
			Table table = new Table(3,2); //两行三列
			table.setBorderWidth(1); 
			table.setBorderColor(new Color(0, 0, 255)); 
			Cell cell = new Cell("表格数据"); //设置表格数据
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
			//书写中文
			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font FontChinese = new Font(bfChinese, 12, com.lowagie.text.Font.NORMAL); 
			Paragraph pragraph=new Paragraph("你好", FontChinese); 
			
	        document.add(pragraph);    
			document.close(); //关闭文档	
			System.out.println("PDF创建完毕");				
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
