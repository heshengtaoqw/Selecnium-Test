package SeleniumTest;

import java.sql.Driver;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;

public class BaiduHomePage {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		String Text = "Selenium + Java";
		WebDriver browser = new FirefoxDriver();
		browser.get("https://www.baidu.com");
		
		WebElement findSearchConditon = browser.findElement(By.id("kw"));
		findSearchConditon.sendKeys(Text);	
		
		WebElement findSearchButton = browser.findElement(By.id("su"));
		findSearchButton.click();
		
		try 
		{
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		browser.close();
		
	}
}
