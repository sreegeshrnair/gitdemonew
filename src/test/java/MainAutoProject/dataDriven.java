package MainAutoProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public ArrayList<String> getdata(String TestCaseName) throws IOException
	{
	
		ArrayList<String> a = new ArrayList<String>();
		
		FileInputStream FIS = new FileInputStream ("/Users/sreegesh/eclipse-workspace/SeleniumFrameWorkDesign/Data/datainput.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(FIS);
		
		//Scan and get the testdata sheet
		int sheet_cnt = workbook.getNumberOfSheets();
		
		for (int i=0; i<sheet_cnt; i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i); //got the correct sheet
				Iterator<Row> rows = sheet.iterator(); //sheet is collection of rows
				Row firstrow = rows.next(); // getting the first row
				Iterator<Cell> ce = firstrow.cellIterator(); //cell iterator of the specific row
				int k = 0;
				int column=0;
				while(ce.hasNext())
				{
					Cell cell_val = ce.next(); //moving to the first cell in the first row
					if(cell_val.getStringCellValue().equalsIgnoreCase("Testcases"))
					{
						column=k;
					}
					k++;
					
				}
				System.out.println(column);
				while(rows.hasNext())
				{
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(TestCaseName))
					{
						Iterator<Cell> ci= r.cellIterator();
						while(ci.hasNext())
						{
							Cell c = ci.next();
							if(c.getCellType()==CellType.STRING)//Checking for cell type is String or not
							{
								a.add(c.getStringCellValue());
							}
							else
							{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));//number to text is package to convert number to text
								
							}
							
						}
					}
					
				}
			}
			
		}
		return a;
	}
	public static void main(String[] args) throws IOException {
	

	}

}
