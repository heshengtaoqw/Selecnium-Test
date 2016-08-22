package testNG_Baidu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;


public class BaiduLogin {
	
	
  @Test
  public void f() {
		
			
			WebDriver browser = new FirefoxDriver();
			browser.get("https://www.baidu.com");
			WebElement findLoginButton = browser.findElement(By.linkText("µÇÂ¼"));
			findLoginButton.click();
			
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			WebElement findUserName = browser.findElement(By.id("TANGRAM__PSP_8__userName"));
			findUserName.sendKeys("aa740578857");
			WebElement findPassWord = browser.findElement(By.id("TANGRAM__PSP_8__password"));
			findPassWord.sendKeys("36330206qw");
			WebElement findLoginSubmit = browser.findElement(By.id("TANGRAM__PSP_8__submit"));
			findLoginSubmit.click();
			
			System.out.println("running completed, the window will be closed in 3 seconds");
			
			try
			{Thread.sleep(10000);}
			catch(Exception e)
			{e.printStackTrace();}
			
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("start");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println("over");
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
