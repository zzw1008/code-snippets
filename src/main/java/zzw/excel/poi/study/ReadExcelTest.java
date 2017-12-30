package zzw.excel.poi.study;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * 读取excel文件：读取所有sheet、row、cell
 * @author zzw
 * @date 2017年10月25日 上午9:24:43
 */
public class ReadExcelTest {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "/file/WriteSheet.xlsx";
		File file = new File(path);
		if (file.isFile() && file.exists()) {
			System.out.println("存在此文件");
		} else {
			System.out.println("文件不存在");
		}
		FileInputStream fIP = null;
		try {
			fIP = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fIP);
			/** 获取所有sheet */
			XSSFSheet sheet = null;
			int countSheet = workbook.getNumberOfSheets();
			for (int i = 0; i < countSheet; i++) {
				sheet = workbook.getSheetAt(i);
				int countRow = sheet.getPhysicalNumberOfRows();
				for (int j = 0; j < countRow; j++) {
					/** 获取某一sheet下的所有row(行) */
					XSSFRow row = sheet.getRow(j);
					int countCell = row.getPhysicalNumberOfCells();
					for (int k = 0; k < countCell; k++) {
						/** 输出某一row下的所有cell(单元格)内容 */
						System.out.print(row.getCell(k) + "\t");
					}
					System.out.println("---Sheet表" + i + "处理完毕---");
					workbook.close();
					fIP.close();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("openworkbook.xlsx file open successfully.");
	}

}

