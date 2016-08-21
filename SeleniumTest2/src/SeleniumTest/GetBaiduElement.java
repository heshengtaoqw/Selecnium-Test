package SeleniumTest;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;


public class GetBaiduElement {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		
		
		WebDriver browser = new FirefoxDriver();
		browser.get("https://www.baidu.com");
		WebElement findMap = browser.findElement(By.name("tj_trmap"));
		WebElement finfLoginButton = browser.findElement(By.linkText("登录"));
		finfLoginButton.click();
		WebElement findBaiduSearchButton = browser.findElement(By.id("su"));
		String s = browser.findElement(By.id("su")).getAttribute("value");
		WebElement findCheckBox = browser.findElement(By.id("TANGRAM__PSP_8__memberPass"));
		
		try
		{
			browser.findElement(By.xpath("//*[@id=\"u1\"]/a[9]")).click();
		}
		catch (Exception e)
		{
			
		}
		
		java.util.List <WebElement> elements = browser.findElements(
                By.xpath("//*[@id=\"head\"]/div/div[4]/div/div[2]/div[1]/div/a"));
		
		for(int i =0 ;i<elements.size();i++)
		{
			System.out.println(elements.get(i).getText() + "--" + elements.get(i).isDisplayed());
			
		}
		
		/*
		try
		{Thread.sleep(5000);}
		catch(Exception e)
		{ e.printStackTrace();}
		*/
		
		
		
		String url = browser.getCurrentUrl();
		//String source = browser.getPageSource();
		String title = browser.getTitle();
		String getText = findMap.getText();
		Boolean getCheckBoxStatus = findCheckBox.isSelected();
		String getBaiduSearchButtonName = findBaiduSearchButton.getAttribute("value");
		Boolean getMapDisplay = findMap.isDisplayed();
		Boolean getMapEnable = findMap.isEnabled();
		
		
		System.out.println("Title is " + title);
		System.out.println("Current URL is " + url);
		//System.out.println("Source is " + source);
		System.out.println("SearchText is " + getText);
		System.out.println("CheckBoxStatus is " + getCheckBoxStatus);
		System.out.println("ButtonAttributeName is " + getBaiduSearchButtonName);
		System.out.println("Map is dispalyed " + getMapDisplay);
		System.out.println("Map is enabled " + getMapEnable); 
		System.out.println(s);

		
		browser.close();
		
		
		
		
	}

}
