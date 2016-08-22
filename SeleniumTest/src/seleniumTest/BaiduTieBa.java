package seleniumTest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;;


public class BaiduTieBa {
	public static void main(String args[])
	{
		WebDriver browser = new FirefoxDriver();
		browser.get("http://tieba.baidu.com/f/search/adv");
		WebElement FindTieBaName = browser.findElement(By.xpath("//input[@class='i']"));
		
		
		FindTieBaName.sendKeys("selenium");
		
		WebElement findOrderMethod = browser.findElement(By.xpath("html/body/div[3]/div/form/table[2]/tbody/tr[1]/td[3]/select"));	
		java.util.List<WebElement> option = findOrderMethod.findElements(By.tagName("option"));
		
		for(int i = 0; i < option.size(); i++)
		{
			if(option.get(i).getText().equals("按相关性排序"))
			{
				option.get(i).click();
			}
		}
		
		WebElement findShowNum = browser.findElement(By.xpath("html/body/div[3]/div/form/table[2]/tbody/tr[2]/td[3]/select"));
		java.util.List <WebElement> number = findShowNum.findElements(By.tagName("option"));
		for (int j = 0; j < number.size(); j++)
		{
			if(number.get(j).getText().equals("每页显示30条"))
			{
				number.get(j).click();
			}
		}
		
		
		browser.findElement(By.xpath("/html/body/div[3]/div/form/table[1]/tbody/tr[1]/td[3]/input[2]")).submit();
		
		
		//browser.findElement(By.linkText("问题反馈")).click();
		
		/*
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		FindTieBaName.clear();
		FindTieBaName.sendKeys("selenium1");
		*/
		browser.close();
		
	}
	
}
