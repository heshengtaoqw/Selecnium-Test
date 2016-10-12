package webElement;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BaiduHomePageElements {
	
	@FindBy(id="kw")
	public WebElement searchField;
	@FindBy(xpath = "//input[@value='�ٶ�һ��']")
	public WebElement searchButton;
	public BaiduHomePageElements(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}
}
