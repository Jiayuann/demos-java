import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
	/** ��Excel�ļ����� */
	public void showExcel(String excelName) {
		File file = new File(excelName);
		FileInputStream in = null;
		try {
			// ������Excel�������ļ�������
			in = new FileInputStream(file);
			HSSFWorkbook hwb = new HSSFWorkbook(in);
			HSSFSheet sheet = hwb.getSheet("myFirstExcel");// ����ָ�������������ô�Excel�е���Ч������
			// ��ȡExcel �����������
			System.out.println("������Excel�ļ�" + file.getAbsolutePath() + "�����ݣ�");
			HSSFRow row = null;
			HSSFCell cell = null;
			int rowNum = 0; 	// �б�
			int colNum = 0; 	// �б�
			for (; rowNum < 9; rowNum++) {
				// ��ȡ��rowNum��
				row = sheet.getRow((short) rowNum);
				for (colNum = 0; colNum < 5; colNum++) {
					cell = row.getCell((short) colNum);// ���ݵ�ǰ�е�λ��������һ����Ԫ�����
					System.out.print(cell.getStringCellValue() + "\t");// ��ȡ��ǰ��Ԫ���е�����
				}
				System.out.println(); // ����
			}
			in.close();
		} catch (Exception e) {
			System.out
					.println("��ȡExcel�ļ�" + file.getAbsolutePath() + "ʧ�ܣ�" + e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	public static void main(String[] args) {
		ReadExcel excel = new ReadExcel();
		String excelName = "D://Excel.xls";
		excel.showExcel(excelName);
	}
}
