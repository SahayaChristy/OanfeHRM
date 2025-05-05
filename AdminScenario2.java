package OrangeHRM_Project_Login_Admin.OrangeHRM_Project_Login_Admin;

import java.io.File;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	 WebDriver driver;
  @Test				//SearchByName
  public void Admin1() {
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("Adrian_Carter62");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
	  File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot, new File("SearchByUsername.jpeg"));
		System.out.println("Screenshot captured!!!");
	 
	  
  }
  @Test   //SearchByRole
  public void Admin2() {
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i")).click();
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).click();
	  
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
	  File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot, new File("SearchByRole.jpeg"));
		System.out.println("Screenshot captured!!!");
	 
	  
  }
  @Test   //SearchByStatus
  public void Admin2() {
	  driver.findElement(By.xpath("///*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")).click();
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")).click();
	  
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
	  File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot, new File("SearchByRole.jpeg"));
		System.out.println("Screenshot captured!!!");
	 
	  
  }
  @BeforeTest
  public void beforeTest() {
	  	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
