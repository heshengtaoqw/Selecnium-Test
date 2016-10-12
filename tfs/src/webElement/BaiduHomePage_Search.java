package webElement;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BaiduHomePage_Search {
	
	public WebDriver driver;
	@FindBy(id="kw")
	public WebElement searchField;
	@FindBy(xpath = "//input[@value='百度一下']")
	public WebElement searchButton;
	public BaiduHomePage_Search()
	{
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
	}
	public void load()
	{
		driver.get("https://www.baidu.com");
	}
	public void quit()
	{
		driver.quit();
	}
	public void search()
	{
		searchField.sendKeys("page Object search");
		searchButton.click();
	}
	
}
