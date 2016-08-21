package seleniumTestLoginModule;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		WebDriver browser1 = new FirefoxDriver();
		browser1.get("http://www.baidu.com");
		WebElement findLogin = browser1.findElement(By.linkText("登录"));
		findLogin.click();
		
		WebElement findAccountName = browser1.findElement(By.id("TANGRAM__PSP_8__userName"));
		WebElement findPassword = browser1.findElement(By.id("TANGRAM__PSP_8__password"));
		WebElement findSubmit = browser1.findElement(By.id("TANGRAM__PSP_8__submit"));
		
		findAccountName.sendKeys("123");
		findPassword.sendKeys("abc1234");
		try
		{findSubmit.submit();}
		catch(Exception e)
		{e.printStackTrace();}
		
		/*
		try
		{Thread.sleep(5000);}
		catch(Exception e)
		{e.printStackTrace();}
		*/
		System.out.println(browser1.findElement(By.id("TANGRAM__PSP_8__error")).getText() + "1");
		
	}
	
}
