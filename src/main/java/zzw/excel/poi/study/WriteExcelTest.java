package zzw.excel.poi.study;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 数据写入本地excel
 * 
 * @author zzw
 * @date 2017年10月25日 上午11:00:27
 */
public class WriteExcelTest {

	public static void main(String[] args) {
		/** 创建空excel文件对象 */
		XSSFWorkbook workbook = new XSSFWorkbook();
		/** 创建空sheet */
		XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");
		/** 输出默认的单元格宽度、高度等 */
		System.out.println(spreadsheet.getDefaultColumnWidth() + "\t" + spreadsheet.getDefaultRowHeight() + "\t"
				+ spreadsheet.getDefaultRowHeightInPoints());
		/** 设置单元格默认宽度 */
		spreadsheet.setDefaultColumnWidth(16);

		/** 准备写入excel的数据 */
		Map<String, Object[]> empinfo = new TreeMap<String, Object[]>();
		empinfo.put("1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
		empinfo.put("2", new Object[] { "tp01", "Gopal", "Technical Manager" });
		empinfo.put("3", new Object[] { "tp02", "Manisha", "Proof Reader" });
		empinfo.put("4", new Object[] { "tp03", "Masthan", "Technical Writer" });
		empinfo.put("5", new Object[] { "tp04", "Satish", "Technical Writer" });
		empinfo.put("6", new Object[] { "tp05", "Krishna", "Technical Writer" });
		// 循环写入
		Set<String> keyid = empinfo.keySet();
		int rowid = 0;
		for (String key : keyid) {
			XSSFRow row = spreadsheet.createRow(rowid++);
			Object[] objectArr = empinfo.get(key);
			int cellid = 0;
			for (Object obj : objectArr) {
				XSSFCell cell = row.createCell(cellid++);

				cell.setCellValue((String) obj);
			}
		}

		/** 创建字体对象 */
		Font ztFont = workbook.createFont();
		/** 设置字体为斜体字 */
		ztFont.setItalic(true);
		/** 将字体设置为红色 */
		ztFont.setColor(Font.COLOR_RED);
		/** 将字体大小设置为16px */
		ztFont.setFontHeightInPoints((short) 16);
		/** 设置字体名称 */
		ztFont.setFontName("楷体");

		/** 设置单元格样式样式 */
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		/** 单元格内容居中 */
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		/** 设置前景色 即填充颜色 13：黄色(可去jar包内查看) */
		cellStyle.setFillForegroundColor((short) 13);
		/** 设置填充方式 */
		cellStyle.setFillPattern(FillPatternType.forInt(1));
		/** 设置字体对象 */
		cellStyle.setFont(ztFont);
		/** 输出某一行的样式 */
		XSSFRow row = workbook.getSheetAt(0).getRow(0);
		int countCell = row.getPhysicalNumberOfCells();
		for (int i = 0; i < countCell; i++) {
			row.getCell(i).setCellStyle(cellStyle);
			/** 输出填充方式与填充颜色 */
			/** System.out.println("\t" + row.getCell(i).getCellStyle().getFillPattern() + "\t"
					+ row.getCell(i).getCellStyle().getFillForegroundColor()); */
		}

		/** 将数据写到本地excel文件中 */
		FileOutputStream out;
		try {
			out = new FileOutputStream(new File("WriteSheet.xlsx"));
			workbook.write(out);
			out.close();
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Writesheet.xlsx written successfully");
	}

}
