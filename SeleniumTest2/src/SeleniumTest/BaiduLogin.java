package SeleniumTest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;

public class BaiduLogin {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		WebDriver browser = new FirefoxDriver();
		browser.get("https://www.baidu.com");
		
		WebElement findLoginButton = browser.findElement(By.linkText("登录"));
		findLoginButton.click();
		
		WebElement findUserName = browser.findElement(By.id("TANGRAM__PSP_8__userName"));
		findUserName.sendKeys("aa740578857");
		
		WebElement findPassword = browser.findElement(By.id("TANGRAM__PSP_8__password"));
		findPassword.sendKeys("36330206qw");
		
		
		WebElement findSubmitButton = browser.findElement(By.id("TANGRAM__PSP_8__submit"));
		findSubmitButton.submit();
		
		try 
		{Thread.sleep(10000);}
		catch (Exception e)
		{ e.printStackTrace();}
		
		browser.close();
	}

}
