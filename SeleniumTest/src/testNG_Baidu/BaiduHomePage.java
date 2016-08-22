package testNG_Baidu;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.asserts.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;


public class BaiduHomePage {
	  @BeforeClass
	  public void beforeClass() 
	  {
		  
	  }
		
	  @Test
	  public void f() {
		  String searchCondition = "JAVA + SELENIUM";
			WebDriver browser = new FirefoxDriver();
			browser.get("https://www.baidu.com");
			
			WebElement findIdKw = browser.findElement(By.id("kw"));
			WebElement findIDSu = browser.findElement(By.id("su"));
			
			findIdKw.sendKeys(searchCondition);
			findIDSu.click();
			//navigation.back();
			
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			WebElement findRS = browser.findElement(By.className("tt"));
			String s = (findRS.getText());
			
			try
			{
				Assert.assertEquals(s, "Ïà¹ØËÑË÷", "Assertion Failed,");
			}
			catch(Exception e)
			{			
				e.printStackTrace();
			}
			
			browser.quit();
	  }
	  
	
	
	  @AfterClass
	  public void afterClass() {
	  }

}
