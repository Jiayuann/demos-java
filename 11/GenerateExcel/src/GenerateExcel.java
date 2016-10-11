import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;  
public class GenerateExcel {//����Excel�ļ�
	// �½�һ��Excel�ļ����������5��5�е����ݣ��������һ���ϲ�2��5�еĴ�Ԫ���Լ�һ���ϲ�2��1�е�5���ϲ���Ԫ��
	public void createExcel(String fileName) {
		File file = new File(fileName);// ����excel�ļ�����
		FileOutputStream fOut = null;
		try {		
			HSSFWorkbook workbook = new HSSFWorkbook();// ����һ���µ�HSSFWorkbook����
			HSSFSheet sheet = workbook.createSheet("myFirstExcel");// ����һ��Excel�Ĺ���������ָ�������������
			HSSFFont font = workbook.createFont();// �������壬��ɫ������
			font.setColor(HSSFFont.COLOR_RED);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			HSSFFont font1 = workbook.createFont();
			font1.setColor(HSSFFont.COLOR_NORMAL);// �������壬��ɫ���Ǵ���
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			HSSFCellStyle cellStyle = workbook.createCellStyle();// ������Ԫ��ĸ�ʽ������С�������
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ˮƽ�����Ͼ��ж���
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// ��ֱ�����Ͼ��ж���
			cellStyle.setFont(font); // ��������
			HSSFCellStyle cellStyle1 = workbook.createCellStyle();
			cellStyle1.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle1.setFont(font1);
			// ���潫����һ��4��3�еı���һ��Ϊ��ͷ
			int rowNum = 0;// �б�
			int colNum = 0;// �б�
			// ������ͷ��Ϣ
			HSSFRow row = sheet.createRow((short) rowNum); // ������0��λ�ô�����
			HSSFCell cell = null; // ��Ԫ��
			for (colNum = 0; colNum < 5; colNum++) {
				cell = row.createCell((short) colNum);// �ڵ�ǰ�е�colNum���ϴ�����Ԫ��
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);// ���嵥Ԫ��Ϊ�ַ����ͣ�Ҳ����ָ��Ϊ�������͡���������
				// ������뷽ʽ��Ϊ��֧�����ģ�����ʹ����ENCODING_UTF_16
				cell.setCellStyle(cellStyle); // Ϊ��Ԫ�����ø�ʽ
				cell.setCellValue("��ͷ-��" + (colNum + 1) + "��"); // �����������Ԫ��
			}
			rowNum++;
			for (; rowNum < 5; rowNum++) {
				row = sheet.createRow((short) rowNum);// �½���rowNum��
				for (colNum = 0; colNum < 5; colNum++) {	
					cell = row.createCell((short) colNum);// �ڵ�ǰ�е�colNumλ�ô�����Ԫ��
					cell.setCellStyle(cellStyle1);
					cell.setCellValue("����-��" + rowNum + "�е�" + (colNum + 1)
							+ "��");
				}
			}					
			rowNum = 5;// �ϲ���Ԫ��
			for (; rowNum < 9; rowNum++) {
				row = sheet.createRow((short) rowNum);
				for (colNum = 0; colNum < 5; colNum++) {
					// �ڵ�ǰ�е�colNumλ�ô�����Ԫ��
					cell = row.createCell((short) colNum);
				}
			}			
			rowNum = 5;// ������һ����Ԫ�񣬸߶�Ϊ2�����Ϊ2
			colNum = 0;
			Region region = new Region(rowNum, (short) colNum, (rowNum + 1),
					(short) (colNum + 4));
			sheet.addMergedRegion(region);
			// ��õ�һ����Ԫ��
			cell = sheet.getRow(rowNum).getCell((short) colNum);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("�ϲ��е�Ԫ��");			
			rowNum = 7;// �����ڶ�����Ԫ�񣬸߶�Ϊ2�����Ϊ3
			for (colNum = 0; colNum < 5; colNum++) {
				region = new Region(rowNum, (short) colNum, (rowNum + 1),
						(short) (colNum));
				sheet.addMergedRegion(region);				
				cell = sheet.getRow(rowNum).getCell((short) colNum);// ��õڶ�����Ԫ��
				cell.setCellStyle(cellStyle);
				cell.setCellValue("�ϲ��е�Ԫ��");
			}		
			fOut = new FileOutputStream(file);// �½�һ����ļ���
			workbook.write(fOut);// ������������д��ָ����Excel�ļ���
			fOut.flush();
			fOut.close();// �����������ر��ļ�
			System.out.println("Excel�ļ������ɹ���\nExcel�ļ��Ĵ��·��Ϊ��"
					+ file.getAbsolutePath());
		} catch (Exception e) {
			System.out.println("Excel�ļ�" + file.getAbsolutePath()
					+ "����ʧ��\n��ԭ��Ϊ��" + e);
		} finally {
			if (fOut != null) {
				try {
					fOut.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		GenerateExcel excel = new GenerateExcel();
		String fileName = "D://Excel.xls";
		excel.createExcel(fileName);
	}

}
