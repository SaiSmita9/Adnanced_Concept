package data_driver_framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class TestDDT1 {
 
	XSSFWorkbook workbook;
    XSSFSheet sheet;
   // XSSFCell cell;
    WebDriver driver;
int numrow;
/*String username;
String password;*/
 
@BeforeTest
public void Setup()
 
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Smita\\eclipse-workspace\\Advanced_Concept\\drivers\\chromedriver.exe");
driver=new ChromeDriver();
driver.get("http://www.newtours.demoaut.com");
//driver.manage().window().maximize();
}
 
@Test(dataProvider="TestDataFeed")
public void TestFireFox(String username,String password)
 
{
	
	WebElement un=driver.findElement(By.name("userName"));
	un.sendKeys(username);
	WebElement pwd=driver.findElement(By.name("password"));
	pwd.sendKeys(password);
	WebElement login=driver.findElement(By.name("login"));
	login.click();
	//driver.findElement(By.linkText("SIGN-OFF")).click();
	//driver.close();
}
 
@DataProvider
public Object[][] TestDataFeed(){
 
try {
 
	  File src=new File("C:\\Users\\Smita\\eclipse-workspace\\Advanced_Concept\\utilities\\mercury_login.xlsx");
		 // Load the file.
		    FileInputStream fis = new FileInputStream(src);
		 // Load he workbook.
		    workbook= new XSSFWorkbook(fis);
		    // Load the sheet in which data is stored.
			 sheet= workbook.getSheet("Sheet1");
}
catch (Exception e)
 
{
e.printStackTrace();
}
 int col_num=sheet.getRow(0).getLastCellNum();
  numrow=sheet.getLastRowNum();
// Create 2 D array and pass row and columns
Object [][] mercurydata=new Object[numrow][col_num];
 
for(int i=0; i<=sheet.getLastRowNum()-1; i++)
{
	 for(int j=0; j<=sheet.getRow(0).getLastCellNum()-1; j++) 
	 {
		 /*cell = sheet.getRow(i).getCell(j);
		 System.out.print(cell+"\t");*/
		mercurydata[i][j]=sheet.getRow(i).getCell(j);
		System.out.print(mercurydata[i][j]+"\t");
	 }
	
	 System.out.println();
}	

/*
// Fetch first row username
mercurydata[i][0]=sheet.getCell(0,i).getContents();
// Fetch first row password
mercurydata[i][1]=sheet.getCell(1,i).getContents();
 */

 
// Return 2d array object so that test script can use the same
return mercurydata;

}
 
@AfterTest
public void QuitTC(){
 
// close browser after execution
//driver.quit();
}
}