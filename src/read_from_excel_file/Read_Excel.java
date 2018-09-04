package read_from_excel_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
 
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 

 public class Read_Excel {

	public WebDriver driver;
	

	 public static void main(String[] args) throws Exception{
	 
		 String cell;
	 
	  // Specify the file path which you want to create or write
	 
	  File src=new File("C:\\Users\\Smita\\eclipse-workspace\\Advanced_Concept\\utilities\\mercury_login.xlsx");
	 
	  // Load the file
	 
	  FileInputStream fis=new FileInputStream(src);
	 
	   // load the workbook
	 
	   XSSFWorkbook wb=new XSSFWorkbook(fis);
	 
	  // get the sheet which you want to modify or create
	 
	   XSSFSheet sh1= wb.getSheetAt(0);
	 
	 // getRow specify which row we want to read and getCell which column
	/* 
	 System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());
	 
	 System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());
	 
	 System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
	 
	 System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
	 
	 System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
	 
	 System.out.println(sh1.getRow(2).getCell(1).getStringCellValue());
	*/
	   for(int i=1; i<=sh1.getLastRowNum(); i++)
		 {
			 for(int j=1; j<=sh1.getLastRowNum(); j++) 
			 {
				 cell = sh1.getRow(i).getCell(j).getStringCellValue();
				 System.out.println(cell);
			
			 }
		
		 }	
	 }
	 
	
	 
	}

