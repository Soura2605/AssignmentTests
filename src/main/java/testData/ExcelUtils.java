package testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static Object[] fetchData(String testCaseName) throws IOException {
		
		
		ArrayList<String> data = new ArrayList<String>();
		FileInputStream file = new FileInputStream("/Users/souradipgoswami/eclipse-workspace/EcommWebsiteTesting/TestData.xlsx");
		
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		int sheets=workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("Test_Data")) {
				
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator<Row> rows=sheet.iterator();
				Row firstRow=rows.next();
				
				Iterator<Cell> ce=firstRow.cellIterator();
				int k=0;
				int colomn=0;
				while(ce.hasNext()) {
					
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCaseName")) {
						
						colomn=k;
					}
					k++;
				}
				
				while(rows.hasNext()) {
					
					Row r=rows.next();
					if(r.getCell(colomn).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						
						Iterator<Cell> cv=r.iterator();
						cv.next();
						while(cv.hasNext()) {
							
							
							data.add(cv.next().getStringCellValue());
						}
					}
				}
				}
			}
		return data.toArray();
		}
	}

	

