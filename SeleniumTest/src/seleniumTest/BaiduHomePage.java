package seleniumTest;

import java.sql.Driver;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;


public class BaiduHomePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.print("sdfsdfsdf");
		
	System.setProperty("webDriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
	//在百度首页搜素  JAVA + SELENIUM
		
		String searchCondition = "JAVA + SELENIUM";
		WebDriver browser = new FirefoxDriver();
		Navigation navigation = browser.navigate();
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
		
		browser.quit();
	
		
		
	}

}
