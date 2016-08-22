package seleniumTest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver.*;


public class TestAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver browser = new FirefoxDriver();
		browser.get("E:\\project_workspace\\TestPage.html");
		
		WebElement alert = browser.findElement(By.xpath("html/body/input[1]"));
		alert.click();
		
		try
		{Thread.sleep(5000);}
		catch(Exception e)
		{ e.printStackTrace();}
		
		browser.switchTo().alert().accept();
		
		WebElement confirmation = browser.findElement(By.xpath("html/body/input[2]"));
		confirmation.click();
		try
		{Thread.sleep(5000);}
		catch(Exception e)
		{ e.printStackTrace();}
		browser.switchTo().alert().accept();
		
	
		
		confirmation.click();
		browser.switchTo().alert().dismiss();
		try
		{Thread.sleep(5000);}
		catch(Exception e)
		{ e.printStackTrace();}
		
		WebElement prompt = browser.findElement(By.xpath("/html/body/input[3]"));
		prompt.click();
		browser.switchTo().alert().sendKeys("Tell me something");
		
		try
		{Thread.sleep(5000);}
		catch(Exception e)
		{ e.printStackTrace();}
		
		String propmtText = browser.switchTo().alert().getText(); //获取的是alert的onclick的文本值，而不是输入的值
		System.out.println(propmtText);
		

	}

}
