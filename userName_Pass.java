package LoginPageOHRM;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class userName_Pass {

	public static void main(String[] args) throws IOException {
		
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	File file=new File("E:\\OrangeHrm Project\\OrangeHRM_Project_Login_Admin\\src\\test\\java\\TestData\\LoginData.xlsx");
	
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet= wb.getSheet("Sheet1");
	int rowcount= sheet.getLastRowNum();
	int colcount=sheet.getRow(0).getLastCellNum();
	System.out.println("Rowcount :"+rowcount+ "ColumnCount" +colcount);
	
	for (int i=1;i<=rowcount;i++)
	{
		XSSFRow cellData=sheet.getRow(i);
		String UserName= cellData.getCell(0).getStringCellValue();
		String Password=cellData.getCell(1).getStringCellValue();
		
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(UserName);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(Password);
		
		
		System.out.println("UserName"+UserName+"Password:"+Password);
		
	}
	
	
	
	driver.close();
	
	
	
	

	}

}



	


