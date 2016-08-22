package seleniumTest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import java.sql.*;


public class BaiduLogin {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		WebDriver browser = new FirefoxDriver();
		browser.get("https://www.baidu.com");
		WebElement findLoginButton = browser.findElement(By.linkText("µÇÂ¼"));
		findLoginButton.click();
		
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
		
		browser.close();
		
		
	}

}
