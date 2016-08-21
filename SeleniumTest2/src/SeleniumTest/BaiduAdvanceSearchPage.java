package SeleniumTest;

import java.sql.Driver;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;

public class BaiduAdvanceSearchPage {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		WebDriver browser = new FirefoxDriver();
		browser.get("http://tieba.baidu.com/f/search/adv");
		
		WebElement findBaName = browser.findElement(By.xpath("html/body/div[3]/div/form/table[1]/tbody/tr[1]/td[3]/input[1]"));
		findBaName.sendKeys("Study");
		
		WebElement findOrderMethod = browser.findElement(By.xpath("html/body/div[3]/div/form/table[2]/tbody/tr[1]/td[3]/select"));
		java.util.List <WebElement> order = findOrderMethod.findElements(By.tagName("option"));
		
		for(int i = 0; i<order.size(); i++)
		{
			if(order.get(i).getText().equals("按时间顺序"))
			{
				order.get(i).click();
			}
		}
		
		WebElement findPageNum = browser.findElement(By.xpath("html/body/div[3]/div/form/table[2]/tbody/tr[2]/td[3]/select"));
		java.util.List <WebElement> pageNum = findPageNum.findElements(By.tagName("option"));
		
		for(int j = 0; j<pageNum.size(); j++)
		{
			if(pageNum.get(j).getText().equals("每页显示30条"))
			{
				pageNum.get(j).click();
			}
		}
		
		WebElement findSubmitButton = browser.findElement(By.xpath("html/body/div[3]/div/form/table[1]/tbody/tr[1]/td[3]/input[2]"));
		findSubmitButton.submit();
		
		browser.close();
	}

}
