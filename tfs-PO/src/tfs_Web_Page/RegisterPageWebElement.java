package tfs_Web_Page;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tfs_Web_Page.HomePageWebElement;

public class RegisterPageWebElement {
	
	public WebDriver driver;
	
   @FindBy(xpath="//span[contains(text(),'½è¿îµÇ¼Ç')]")
   public WebElement menuButton;
   
	public RegisterPageWebElement(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   
   
   
}
